package com.wanted.mnppi.practice_operator;

import java.util.Scanner;

public class PracApplication6 {

    public static void main(String[] args) {

        /* 임의의 국어점수, 수학점수, 영어점수를 선언 및 초기화 하고
           세 과목에 대한 총점, 평균을 구하시오.
           각 과목 점수와 평균을 가지고 합격 여부를 판별하여 출력하시오.
           세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격,
           아니라면 불합격을 출력.
         */

        Scanner sc = new Scanner(System.in);

        // 국어 점수
        System.out.println("국어 : ");
        int language = sc.nextInt();
        // 엔터를 넣어서 오류 방지
        sc.nextLine();

        // 수학 점수
        System.out.println("수학 : ");
        int math = sc.nextInt();
        sc.nextLine();

        // 영어 점수
        System.out.println("영어 : ");
        int english = sc.nextInt();
        sc.nextLine();

        // 총점
        int sum = language + math + english;
        System.out.println("합계 : " + sum);
        // 평균
        double average = sum/3;
        System.out.println("평균 : " + average);


        // 조건문 작성하기
        if (language >= 40 && math >= 40 && english >= 40 && average >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }



    }

}
