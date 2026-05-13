package com.wanted.springevent.certificate.repository;

import com.wanted.springevent.certificate.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate , Long> {

    boolean existsByEnrollment_EnrollmentId(Long aLong);

}
