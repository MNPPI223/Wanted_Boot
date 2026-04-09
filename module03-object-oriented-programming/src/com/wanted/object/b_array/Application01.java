package com.wanted.object.b_array;

public class Application01 {

    public static void main(String[] args) {

        /* comment. 배열이란?
            동일한 자료형의 묶음 이다.
            여기서 핵심 키포인트는 동일한 자료형!!
            배열은 heap 영역에 생성이 되며, new 연산자를 통해 할당한다.
            new 키워드는 앞으로 할당 연산자라고 부르겠다.
         */

        /* comment.
            배열의 사용이유
            1. 만약 배열을 사용하지 않는다면, 변수를 여러 개 만들어야 한다.
            2. 각각의 변수는 규칙이 없기 때문에 반복문을 통한 연속 처리가 불가능하다.
            ---- 
            배열의 사용 방법
            1. 자료형[] 변수명; , 자료형 변수명[] // 선언
            2. new int[크기]; , { 값들 } // 할당 
         */

         int[] iarr = new int[5];
        System.out.println("iarr = " + iarr);
        System.out.println("iarr 의 길이 = " + iarr.length);

        // 배열에 들어있는 값에 접근하는 방법
        System.out.println(iarr[0]);

        /* comment. 중요!! heap 공간은 값이 비어있을 수 없다.
            0이라는 값이 출력 되었다.
            그렇다는 것은 각 자료형 별 기본값으로 세팅이 된다 라는 것이다.
            ---
            정수 : 0
            실수 : 0.0
            논리 : false
            문자 :
            참조 : null
         */
        
    }

}
