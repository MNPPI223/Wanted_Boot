package com.wanted.a_generic.b_use.run;

import com.wanted.a_generic.b_use.Bunny;
import com.wanted.a_generic.b_use.DrunkenBunny;
import com.wanted.a_generic.b_use.Rabbit;
import com.wanted.a_generic.b_use.RabbitFarm;

public class Application01 {

    public static void main(String[] args) {

//        RabbitFarm<> farm1 = new RabbitFarm<>();

        RabbitFarm<Rabbit> farm2 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm3 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm4 = new RabbitFarm<>();

//        Rabbit rabbit = new Rabbit();
//        fram2.setAnimal(rabbit);

        farm2.setAnimal(new Rabbit());

        // Rabbit rabbit = farm2.getAnimal();
        // rabbit.cry();
        farm2.getAnimal().cry();

        // bunny
        farm3.setAnimal(new Bunny());
        farm3.getAnimal().cry();

        farm4.setAnimal(new DrunkenBunny());
        farm4.getAnimal().cry();
    }

}
