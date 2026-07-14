package com.wanted.c_method;

public class Calculator {

    /* comment. 계산을 잘할 수 있는 메소드들의 집합체 */

    // 전달 받은 두 수를 비교해서 최솟값 반환하는 메소드
    public int minNumberOf(int first, int second){
        // first 는 100, second 는 50이 들어있는 상태.

        // 삼항연산자 : ture일 시 앞쪽 반환 / flase일 시 뒤쪽 반환
        return (first > second) ? second : first;

    }

    // 전달 받은 두 수를 비교해서 최댓값 반환하는 메소드
    public static int maxNumberOf(int first, int second){

        return (first > second) ? first : second;

    }

}
