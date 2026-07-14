package com.wanted.a_generic.a_basic;

public class GenericTest <T> {

    /* comment.
        제네릭 설정하는 방법은 클래스 선언부 마지막에
        <> 다이아몬드 연산자를 사용한다.
        <T> T 는 타입 변수라고 불리우며 관례상 T 라고
        작성한다.
     */

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "GenericTest{" +
                "value=" + value +
                '}';
    }
}
