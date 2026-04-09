package com.wanted.inheritance.extend;

public class Car {

    // 달리는 상태 체크
    private boolean runningStatus;

    public Car() {
        System.out.println("Car 클래스의 기본생성자 호출됨...");
    }

    public void run() {
        runningStatus = true;
        System.out.println("자동차가 아주 빠르게 달려갑니다!");
    }

    // 달리는 상태를 반환해주는 메소드
    public boolean isRunning() {
        return runningStatus;
    }

    // 경적을 울리는 메소드
    public void soundHorn(){
        if (isRunning()) {
            System.out.println("뛰뛰빵빵");
        } else {
            System.out.println("주행을 하고있지 않습니다. 경적을 울릴 수 없습니다!");
        }
    }

    public void stop(){
        runningStatus = false;
        System.out.println("자동차가 멈춥니다... 푸쉬....익...");
    }

}
