package com.wanted.springasync.section03.async_event;

import com.wanted.springasync.common.support.SleepUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CompletionSummaryService {

    /* comment.
        수강 완료 요약 정보를 비동기로 생성한다.
        반환형이 CompletableFuture<String> 이므로
        호출자는 thenAccept(), join(), get() 등으로
        비동기 작업의 결과를 이어서 다룰 수 있다.
     */
    @Async("classTaskExecutor")
    public CompletableFuture<String> createSummaryAsync(Long enrollmentId) {

        log.info("[section03] 🚨비동기🚨 수강 완료 요약 생성 시작! enrollmentId = {}, 작업 중인 Thread = {}",
                enrollmentId, Thread.currentThread().getName());

        // 시간 소요 시뮬레이션 - 3초간 정지한다.
        SleepUtils.sleep(3000L);

        String summary = "enrollmentId=" + enrollmentId + " 의 수강 완료 요약 정보 생성 완료!";

        log.info("[section03] 🚨비동기🚨 수강 완료 요약 생성 종료! enrollmentId = {}, 작업 중인 Thread = {}",
                enrollmentId, Thread.currentThread().getName());

        return CompletableFuture.completedFuture(summary);
    }
}
