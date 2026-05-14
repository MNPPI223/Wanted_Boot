package com.wanted.springasync.section02.async_basic;

import com.wanted.springasync.domain.course.Enrollment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncNotificationService {
    @Async
    public void sendCompletionEmail(Enrollment enrollment) {



    }
}
