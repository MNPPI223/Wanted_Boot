package com.wanted.oop.b_encapsulation.problem3;

public class Application {

    public static void main(String[] args) {

        /* comment. 캡슐화 적용 전 발생할 수 있는 문제 (3)
        *   앞서 발생한 문제 1, 2를 해결해보자.
        *   method 를 통해서 필드에 직접 값을 넣지 않고 진행하겠다.
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
        monster3.hp = -5000;
        monster3.getInfo();

    }
}
