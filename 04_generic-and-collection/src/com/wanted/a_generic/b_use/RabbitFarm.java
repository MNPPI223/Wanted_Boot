package com.wanted.a_generic.b_use;

/* T <- 타입변수에는 어떤 값이 들어올 지 모른다.
    단, extends Rabbit 이라고 작성을 하게 되면
    T 타입변수에는 Rabbit 혹은 Rabbit 을 상속 받는 클래스만
    들어올 수 있게 된다.
 */
public class RabbitFarm <T extends Rabbit> {

    private T animal;

    public RabbitFarm() {}

    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
