package com.wanted.container.section02.gateway;

public class NaverPayGateWay implements PaymentInterface{

    @Override
    public boolean processPayment(String orderId, double amount) {

        return true;
    }

    /**
     * 결제를 담당하는 메서드
     * @param orderId 주문 ID
     * @param amount 결제 금액
     * @return 결제 성공 여부
     */


}
