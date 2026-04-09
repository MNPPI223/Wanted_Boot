package com.wanted.c_method;

public class Application03 {

    public static void main(String[] args) {

    /* comment.
        전달인자(arguments)와 매개변수(parameter) 를 이용한 메서드 호출
        - 변수의 종류
        1. 지역 변수
        2. 매개 변수
        3. 전역 변수
        4. 클래스(static) 변수
        --- 구분선 ---
        지역변수는 선언한 메소드 블럭 내부에서만 사용이 가능하다.
        이것을 지역 변수의 scope 라고 한다.
        따라서 왜?
        다른 메소드들 간에 값의 공유가 필요할 때, 메소드 호출시 사용하는 괄호()를
        이용하여 값을 전달할 수 있다.
        이 때, 전달하는 값을 전달인자 라고 부르고
        메소드 선언부 괄호 안에 전달인자를 받기 위해 선언하는 변수를 매개변수라고 한다.
     */

        // 메소드 호출하기 위한 사전 준비
        Application03 app3 = new Application03();
//        app3.testMethod(40);

        /* 형변환 복습 : 암묵적 */

        byte byteAge = 10;
//        app3.testMethod(byteAge);

        /* 형변환 복습 : 명시적 */
        long longAge = 80;
        app3.testMethod((int) longAge * 3);


    }

    public void testMethod(int age){
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

}

// 17:35 까지 들었음