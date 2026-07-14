package com.wanted.container.section03.gateway;

public class NaverPayGateWay implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {

        return true;
    }


}
