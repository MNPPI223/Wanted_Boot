package com.wanted.object.a_string;

public class Application01 {

    public static void main(String[] args) {

        /* comment.
        *   자료형은 크게 2가지 종류가 있다.
        *   1. 기본자료형 (ex : int, double, boolean 등)
        *   2. 참조자료형
        *   3. 사용자 정의의 자료형
        *  */

        /* comment. Stirng 에서 사용되는 다양한 메소드 */

        String str1 = "apple";

        // length() : 길이
        // charAt(index) : 문자열을 문자로 변환

        System.out.println(str1.length());

        // "apple" -> 'a', 'p', 'p' 이런 식으로 분리
        for(int i = 0; i < str1.length(); i++ ) {

            // 문자열 인덱스를 먹이면 각 인덱스의 문자열을 꺼내와줌
            System.out.println("charAt(" + i + ") : " + str1.charAt(i) );
        }

        // 속성 인자를 확인하자
        System.out.println("toUpper() : " + str1.toUpperCase());

        String trimStr = "   java   "; // 앞 뒤 공백 3번씩
        System.out.println("공백 자르기 전 확인 : #" + trimStr + "#"); // 공백 확인용
        System.out.println("공백 자르기 전 확인 : #" + trimStr.trim() + "#"); // 좌우 공백 삭제하기

    }

}
