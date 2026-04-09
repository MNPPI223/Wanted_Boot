package com.wanted.polymorphism.a_polymorphism;

public class Raccoon extends Animal{

    @Override
    public void eat() {
        System.out.println("고양이의 사료를 훔쳐서 먹습니다!");
    }

    @Override
    public void run() {
        System.out.println("분리수거통으로 아주 빠르게 뛰어갑니다!");
    }

    @Override
    public void bark() {
        System.out.println("너구리 한 마리 몰고가세요~");
    }

    public void mad() {
        System.out.println("너구리가 미쳐 날뛰고있습니다!");
    }

}
