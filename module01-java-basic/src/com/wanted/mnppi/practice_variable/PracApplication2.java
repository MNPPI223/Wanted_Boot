package com.wanted.mnppi.practice_variable;

public class PracApplication2 {

    public static void main(String[] args) {

        // 변수 선언
        double side = 12.5;
        double high = 36.4;

        // 넓이 구하기
        double area = side * high;
        System.out.println("면적 : " + area);

        // 둘레 구하기
        double per = (side*2) + (high*2);
        System.out.println("둘레 : " + per);

        /* comment. 지수부와 가수부를 따로 저장하기 때문에 차이가 난다...
        *   이런 차이가 있다.*/


    }

}
