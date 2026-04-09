package com.wanted.oop.f_keyword.a_static;

public class StaticFieldTest {

    private int nonStaticCount;
    private static int staticCount;

    // 기본 생성자
    public StaticFieldTest() {}

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    /* 각 필드를 호출 시 마다 1씩 증가시키는 용도의 메소드 */
    public void increaseNonStatic() {
        this.nonStaticCount++;
    }

    public void increaseStatic() {
        // 클래스명.변수명
        StaticFieldTest.staticCount++;
    }

}
