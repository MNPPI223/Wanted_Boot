package com.wanted.a_exception.c_userexception;

import com.wanted.a_exception.c_userexception.exception.MoneyNegativeException;
import com.wanted.a_exception.c_userexception.exception.NotEnoughMoneyException;
import com.wanted.a_exception.c_userexception.exception.PriceNegativeException;

public class Application01 {
    // 3월 6일 제일 중요한 수업 내용 - 결국 상속과 e 라는 매개변수를 잘 이용해서 문제를 해결하자
    public static void main(String[] args) {

        /* comment. 사용자 정의의 예외클래스 정의하기
            사전에 정의되어 있는 Exception 의 종류는 굉장히 많다.
            하지만, 현실세계에서 발생할 수 있는 수 많은 예외를 처리하기엔
            너무 추상적이며 제한적이다.
            따라서 우리는 extends Exception 을 통해 우리 프로젝트만의
            커스텀 exception 클래스를 정의할 것이다.
         */

        ExceptionTest et = new ExceptionTest();

        // 상품 가격보다 가진 돈이 적은 경우
       try {
           et.checkEnoughMoney(-50000, 30000);
       } catch (PriceNegativeException e ) {
           System.out.println("e.getClass : " + e.getClass());
           System.out.println("가격 음수 시 발생");
       } catch (MoneyNegativeException e) {
           System.out.println("돈 음수 시 발생");
       } catch (NotEnoughMoneyException e) {
           System.out.println("돈 충분하지 않음");
       }
    }

}
