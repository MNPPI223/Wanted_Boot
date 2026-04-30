package com.wanted.springtest.section02.jpa;

/* comment.
    Repository 계층 테스트
    @DataJpaTest
    - 핵심 기능만 간소화 하여 Spring Data Jpa 의 동작을
    - 테스트한다.
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class CalculationHistoryRepositoryTest {

    // @DataJpaTest 가 자동으로 Repository 를 Bean 으로 등록한다.
    @Autowired
    private CalculationHistoryRepository repository;

    @Test
    void 계산기록_저장_및_조회_테스트() {

        // given 계산 기록 생성
        CalculationHistory history
                = new CalculationHistory("ADD", 10.0, 5.0, 15.0);

        // when 계산 기록 저장 후 조회
        CalculationHistory savedHistory =
                repository.save(history);
        // 궁금한거 하나
        // 우리는 지금까지 이런 경우(있을 수도 있고 없을 수도 있고) exception 처리를 했는데,
        // 이 친구는 throw 하면 안되는건가?
        Optional<CalculationHistory> foundHistory =
                Optional.ofNullable(repository.findById(savedHistory.getId()).orElse(null));


        // then
        assertNotNull(foundHistory);
    }
}
