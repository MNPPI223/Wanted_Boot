package com.wanted.a_generic.b_use.run;

import com.wanted.a_generic.b_use.*;

public class Application02 {

    public static void main(String[] args) {

        /* comment. 와일드 카드
        제네릭 클래스 타입의 객체를 매소드의 매개변수로
        전달 받을 때, 그 객체의 타입 변수를 제한할 수 있다.
        <?> : 제한 없음
        <? extends Type> : 와일드카드 상한 제한
        <? super Type> : 와일드카드 하한 제한
     */
        // 1. Wildcardfarm의 anytype을 사용할 수 있게 되었다.
        WildcardFarm wfarm = new WildcardFarm();

        // 항상 main 부터 보는 습관을 가집시다
        // 2. 뒤에서부터 읽기 / new Rabbit() 토끼가 생김 / RabbitFarm에 여기 가둬 / 그리고 .연산자를 통해서 들어가
        wfarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("=================================================");
//        wfarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("=================================================");
        wfarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wfarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
    }


}
