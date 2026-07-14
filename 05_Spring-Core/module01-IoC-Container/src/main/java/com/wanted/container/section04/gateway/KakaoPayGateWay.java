package com.wanted.container.section04.gateway;

public class KakaoPayGateWay implements PaymentInterface {


    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제 진행 시작 : 주문ID = " +  orderId + ", 금액 = " + amount);
        return false;
    }
}
