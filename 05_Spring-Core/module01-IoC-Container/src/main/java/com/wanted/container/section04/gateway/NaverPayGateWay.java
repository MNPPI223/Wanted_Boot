package com.wanted.container.section04.gateway;

public class NaverPayGateWay implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {

        return true;
    }


}
