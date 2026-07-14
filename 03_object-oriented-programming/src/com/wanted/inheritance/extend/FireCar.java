package com.wanted.inheritance.extend;

public class FireCar extends Car {

    public FireCar( ) {
        System.out.println("FireCar 의 기본 생성자 호출됨...");
    }


    @Override
    public void soundHorn() {
        if(isRunning()) {
            System.out.println("뿌에에에에ㅔ에에에에에에에에에에에에ㅔ에에에에에에에에에엥");
        } else  {
            System.out.println("소방차는 멈추지 않아");
        }
    }

    /* 부모의 것을 가져다 쓸 수 있고, 본인만의 고유한 필드 or 메소드도 작성 가능하다 */
    public void sprayWater() {
        System.out.println("불난 곳을 발견했다. 당장 물로 진압한다! ===================>");
    }

}
