package com.wanted.di.section03.gateway;

import org.springframework.stereotype.Component;

@Component
public class NaverPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("네이버페이로 결제 진행 시작 : 주문ID = " +  orderId + ", 금액 = " + amount);
        return true;
    }
}
