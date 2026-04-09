package com.wanted.b_variable.chap02;

public class Application {

    public static void main(String[] args) {

        /* 형변환
        * 형변환(Type Conversion) 은 프로그래밍에서 데이터 타입을
        * 다른 데이터 타입으로 변환하는 과정을 의미한다.
        * 형변환은 크게 두 가지 주요 방식으로 나눌 수 있는데
        * 암시적 형변환 VS 명시적 형변환 이렇게 2가지가 있다.
        *
        * 암시적 형변환
        * - 작은 범위의 데이터 타입에서 큰 범위의 데이터 타입으로 자동으로
        * 변환되는 과정을 의미한다.
        * - int(4byte) -> double(8byte) 의 경우, 데이터 손실이 발생하지
        * 않는다.
        *  */

        // 명시적 형변환 예
        double dnum = 99.99; // double 은 8byte
        int inum = (int) dnum; // 손실을 감수하고 변경하겠다. 명시

        System.out.println("inum = " + inum);

        // 암시적(묵시적) 형변환
        int inum2 = 100;
        double dnum2 = inum2;

        System.out.println("dnum2 = " + dnum2);

        /*
        * 명시적 형변환은 데이터 손실 가능성!!!! 이 있다.
        * 따라서 데이터 타입 선택 시, 값의 범위와 필요 정확도를 고려해야 한다.
        *
        * 참고
        * - 과거에는 컴퓨터(하드웨어) 성능이 좋지 않기 때문에 자료형 선택이 신중했다.
        * 다만 하드웨어의 발전에 따라 최근에는 그다지 신경을 쓰지 않는다.
        * - 가장 많이 사용하는 자료형 : 정수 - int , 실수 - double
        * */

    }

}
