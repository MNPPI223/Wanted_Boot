package com.wanted.a_exception.a_basic;

public class Application {

    public static void main(String[] args) {

        System.out.println("프로그램 시작...");

        /* comment.
            예외처리를 하지 않으면, 프로그램 실행 중 발생한 예외로 인해
            프로그램이 비정상적으로 종료될 수 있다.
            예를 들어 사용자가 정수를 0으로 나누게 되면, 프로그램이 즉시 종료된며,
            사용자는 영문도 모른 채 해당 프로그램을 나갈 수 밖에 없다.
         */

        int num = 10;
        int result = num / 0;

        System.out.println("result = " + result);

        System.out.println("프로그램 종료...");
        
    }
    
}
