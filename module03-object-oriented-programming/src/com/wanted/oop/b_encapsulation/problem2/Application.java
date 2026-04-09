package com.wanted.oop.b_encapsulation.problem2;

public class Application {

    public static void main(String[] args) {

        /* comment. 캡슐화 적용 전 발생할 수 있는 문제 (2) */

        /* comment. 필드에 바로 접근할 때 발생할 수 있는 문제 확인
        *   Monster 클래스의 변수명을 수정하자마자, 변수를 사용하고 있는 코드에서
        *   동시 다발적으로 에러가 발생한다.
        *   -> 작은 변경이 사용하는 다른 여러 곳의 변경도 함께 초래한다.
        *  */

        // 1번 몬스터 생성
//        Monster monster1 = new Monster();
//        monster1.name = "또도가스";
//        monster1.hp = 200;
//
//        System.out.println("monster1.name = " + monster1.name);
//        System.out.println("monster1.hp = " + monster1.hp);
//
//        // 2번 몬스터 생성
//        Monster monster2 = new Monster();
//        monster2.name = "갸라도스";
//        monster2.hp = -200;
//
//        /* comment. 문제 상황 발생!!
//            검증되지 않은 값을 넣을 때 문제가 발생 할 수 있다.
//         */
//
//        System.out.println("monster2.name = " + monster2.name);
//        System.out.println("monster2.hp = " + monster2.hp);
//
//        // 3번 몬스터 생성
//        Monster monster3 = new Monster();
//        monster3.name = "피카츄";
//        monster3.hp = 200;
//        monster3.setHp(-200);
//
//        System.out.println("monster3.name = " + monster3.name);
//        System.out.println("monster3.hp = " + monster3.hp);

    }

}
