package com.wanted.a_generic.b_use;

public class WildcardFarm {

    // farm 이라는 변수로 RabbitFarm 안에 들어있는 토끼를 치환
    public void anyType(RabbitFarm<?> farm) {
        farm.getAnimal().cry();
    }

    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getAnimal().cry();
    }

    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getAnimal().cry();

    }

}
