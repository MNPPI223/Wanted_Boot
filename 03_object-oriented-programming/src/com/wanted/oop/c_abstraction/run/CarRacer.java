package com.wanted.oop.c_abstraction.run;
//    카레이서가 수신할 수 있는 메세지는 카레이서가 해야 할 일과 동일하다.
//            1. 시동을 걸어라
//            2. 엑셀을 밟아라
//            3. 브레이크 밟아라
//            4. 시동 꺼라
//    자동차가 수신할 수 있는 메세지는 자동차가 해야 할 일과 동일하다.
//            1. 시동을 걸어라
//            2. 앞으로 가라
//            3. 멈춰라
//           4. 시동을 꺼라
public class CarRacer {

    // 클래스도 자료형이기 때문에 변수처럼 캡슐화를 적용해서 사용할 수 있다.
    private  Car car = new Car();

    public void startUp() {

        car.startUp();
    }

    public void stepAccel() {

        car.go();

    }

    public void stepBreak() {

        car.stop();

    }

    public void turnOff() {

        car.turnOff();

    }
}
