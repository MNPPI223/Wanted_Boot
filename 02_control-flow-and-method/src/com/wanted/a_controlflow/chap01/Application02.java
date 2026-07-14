package com.wanted.a_controlflow.chap01;

public class Application02 {

    public static void main(String[] args) {

        int age = 67;
        // 변수를 선언
        double discountRate;

        if (age < 13) {
            discountRate = 0.5; // 청소년 50% 할인
        } else if (age >= 65) {
            discountRate = 0.3; // 노약자 30% 할인
        } else {
            discountRate = 0.0;
        }
        System.out.println("나이 : " + age + ", 할인율 : " + (discountRate * 100) + "%");
    }

}
