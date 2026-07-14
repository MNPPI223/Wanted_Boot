package com.wanted.di.section01.service;

import com.wanted.di.section01.gateway.PaymentInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/* comment.
    @Service 어노테이션
    - @Component 의 특수한 형태다. 서비스 계층에 속하는 Bean 을 명시한다.
    - 역할 : 비즈니스 로직을 처리하는 클래스
 */

@Service
public class PaymentService {

    private final PaymentInterface naverPayGate;

    public PaymentService(@Qualifier("naverPayGateWay") PaymentInterface naverPayGate) {
        this.naverPayGate = naverPayGate;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 비즈니스 로직 시작... 주문 ID = " + orderId + ", 금액 = " + amount);

        // 결제 게이트웨이를 통한 결제 처리
        boolean result = naverPayGate.processPayment(orderId, amount);

        if (result) {
            System.out.println("✅결제 처리가 성공적으로 마무리!!✅");
        } else {
            System.out.println("🚨결제 처리가 실패했습니다...🚨");
        }
        return result;
    }

}
