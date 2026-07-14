package com.wanted.oop.c_abstraction.dto;

public class MemberDTO {

    /* comment. DTO 의 역할
        회원을  추상화 하여 회원 정보를 구성한다.
     */

    private int no; // 회원 번호
    private String name; // 회원 이름
    private int age; // 회원 나이
    private char gender; // 회원 성별
    private double height; // 회원 키
    private boolean isActivated; // 회원 활성화 여부

    /*
    * 필드가 private 접근 제한자로 외부 접근이 제한 되어 있다.
    * 그렇기 때문에 우리는 값을 초기화 하거나, 조회할 때 간접적으로
    * 접근할 수 있는 메서드를 구성해야 한다.
    * */

    /* comment. 설정자(setter) / 접근자(getter) 는 실무에서
    *   암묵적으로 통용되는 작성 규칙이 있다.
    *   - setter 작성 규칙
    *   [표현식]
    *   - public void set필드명(매개변수{
    *       필드 = 매개변수;
    *   }
    *   - getter 작성 규칙
    *   [표현식]
    *   - public 반환형 get필드명(){
    *       return 반환값;
    *   }
    *  */

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    // boolean 타입은 is가 기본값으로 되어있다.
    public boolean isActivated() {
        return isActivated;
    } // 질문해보자

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", isActivated=" + isActivated +
                '}';
    }
}
