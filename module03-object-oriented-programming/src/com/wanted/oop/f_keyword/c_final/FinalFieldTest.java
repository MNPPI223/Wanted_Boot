package com.wanted.oop.f_keyword.c_final;

public class FinalFieldTest {

    /* comment. final
        final 변경 불가의 의미를 갖는다.(종단)
        따라서 초기 인스턴스가 생성되고나면 기본값인 0이 들어가는데,
        초기화 이후에 값을 변경할 수 없기 때문에 선언과 동시에 초기화를
        해줘야한다.
     */

//    private final int NON_STATIC_NUM;

    // 1. final 키워드는 선언과 동시에 초기화 해야한다.
    private final int NON_STATIC_NUM = 1;

    // 2. 생성자를 이용한 초기화를 할 수 있다.
    private final String NON_STATIC_NAME;

    public FinalFieldTest(String name) {
        this.NON_STATIC_NAME = name;
    }


}
