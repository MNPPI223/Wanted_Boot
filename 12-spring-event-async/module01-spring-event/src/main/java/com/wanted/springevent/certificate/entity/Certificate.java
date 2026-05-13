package com.wanted.springevent.certificate.entity;


import com.wanted.springevent.enrollment.entity.Enrollment;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long certificateId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enrollment_id", nullable = false, unique = true)
    private Enrollment enrollment;

    @Column(name = "verification_code", nullable = false, unique = true, length = 100)
    private String verificationCode;

    @Column(name = "issued_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime issuedAt;

    protected Certificate() {
    }

    private Certificate(Enrollment enrollment, String verificationCode) {
        this.enrollment = enrollment;
        this.verificationCode = verificationCode;
    }

    public static Certificate issue(Enrollment enrollment, String verificationCode) {
        return new Certificate(enrollment, verificationCode);
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

}
