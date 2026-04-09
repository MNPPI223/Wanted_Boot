package com.wanted.object.b_array;

import java.util.Scanner;

public class Application02 {

    public static void main(String[] args) {

        /* comment. 배열을 활용한 여러 명의 Java 시험 점수 계산기 */

        /* 요구하상
            1. 5명의 Java 점수를 입력받는다.
            2. 점수를 입력 받아서 합계와 평균을 실수로 구하는 프로그램
         */

        // 5명의 Java 점수를 저장할 배열 생성
        int[] scores = new int[5];

        Scanner sc = new Scanner(System.in);

        // 배열의 연속적인 공간이라는 특성을 활용하여 반복문을 써보자.
        for (int i = 0; i < scores.length; i++ ) {
            // 개발자가 아닌 사람은 0부터 시작하는 번호체계가
            // 매우 낯설다.
            System.out.print((i+1) + "번 째 학생의 점수를 입력해주세요.");
            scores[i] = sc.nextInt();
            sc.nextLine();
        }

        // 합계와 평균을 담을 변수 선언
        double sum = 0.0;
        double average = 0.0;

        // 합계란? 모든 배열의 인덱스 공간에 위치한 값을 sum 변수에 누적해서 더함.
        for (int i =0; i < scores.length; i++) {
            sum += scores[i];
        }

        // 평균 합계에서 배열의 길이만큼 나눈다.
        average = sum / scores.length;

        System.out.println("5명 점수의 합계 : " + sum);
        System.out.println("5명 점수의 평균 : " + average);
    }
}

