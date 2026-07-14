package com.wanted.inheritance.extend;

// extends 키워드는 클래스 선언부에 작성한다.
public class CapsCar extends Car{

    public CapsCar() {
        System.out.println("CapsCar의 기본 생성자 호출됨...");
    }

    @Override
    public void run() {
        System.out.println("경찰차는 삐용삐용삐용하면서 달려가기 시작합니다....");
    }

    @Override
    public boolean isRunning() {
        return super.isRunning();
    }

    @Override
    public void soundHorn() {
        System.out.println("삐용삐용삐용~~ 다들 비키쇼");
        }
}
