package com.wanted.oop.a_user_type;

public class Application {

    public static void main(String[] args) {

        /* comment.
            지금까지 우리는 Java 에서 제공하는 자료를 취급하는
            자료형에 대해서 알아보았다.
            - 회원 정보를 관리하는 시뮬레이션 진행
            - 회원 : 아이디, 패스워드, 이름, 나이, 성별, 취미
         */

        String id = "user01";
        String pwd = "pass01";
        String name = "김민섭";
        int age = 24;
        char gender = '남';
        String[] hobby = {"게임","유튜브","개발"};

        /* 위에 작성한 1명의 회원 정보 출력하기 */
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        for (int i =0; i< hobby.length; i++) {
            System.out.print(hobby[i] + " ");
        }
        // 개행을 위한 구문
        System.out.println();

        /* comment.
            위처럼, 이렇게 각각의 변수로 관리를 하게 된다면 여러 단점이 존재한다.
            1. 변수명을 다 관리해야 하는 어려움이 생긴다.
            2. 모든 회원 정보를 인자로 메소드를 호출 시 값을 전달해야 한다면 너무 많은
            값들을 인자로 전달해야 하기 때문에 한 눈에 안 들어온다.
            3. 리턴구문은 항상 1개의 값만 가능하기 때문에 회원 정보를 묶어서 return 할 수 없다.
         */

        /* comment. 위 단점을 극복하기 위해 사용자 정의의 자료형이 나왔다.
        *   Member 클래스 만들기 */

        /* comment. 사용자 정의의 자료형 사용해보기
            1. 클래스명 변수명 = new 클래스명();
            지금까지 이렇게 작성한 구문은 객체를 생성하는 구문이다.
            2. 사용자 정의의 자료형인 클래스를 생성하면, 클래스에
            우리가 정의한 필드(전역변수), 메서드 대로 객체가 생성된다.

         */

        Member member = new Member();
        /* 멤버가 가진 값에 접근하기 위해서는 인스턴스변수명. 필드명
        *  여기서 . 은 참조연산자로서 레퍼런스 변수가 참조하고 있는
        *  주소에 접근하겠다는 의미이다.
        *  */
        System.out.println("Member가 가진 이름 : " + member.name);
        System.out.println("Member가 가진 이름 : " + member.age);

        // 필드에 접근해서 값을 초기화
        member.id = "user02";
        member.pwd = "pass02";

        System.out.println("Member가 가진 아이디 : " + member.id);
        System.out.println("Member가 가진 비밀번호 : " + member.pwd);


    }


}
