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
//            4. 시동을 꺼라

    /* 시동을 켜거나 끄거나, 앞으로 가거나 멈추거나 하는 행위는
        시동이 걸려있는지 상태를 확인해야한다. */


import java.security.KeyStore;

public class Car {

    private boolean isOn; // 시동의 꺼짐과 켜짐을 나타태는 상태
    private int speed; // 자동차의 속력을 나타낸다.

    public void startUp() {

        if(isOn) {
            System.out.println("이미 시동이 걸려있습니다!!");
        } else {
            this.isOn = true;
            System.out.println("시동 걸기 완료!!");
        }

    }

    public void go() {
        if (isOn) {
            System.out.println("차가 출발합니다!");
            this.speed += 10;
            System.out.println("현재 차량의 속력은 " +this.speed + "(km/h)입니다!");
        } else {
            System.out.println("차량의 시동이 걸려있지 않습니다! 시동을 확인해주세요!");
        }
    }

    public void stop() {

        if (isOn) {
            if(this.speed >0) {
                this.speed = 0;
                System.out.println("브레이킹을 완료했습니다! 차량이 멈춥니다.");
            }else {
                System.out.println("차량이 이미 멈춰있습니다!");
            }
        } else {
            System.out.println("차량의 시동이 걸려있지 않습니다!! 시동을 걸어주세요!");
        }

    }

    public void turnOff() {

        if (isOn){
            if(speed>0){
                System.out.println("달리는 상태에서는 시동을 끌 수 없습니다! 차를 정차해주세요!");
            } else {
                this.isOn = false;
                System.out.println("이미 시동이 꺼져있습니다! 시동의 상태를 확인해주세요!");
            }
        } else {
            this.isOn = false;
            System.out.println("시동을 끕니다. 재운행이 필요할 시, 시동을 확인해주세요.");
        }

    }
}
