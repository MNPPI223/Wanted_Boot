package com.wanted.container.section03.gateway;

/*
    카카오페이 결제 게이트웨이 구현체
    실제 결제 처리 담당하는 클래스
 */

public class KakaoPayGateWay implements PaymentInterface {


    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제 진행 시작 : 주문ID = " +  orderId + ", 금액 = " + amount);
        return false;
    }
}
