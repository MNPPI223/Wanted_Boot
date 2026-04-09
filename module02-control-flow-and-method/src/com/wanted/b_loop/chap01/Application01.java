package com.wanted.b_loop.chap01;

public class Application01 {

    public static void main(String[] args) {

        /* for 문
           for 문은 초기값, 조건식, 증감식을 사용해 반복의 횟수를
           제어하는 반복문이다.
           형식 : for(초기식; 조건식; 증감식;) { 실행 코드 }
           - 초기식 : 반복 변수 선언 및 초기화
           - 조건식 : true 일 때 반복, false 일 때 종료
           - 증감식 : 반복 변수 값 변경
          */

        System.out.println("회원님 벤치 5번 반복 할게요");

        for (int i =1; i <= 5; i++) {
            System.out.println(i + "번 째입니다~~ 회원님");
        }

    }
}
