package com.wanted.mnppi.practice_variable;

public class PracApplication5 {

    public static void main(String[] args) {

        /* 국어 점수 80.5 / 수학 점수 50.6 / 영어 점수 70.8점을 실수 형태로
           저장한 뒤 총점과 평균을 정수 형태로 출력
         */

        double language = 80.5;
        double math = 50.6;
        double english = 70.8;

        // 총점
        double raw_sum = language + math + english;
        int sum = (int)raw_sum;
        System.out.println("총점 : " + sum);

        // 평균
        int ave = sum/3;
        System.out.println("평균 : " + ave);


        // 문제점 : int로 명시적으로 소수점을 절삭해서, 총점이 1점 깎여서
        // 나왔기 때문에 이를 해결하기 위해 int를 double로
    }

}
