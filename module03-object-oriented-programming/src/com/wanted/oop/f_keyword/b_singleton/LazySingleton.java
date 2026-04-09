package com.wanted.oop.f_keyword.b_singleton;

public class LazySingleton {

    // 클래스 초기화 되는 시점에는 선언만 해두고
    // 기본값인 null 로 세팅을 해둔다.
    private static LazySingleton lazy;

    // 외부에서 객체를 생성할 수 없게 private 사용
    private LazySingleton() {}

    // 외부에서 객체 필요 시 호풀하기 위한 메소드
    public static LazySingleton getInstance() {
        /* 인스턴스를 만든 적이 없으면 생성해서 반환
            생성한 적이 있다면 원래 만들어둔 인스턴스 반환
         */
        if (lazy == null){
            lazy = new LazySingleton();
        }

        return lazy;

    }

}
