package com.ofss.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KYC_VERIFICATION_NEW")
public class KycVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VERIFICATION_ID")
    @SequenceGenerator(name = "SEQ_VERIFICATION_ID", sequenceName = "SEQ_VERIFICATION_ID", allocationSize = 1)
    private Long verificationId;

    private Long kycId;

    private String verifiedBy;
    private String status;
    private String remarks;

    @Temporal(TemporalType.TIMESTAMP)
    private Date verificationDate = new Date();

    // ✅ Getters & Setters
    public Long getVerificationId() { return verificationId; }
    public void setVerificationId(Long verificationId) { this.verificationId = verificationId; }

    public Long getKycId() { return kycId; }
    public void setKycId(Long kycId) { this.kycId = kycId; }

    public String getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(String verifiedBy) { this.verifiedBy = verifiedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Date getVerificationDate() { return verificationDate; }
    public void setVerificationDate(Date verificationDate) { this.verificationDate = verificationDate; }
}
