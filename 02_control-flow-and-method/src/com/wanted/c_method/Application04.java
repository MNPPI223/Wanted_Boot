package com.wanted.c_method;

public class Application04 {

    public static void main(String[] args) {

        /* comment. 다른 클래스에 존재하는 메소드 호출하기 */

        /* 수업 종료 후 Scanner 객체로 변경해서 계산기 만들기 실습하기 */
        int first = 100;
        int second = 50;

        // 계산기 클래스 내부에 있는 메소드를 사용할 준비
        Calculator calc = new Calculator();

        int min = calc.minNumberOf(first, second);

        /* comment. static 선언한 메소드 호출 방법 맛보기
            다른 클래스에 작성한 static 메소드의 경우 호출 시
            클래스명을 반드시 기술해야 한다.
            - 사용방법 : 클래스명.메소드명();
         */
        int max = Calculator.maxNumberOf(first,second);

        System.out.println("두 수 중 최솟값은 : " + min + "입니다!");
        System.out.println("두 수 중 최댓값은 : " + max + "입니다!");

    }

}
