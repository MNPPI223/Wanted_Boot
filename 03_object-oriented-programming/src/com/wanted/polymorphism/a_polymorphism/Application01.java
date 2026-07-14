package com.wanted.polymorphism.a_polymorphism;

public class Application01 {

    public static void main(String[] args) {

        /* comment.
            다형성이란?
            하나의 인스턴스가 여러가지의 타입을 가질 수 있는 것을 의미한다.
            그렇기 때문에 하나의 타입으로 여러 타입의 인스턴스를 처리할 수 있고
            하나의 메소드 호출로 객체별 다른 방법으로 동작할 수 있다.
         */

        System.out.println("========== Animal ============");

        System.out.println("야생의 동물이 등장합니다!");

        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.bark();

        System.out.println("========== Animal ============");

        System.out.println("야생의 라쿤이 등장합니다!");

        Raccoon raccoon = new Raccoon();
        raccoon.eat();
        raccoon.run();
        raccoon.bark();
        raccoon.mad();

        System.out.println("========== Animal ============");

        Koala koala = new Koala();

        System.out.println("야생의 코알라가 등장합니다!");

        koala.eat();
        koala.run();
        koala.bark();
        koala.tree();

        System.out.println("========== Animal ============");

        /* Is - A 관계 */
        Animal a1 = new Raccoon();
        Animal a2 = new Koala();

        // 안 되는 구문
//        Raccoon r1 = new Animal();

        /* comment. 동적바인딩
            컴파일 시점에는 해당 타입의 메소드와 연결 되어 있다가
            런타임 시점에 실제 객체가 가진 오버라이딩 된 메소드(koala, raccoon)로 변경되어
            동작하는 것을 의미한다.
        * */
        System.out.println("================ 동적 바인딩 확인 ================");
        a1.bark();
        a2.bark();

        // 실제 타입은 animal 이기 때문에 raccoon 의 고유 기능은 사용이 불가
//        a1.mad();

        System.out.println("=============== 클래스 형변환 ================");
        ((Raccoon)a1).mad();
        ((Koala)a2).tree();

    }
}
