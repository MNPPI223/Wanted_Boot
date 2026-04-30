package com.wanted.springtest.section01.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/* comment.
    @SpringBootTest 란?
    - Application 전체를 로드하여 통합 테스트 환경을 제공한다.
    @ActiveProfiles 란?
    - 운영환경/개발환경/테스트환경 등 각각의 환경에 따라 다른 설정을
    - 적용할 수 있도록 한다. 
    - 실무에서 yml 사용 방법 - application 이라는 접두사는 정해져있음.
    (따라서 저대로 application 은 변경하면 안됨)
    application-dev.yml 개발 시 yml
    application-test.yml 테스트 환경 yml
    application-prod.yml 운영 환경 yml
 */

@SpringBootTest
// test 패키지의 yaml 파일에 종속받게 설정
@ActiveProfiles("test")
public class CalculatorServiceTest {

    /* comment.
        @ActiveProfiles("test") 어노테이션을 인해
        TestConfig 클래스에 정의한 testCalculatorService()
        Bean 이 주입된다.
     */

    @Autowired
    private CalculatorService calculatorService;


    /* comment.
        Service 계층 테스트는 실제 비즈니스 로직의
        동작을 확인하는 용도로 사용된다.
        참고) JPA 배울 때 TEST 맛보기 했던 것과 동일하다.
        <오류>
        @Autowired로 주입받을 타입은 테스트 대상 클래스(CalculatorService).
        테스트 클래스가 아니다.
     */

    @Test
    void 나눗셈_올바르게_동작_테스트() {

        // given
        int a = 15, b = 3, expected = 5;

        // when
        int actual = calculatorService.divide(a,b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 나눗셈_0으로_CalculatorServiceTest() {

        // given
        int a = 10, b = 0;

        //when & then
        // 단순 예외가 발생해서 통과시키는 TestCode 가 아닌
        // 예외가 발생 + 어떤 예외 클래스가 동작하는 지도 확인하는
        // TestCode
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculatorService.divide(a,b)
        );

    }

}


