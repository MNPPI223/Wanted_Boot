package com.wanted.oop.e_overloading;

public class OverLoadingTest {

    // 오버로딩을 이용한 메소드 작성 테스트를 위한 기준 메소드
    public void test() {}

    // 메소드의 시그니처가 동일하면 Error 발생시킨다.
//    public void test() {}

    // 접근 제한자를 변경해도 Error 발생
//    private void test() {}

    // 반환 타입을 변경해도 Error 발생
//    public int test() {return 0;}

    // 매개변수 유무에 따라 오버로딩 성립 확인 - 시그니처는 test(int num) 부분
    public void test(int num) {}

    // 매개변수 명은 메소드 시그니처의 영향을 주지 않는다.
//    public void test(int num2) {}

    // 매개변수 개수는 메소드 시그니처에 영향을 미친다.
    public void test (int num, String str) {}

    // 매개변수의 순서에 따른 오버로딩 성립 확인
    public void test (String str, int num) {}
}
