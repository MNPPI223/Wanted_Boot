package com.wanted.container.section01.service;

import com.wanted.container.section01.gateway.KakaoPayGateWay;
import com.wanted.container.section01.gateway.NaverPayGateWay;

public class PaymentService {

    private NaverPayGateWay payGateWay;

    public PaymentService() {
        this.payGateWay = new NaverPayGateWay();
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 비즈니스 로직 시작... 주문 ID = " + orderId + ", 금액 = " + amount);

        // 결제 게이트웨이를 통한 결제 처리
        boolean result = payGateWay.processPayment(orderId, amount);

        if (result) {
            System.out.println("✅결제 처리가 성공적으로 마무리!!✅");
        } else {
            System.out.println("🚨결제 처리가 실패했습니다...🚨");
        }
        return result;
    }

}
