package com.wanted.object.a_string;

public class Application02 {

    public static void main(String[] args) {

        /* comment. 문자열 객체 만드는 방법
            1. "" 리터럴 형태 :
            2. new String("문자열")
         */

        String str1 = new String("java");
        String str2 = "java";
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        /* comment. 문자열의 동등비교 */
        System.out.println("str1 == str2 : " + (str1 == str2));

        // 문자열의 생성 방식과 상관 없이 동일한 문자열을 비교하고 싶다면
        // 이런 식으로 String 의 값 비교를 할 때는 equals() 메소드를 사용한다.
        System.out.println("str1.equals(str2) : " + str1.equals((str2)));
    }

}
