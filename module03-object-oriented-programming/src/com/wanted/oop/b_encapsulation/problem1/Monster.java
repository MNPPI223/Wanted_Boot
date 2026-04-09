package com.wanted.oop.b_encapsulation.problem1;

public class Monster {

    /* 몬스터의 이름, 몬스터의 체력 */
    String name;
    int hp;

    // hp를 설정하는 메소드
    // 매개변수 전달받은 hp 값을 변경해주는 메소드
    // 양수의 경우에는 전달받은 값으로 세팅
    // 음수인 경우에는 0으로 변경
    public void setHp(int hp) {

        if (hp > 0) {
            System.out.println("정상적인 값입니다! 몬스터 체력을 " + hp + "로 설정합니다.");
            /* this : 인스턴스가 생성 될 때, 자신의 주소를 저장하는 레퍼런스 변수이다.
            *  지역변수와 전역변수의 이름이 같을 때, 지역변수를 우선적으로 접근하기 때문에
            *  전역변수에 값을 대입하기 위해서는 this. 을 명시해야 한다.
            * */
            this.hp = hp;
        } else {
            System.out.println("삐빅... 오류 발생 hp를 0으로 세팅합니다...");
            this.hp = 0;
        }

    }
}
