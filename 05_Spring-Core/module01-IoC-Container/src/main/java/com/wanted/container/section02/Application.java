package com.wanted.container.section02;

import com.wanted.container.section02.config.AppConfig;
import com.wanted.container.section02.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* comment.
            IoC Container (제어의 역전)
            section01 에서는 개발자가 직접 new 키워드를 사용해서
            인스턴스를 생성했다.
            이렇게 되면 객체 간 결합도가 높아지게 되며, 유연성이 떨어지고,
            테스트 및 유지보수가 어렵다는 문제가 발생하게 된다.
         */

        System.out.println("============스프링 코어로 결제 기능 구현 ===============");

        /* comment.
            IoC Container == Application Context == Bean Factory
         */

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean() : 컨테이너에 등록 된 객체를 꺼낸다.
        PaymentService paymentService = context.getBean("paymentService", PaymentService.class);

        String orderId = "order-001";
        double amount = 15000.0;
        boolean result = paymentService.processPayment(orderId, amount);

        System.out.println("결제 결과 : " + (result ? "성공" : "실패"));
        System.out.println("======================================");

        // @Bean 이 싱글톤 인스턴스인지 확인하는 구문
        PaymentService paymentService2 = context.getBean(PaymentService.class);

        System.out.println("payment == payment2 : " + (paymentService == paymentService2));
    }

}
