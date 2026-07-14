package com.wanted.polymorphism.b_interface;

public interface InterfaceProduct {

    /* comment.
        인터페이스는 구현부가 있는 메소드를 작성할 수 없다.
        또한 생성자 역시 가질 수 없다.
     */

        // 인터페이스는 생성자를 사용하지 못 한다.
//        public InterfaceProduct () {}

    // 인터페이스는 구현부가 있는 메소드를 사용하지 못한다.
//    public void test() {}


    void methodA();

    static void staticMethod() {
        // static 메소드는 구현부 작성이 가능하다.

    }



}
