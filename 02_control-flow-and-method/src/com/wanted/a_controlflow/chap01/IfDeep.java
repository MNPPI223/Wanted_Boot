package com.wanted.a_controlflow.chap01;

public class IfDeep {

    public static void main(String[] args) {

        /* if 문의 깊은 개념 - 메모리 구조와 실행
        * if 문은 JVM 의 스택에서 조건식을 계산하고, 그 결과(boolean)가 스택에 저장된다.
        * - 조건식이 true 면 해당 코드 블록으로 jump, false 면 다음 분기로 이동
        * - 복잡한 조건식(ex : a > b && c < d)은 단락 평가를 통해 최적화 된다.
        *
        * short-circuit evaluation(단축 평가)
        * AND 연산(&&) :
        * - 두 피연산자가 모두 참(true) 일 때만 전체 표현식이 참이다!
        * - 첫 번째 피연산자가 false일 경우, 두 번째 피연산자를 평가할 필요가 없기 때문에
        * 평가를 중단한다.
        *
        * OR 연산(||) :
        * - 두 피연산자 중 하나라도 true 일 경우, 전체 표현식이 참이다!
        * - 첫 번째 피연산자가 true 일 경우, 두 번째 피연산자를 평가할 필요가 없다.
        *
        * 메모리 관점
        * - 조건식의 변수들은 스택에 저장이 되며, 너무 많은 중첩 if 문은 스택 사용량을
        * 늘리고 가독성 또한 떨어트린다.
        * */

        int age = 25; //테스트용 변수 선언 및 초기화
        String discount; // 변수 선언

        // 비효율적 조건 순서 테스트 : 발생 확률이 드문 조건 먼저
        // age 가 19와 같은 지 비교 후 else 검사
        System.out.println("============== 비효율적 조건 순서 ==============");
        long startTime = System.nanoTime(); // 시작 시간 체크

        if(age <= 19) { // 드문 조건
            discount = "학생 할인 가능";
        } else {
            discount = "할인 불가";
        }

        long endTime = System.nanoTime(); // 끝나는 시간 체크
        System.out.println("결과 : " + discount + ", 시간 : " + (endTime - startTime) + "(ns)");


        System.out.println("============== 효율적 조건 순서 ==============");
        long startTime2 = System.nanoTime(); // 시작 시간 체크

        if(age > 19) { // 자주 발생 조건
            discount = "학생 할인 가능";
        } else {
            discount = "할인 불가";
        }

        long endTime2 = System.nanoTime(); // 끝나는 시간 체크
        System.out.println("결과 : " + discount + ", 시간 : " + (endTime2 - startTime2) + "(ns)");

    }

}
