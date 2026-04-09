package com.wanted.mnppi.practice_variable;

public class PracApplication1 {
    public static void main(String[] args) {

        /* 정수형 변수 2개를 선언하여 각 20과 30으로 초기화 한 후
           두 수의 더하기, 빼기, 곱하기, 나누기, 나머지를 다음과 같이 출력
         */

        // 정수형 변수 2개 선언 및 초기화
        int num1 = 20;
        int num2 = 30;

        // 더하기
        int sum = num1 + num2;
        System.out.println("더하기 결과 : " + sum);

        // 빼기
        int minus = num1 - num2;
        System.out.println("빼기 결과 : " + minus);

        // 곱하기
        int doubled = num1 * num2;
        System.out.println("곱하기 결과 : " + doubled);

        // 나누기
        int slash = num1 / num2;
        System.out.println("나누기 결과 : " + slash);

        // 나머지
        int left = num1 % num2;
        System.out.println("나머지 결과 : " + left);

    }
}
