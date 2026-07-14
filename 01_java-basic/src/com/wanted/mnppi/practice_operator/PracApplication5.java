package com.wanted.mnppi.practice_operator;

import java.util.Scanner;

public class PracApplication5 {
    public static void main(String[] args) {

        /* 임의의 정수 한 개를 선언하고 해당 정수값이 13세 이하이면 "어린이"
           , 13세 초과 19세 이하이면 "청소년", 19세 초과이면 "성인"이 출력
           될 수 있도록 작성.
         */

        int age = 18;
        System.out.println("입력된 임의의 나이는 : " + age + "살 입니다.");

        if (age <= 13) {
            System.out.println("어린이");
        } else if (age > 13 && age <= 19) {
            System.out.println("청소년");
        } else if (age > 19) {
            System.out.println("성인");
        }


    }
}
