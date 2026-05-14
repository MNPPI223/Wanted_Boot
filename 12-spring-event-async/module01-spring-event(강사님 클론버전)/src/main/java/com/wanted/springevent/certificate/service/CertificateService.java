package com.wanted.springevent.certificate.service;

import com.wanted.springevent.certificate.entity.Certificate;
import com.wanted.springevent.certificate.repository.CertificateRepository;
import com.wanted.springevent.enrollment.entity.Enrollment;
import com.wanted.springevent.enrollment.repository.EnrollmentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.UUID;

@Service
@Slf4j
public class CertificateService {

    private final EnrollmentRepository enrollmentRepository;
    private final CertificateRepository certificateRepository;

    public CertificateService(EnrollmentRepository enrollmentRepository, CertificateRepository certificateRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.certificateRepository = certificateRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void issueAfterCourseCompletion(Long enrollmentId, String courseTitle, String codePrefix) {
        if (certificateRepository.existsByEnrollment_EnrollmentId(enrollmentId)) {
            log.info("[certificateService] 이미 수료증이 존재하므로 발급을 건너뜁니다. enrollmentId={}", enrollmentId);
            return;
        }

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("수강 정보를 찾을 수 없습니다. enrollmentId=" + enrollmentId));

        Certificate certificate = certificateRepository.save(
                Certificate.issue(enrollment, codePrefix + "-" + UUID.randomUUID())
        );

        log.info(
                "[certificateService] 새 트랜잭션에서 수료증 발급 완료. courseTitle={}, certificateId={}",
                courseTitle,
                certificate.getCertificateId()
        );
    }

}
