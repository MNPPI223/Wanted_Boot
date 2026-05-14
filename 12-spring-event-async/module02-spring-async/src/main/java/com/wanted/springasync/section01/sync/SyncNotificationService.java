package com.wanted.springasync.section01.sync;

import com.wanted.springasync.common.support.SleepUtils;
import com.wanted.springasync.domain.course.Enrollment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class SyncNotificationService {


    public void sendCompletionEmail(Enrollment enrollment) {

        log.info("[section01] 수료 메일 발송 시작! enrollmentId = {}", enrollment.getId());

        // 실제 서비스에서는 메일을 보내는 작업, 혹은 알림을 저장하는 작업이 일어나지만
        // 지금은 학습을 위해서 오래 걸리는 것처럼용
        SleepUtils.sleep(3000L);

        log.info("[section01] 수료 메일 발송 종료! user = {}", enrollment.getUser());


    }
}
