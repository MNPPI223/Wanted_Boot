package com.wanted.c_method;

public class Application02 {

    // comment. 순차적으로 스택(먼저 들어온 녀석이 제일 마지막에 나간다) / q처럼 양 옆이 뚫려있는 구조도 있음

    /* 메소드란? (부르면 갑니다!)
       메소드는 어떤 특정 작업을 수행하기 위한
       명령문의 집합이다.
    */
    public static void main(String[] args) {


        // 1. 메인 메소드가 가장 먼저 동작
        System.out.println("main() 시작됨...");

        // 2. 메인 메소드 밖에 methodA를 추가

        // 5. 작성한 methodA를 호출하는 구문
        // comment. 클래스명 변수명 = new 클래스명();
        Application02 app2 = new Application02();
        app2.methodA(); // 메서드 호출 구문

        // 6. main 메소드 최하단부 종료 코드
        System.out.println("프로그램 종료됨...");

        // 7. methodA 흐름 확인 후 methodB() 추가

    }

    // 3. 메인 메소드에서 호출이 되는 지를 확인
    public void methodA() {

        // 4. 호출 확인을 위한 출력 구문
        System.out.println("methodA() 호출됨...");

        // 12. methodB() 호출 구문 작성
        methodB();

        // 13. methodA() 종료되는 시점 확인을 위한 출력문 작성
        System.out.println("methodA() 종료됨...");


    }
        // 8. 호출 확인을 위한 methodB 작성
    public void methodB() {

        // 9. methodA 와 같은 방식으로 호출 확인을 위한 출력 구문
        System.out.println("methodB() 호출됨...");

        // 10. 작성만 해두고 App 을 동작시켜본다.
        // 실행을 하면 methodB 의 출력구문은 동작하지 않는다.
        // 왜냐? 부르지(호출) 않았기 때문에.

        // 11. methodA() 내부에서 methodB 를 호출

    }

}
