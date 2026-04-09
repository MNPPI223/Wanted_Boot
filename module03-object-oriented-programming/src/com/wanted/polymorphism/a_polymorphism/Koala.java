package com.wanted.polymorphism.a_polymorphism;

public class Koala extends Animal{

    @Override
    public void eat() {
        System.out.println("코알라가 엄선된 풀을 뜯어먹습니다.");
    }

    @Override
    public void run() {
        System.out.println("아주 빠르게 뛰어갑니다!");
    }

    @Override
    public void bark() {
        System.out.println("예아");
    }

    public void tree() {
        System.out.println("코알라가 실수로 나무에서 떨어집니다....");
    }

}
