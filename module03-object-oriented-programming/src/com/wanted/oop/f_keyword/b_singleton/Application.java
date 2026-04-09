package com.wanted.oop.f_keyword.b_singleton;

public class Application {

    public static void main(String[] args) {

        /* comment. static 키워드를 이용한 singleton 패턴
            어플리케이션이 실행 될 때 어떤 클래스가 최초 한 번만
            메모리에 할당 되고, 그 메모리에 인스턴스를 만들어서
            하나의 인스턴스를 공유해 사용하여 메모리 낭비를 방지할 수 있게
            하는 디자인 패턴이다.
         */

        /* comment. 싱글톤 패턴을 만드는 방법은 2가지가 있다.
            1. 이른 초기화 (Eager)
            2. 게으른 초기화 (Lazy)
         */

        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();


        // 두 객체는 static 키워드로 만든 객체이기 때문에 동일한 인스턴스임을 확인할 수 있다.
        System.out.println("eager1 의 주민번호 : " + eager1.hashCode());
        System.out.println("eager2 의 주민번호 : " + eager2.hashCode());

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        System.out.println("lazy1의 주민번호 : " + lazy1.hashCode());
        System.out.println("lazy2의 주민번호 : " + lazy2.hashCode());


    }

}
