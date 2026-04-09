package com.wanted.oop.f_keyword.b_singleton;

public class EagerSingleton {

    // 객체를 만드는 구문
    private static EagerSingleton eager = new EagerSingleton();

    // 기본 생성자
    // 단, 싱글톤은 1개의 인스턴스만 만드는 것이 목표이기 때문에
    // 외부에서 인스턴스 생성을 막기 위해 접근제한자(private)를 사용한다.
    private EagerSingleton() {}


    // public 메소드를 통해서 인스턴스가 필요할 때 반환해주는 메소드
    public static EagerSingleton getInstance() {
        return eager;
    }
}
