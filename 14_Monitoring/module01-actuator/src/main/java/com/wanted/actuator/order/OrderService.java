package com.wanted.actuator.order;

import com.wanted.actuator.metric.ShopMetrics;
import com.wanted.actuator.order.dto.CreateOrderRequest;
import com.wanted.actuator.order.dto.OrderResponse;
import com.wanted.actuator.payment.PaymentService;
import com.wanted.actuator.product.Product;
import com.wanted.actuator.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.micrometer.core.instrument.Timer;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PaymentService paymentService;
    /* comment.
        우리가 만든 Custom Metric 을 비즈니스 코드에 끼워넣기 위한 준비과정
     */
    private final ShopMetrics shopMetrics;

    public OrderService(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            PaymentService paymentService,
            ShopMetrics shopMetrics
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.paymentService = paymentService;
        this.shopMetrics = shopMetrics;
    }

    /* comment.
        우리가 만든 커스텀 Metric (주문 생성 시간 확인)
        비즈니스 코드에 넣기
     */

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        // 타이머 동작 시작
        Timer.Sample sample = shopMetrics.startTimer();
        long startedAt = System.nanoTime();

        // try 밖에서 반환해야 하므로 선언은 블록 위로 끌어올린다
        Order savedOrder = null;

        try{
            log.info("event=order_create_started itemTypes={}", request.items().size());
            Order order = new Order();
            long orderAmount = 0;

            for (CreateOrderRequest.Item item : request.items()) {
                Product product = findProduct(item.productId());
                product.decreaseStock(item.quantity());
                order.addItem(new OrderItem(product, item.quantity()));
                // 총 얼마만큼 계산을 해야하는지
                orderAmount += product.getPrice() * item.quantity();
            }

            paymentService.pay();

            savedOrder = orderRepository.save(order);
            // 주문 성공 시 기록 할 Metric
            shopMetrics.recordCreatedOrder(savedOrder.getItems().size(), orderAmount);
            log.info(
                    "event=order_create_succeeded orderId={} itemTypes={} amount={} durationMs={}",
                    savedOrder.getId(),
                    savedOrder.getItems().size(),
                    orderAmount,
                    elapsedMillis(startedAt)
            );
        }
        catch (RuntimeException exception) {
            // 주문 실패 시 생성할 Metric
            shopMetrics.recordFailedOrder(exception);
            // 실패 로그는 catch 안에서 찍어야 exception 변수에 접근할 수 있고, 실패한 경우에만 남는다
            log.warn(
                    "event=order_create_failed exceptionType={} message=\"{}\" durationMs={}",
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    elapsedMillis(startedAt)
            );
            // 예외를 다시 던져 트랜잭션 롤백시키고, savedOrder == null 인 채로 반환되는 NPE 도 차단
            throw exception;
        } finally {
            // 성공/실패와 관계없이 타이머는 항상 종료한다
            shopMetrics.stopOrderCreationTimer(sample);
        }

        return OrderResponse.from(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));
        return OrderResponse.from(order);
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
    }

    private long elapsedMillis(long startedAt) {
        return (System.nanoTime() - startedAt) / 1_000_000;
    }

}
