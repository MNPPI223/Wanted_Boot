package com.wanted.c_method;

import com.wanted.a_controlflow.chap02.Application;

public class Application01 {

    public static void main(String[] args) {

        /* 메서드가 없을 때 발생하는 경우 */

        /* 10개의 수를 더하고 결과를 반환받고 싶다. */
        int num1 = 1;
        int num2 = 2;
        System.out.println("1번째 연산 : " + num1 + num2);

        int num3 = 5;
        int num4 = 6;
        System.out.println("1번째 연산 : " + num3 + num4);

        // 이제 2개의 수를 더하고 싶을 때마다 위해 3줄의 코드가
        // 무한히 반복 될 것이다.

        // 다음 구문은 다른 모듈에서 배울 것이다.
        // 클래스명 변수명 = new 클래스명(); -> 공식
        Application01 app = new Application01();

        System.out.println("1번째 연산 : " + app.sumTowNumber(100, 200));
        System.out.println("2번째 연산 : " + app.sumTowNumber(10, 20));
        System.out.println("3번째 연산 : " + app.sumTowNumber(1897662, 293473));
        System.out.println("4번째 연산 : " + app.sumTowNumber(1, 2));


    }

    // main 메소드 바깥 영역

    /* 메소드
       메소드는 특정 작업을 수행하는 코드 블럭이다. 코드의 재사용성과
       가독성을 향상 시키기 위해서 사용이 된다.
       메소드는 프로그램의 구조를 체계적으로 만들고, \
       유지보수를 용이하게 한다.

        형식 : (아래의 형식에서 [] 내용은 생략가능한 내용이 아니다 주의하자! 구분을 위해 사용된것이다.)
        [접근제어자] [반환 타입] 메소드명[(매개변수 타입 매개변수 명]) {
                실행 할 코드
                return 반환값; // 반환값이 있다면
        }

        접근제어자 : 외부에서 해당 메서드에 접근할 수 있는 범위를 지정한다.
        - public : 모든 클래스에서 접근 가능
        - private : 같은 클래스 내부에서만 접근 가능
        - protected : 같은 패키지 ||(or) 자식 클래스에서 접근 가능

    */
    // 두 개의 숫자를 전달 받아, 더하기 기능을 수행하는 메소드
    public int sumTowNumber(int a, int b) {

        return a + b;
    }


}
