package com.wanted.b_loop.chap02;

public class Application {

    public static void main(String[] args) {

        /* while 문
           while 문은 조건식이 true 인 동안 코드를 반복 실행한다.
           형식 : while(조건식) { 실행될 코드, 증감식 }
           반복 횟수가 불확실하거나, 조건에 따라 종료해야 할 때 유용하다.
         */

        int count = 0;

        while (count < 5) {
            System.out.println("카운트 : " + count);
            count++;

        }

    }

}
