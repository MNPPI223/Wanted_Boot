package com.wanted.mnppi.practice_variable;

import java.util.Scanner;

public class PracApplication3 {

    public static void main(String[] args) {

        // 변수 선언

        // 스캐너 사용
        Scanner sc = new Scanner(System.in);


        System.out.println("자신의 이름을 입력해주세요 : ");
        String name = sc.nextLine();

        System.out.println("자신의 나이를 입력해주세요 : ");
        int age = sc.nextInt();
        // 자바의 클래식 버그(nextInt()는 값만 가져가는 느낌인거지)
        sc.nextLine();

        System.out.println("자신의 성별을 입력해주세요 : ");
        String sex = sc.nextLine();

        System.out.println("자신의 키를 입력해주세요 : ");
        float height = sc.nextFloat();


        System.out.println(age + "살 " + sex+ " " + name + "님 키가 " + height + "cm 이시군요");
    }

}
