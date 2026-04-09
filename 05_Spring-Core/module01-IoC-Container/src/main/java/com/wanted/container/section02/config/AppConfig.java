package com.wanted.container.section02.config;

import com.wanted.container.section02.gateway.KakaoPayGateWay;
import com.wanted.container.section02.gateway.NaverPayGateWay;
import com.wanted.container.section02.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* comment.
    IoC 컨테이너에게 해당 클래스가 Bean(객체) 설정 정보를 가지고 있는
    설정 클래스임을 알려주는 어노테이션이다.
    해당 클래스 자체도 Bean 으로 등록되어 IoC 컨테이너에서 객체로 관리된다.
    이 클래스의 역할은 하나 이상의 @Bean 메소드를 사용하여
    컨테이너가 어떤 객체를 등록할 지 알려주는 역할을 한다.
 */

@com.wanted.container.section02.config.Configuration
public class AppConfig {

    /* comment.
        @Bean 어노테이션을 사용하게 되면, 컨테이너에서 관리되는 객체의 이름은
        메서드 명이 된다.
        컨테이너에서 관리되는 @Bean 은 싱글톤으로 관리되어
        어플리케이션 전반에서 동일한 객체가 사용된다.
     */

    @Bean
    public KakaoPayGateWay kakaoPayGateWay() {
        return new KakaoPayGateWay();
    }

    @Bean
    public NaverPayGateWay naverPayGateWay() {
        return new NaverPayGateWay();
    }

    @Bean
    public PaymentService paymentService() {
//        return new PaymentService(kakaoPayGateWay());
        return new PaymentService(naverPayGateWay());
    }

}
