package com.wanted.springevent.section02.listener;

import com.wanted.springevent.section02.event.Section02CourseCompletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 로그 관련 클래스
@Component
public class Section02CourseCompletionAuditEventListener {

    /* comment.
        해당 클래스는 1개의 이벤트가 발생했을 때
        여러 개의 Listener 가 동작하는 것을 보여주기 위함이다.
        해당 클래스는 이벤트가 발생하면 Audit(감사,로깅) 처리를 하는
        Listener 역할을 한다.
     */

    private static final Logger log = LoggerFactory.getLogger(Section02CourseCompletionAuditEventListener.class);

    @EventListener
    public void eventHandle(Section02CourseCompletedEvent event) {

        // 타입이 일치해야만 낚아챌 수 있는 방식이다.\
        log.info(
                "[section02] 감사 로그 기록 : userId={}, courseId={}, userName={}",
                event.userId(),
                event.courseId(),
                event.userName()
        );

    }

}
