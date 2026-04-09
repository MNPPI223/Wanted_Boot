package com.wanted.b_loop.chap02;

public class Application02 {

    public static void main(String[] args) {

        /* do-while 문
           - 실행 코드를 최소 1회는 실행한 후 조건식을 확인하는 반복문이다.
           - 형식 : do { 실행 코드 } while (조건식);
           - 조건이 처음부터 false 여도 무조건 1회는 실행하는 것을 보장한다.
         */

        int num = 0;
        do {
            System.out.println("실행 : " + num);
            num++;
        } while(num < 3);

    }

}
