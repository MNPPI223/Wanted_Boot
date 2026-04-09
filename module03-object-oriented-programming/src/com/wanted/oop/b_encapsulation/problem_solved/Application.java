package com.wanted.oop.b_encapsulation.problem_solved;

public class Application {

    public static void main(String[] args) {

        /* comment. 캡슐화 적용 후 앞서 확인한 문제와 비교해본다.
        *   problem 3번에서 method 를 활용해서 필드에 접근하는 것이 아닌
        *   메소드를 통해서 값을 초기화 했다.
        *   다만 여전히 필드에 접근할 수 있다는 것이 마지막 남은 숙제이다.
        * */

        // 1번 몬스터 생성
        Monster monster1 = new Monster();
        monster1.setName("또도가스");
        monster1.setHp(200);

        monster1.getInfo();

        // 2번 몬스터 생성
        Monster monster2 = new Monster();
        monster2.setName("갸라도스");
        monster2.setHp(-200);

        monster2.getInfo();

        /* comment. 문제 상황 발생!!
            검증되지 않은 값을 넣을 때 문제가 발생 할 수 있다. */

        // 3번 몬스터 생성
        Monster monster3 = new Monster();
        monster3.setName("피카츄");
        monster3.setHp(500);

        monster3.getInfo();

        /* comment. 이제 거의 문제가 해결됐다.
            다만 아직까지 문제가 되는 부분은
            여전히 필드에 접근할 수 있다는 것이다.
         */
//        monster3.hp = -5000;
        monster3.getInfo();

    }
}
