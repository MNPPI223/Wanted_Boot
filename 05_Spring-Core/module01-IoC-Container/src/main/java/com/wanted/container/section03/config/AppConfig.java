package com.wanted.container.section03.config;

import com.wanted.container.section03.gateway.KakaoPayGateWay;
import com.wanted.container.section03.gateway.NaverPayGateWay;
import com.wanted.container.section03.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /* comment.
        @Bean 의 Scope 확인하기.
        1. 싱글톤 스코프(Singleton scope)
        - Spring default 설정이다. 객체(bean) 은 컨테이너 내에서 단일 인스턴스이다.
        - 모든 요청에 동일한 객체를 반환하기 때문에 메모리 효율적이며, 동일한 동작을 해야할 때 유용하다.
        - 주의 : 상태(필드값)를 가지게 된다면 모든 요청이 해당 필드를 공유하기 때문에 주의해야 한다.
        - private int a = 10;
     */

    @Bean("singlePay") // 메소드명이 아닌, 직접 이름을 명시할 수 있다. (명시 안 하면 method 명이 다름)
    @Scope("singleton") // default 설정이다. 작성하지 않아도 해당 구문이 생략되어 있다.
    public PaymentService paymentServiceSingle() {
        return new PaymentService(naverPayGateWay());
    }

    /* comment.
        프로토타입 스코프(Prototype Scope)
        - 요청 시마다 새로운 인스턴스를 생성한다.
        - 각 요청이 독립적인 상태를 유지해야 할 때 사용되며, 상태를 가지는 객체(DTO 같은게 대표적인 예시)에 적합하다.
        주의 : Bean 이 생성되면 컨테이너는 더 이상 관리하지 않는다. 따라서 메모리 해제 등을
        - 별도로 고려해야 한다.
     */
    @Bean("protoPay")
    @Scope("prototype") // 이 설정을 하게 되면, 더 이상 싱글톤으로 관리되지 않는다.
    public PaymentService paymentServiceProto() {
        return new PaymentService(naverPayGateWay());
    }

    @Bean
    public KakaoPayGateWay kakaoPayGateWay() {
        return new KakaoPayGateWay();
    }

    @Bean
    public NaverPayGateWay naverPayGateWay() {
        return new NaverPayGateWay();
    }

}
