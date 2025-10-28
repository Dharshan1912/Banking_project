package com.ofss.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KYC_DOCUMENTS_NEW")
public class KycDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KYC_ID_NEW")
    @SequenceGenerator(name = "SEQ_KYC_ID_NEW", sequenceName = "SEQ_KYC_ID_NEW", allocationSize = 1)
    private Long kycId;

    @Column(nullable = false)
    private Long customerId;

    private String panFileName;
    private String panFileType;

    @Lob
    private String panFileContent;

    private String aadhaarFileName;
    private String aadhaarFileType;

    @Lob
    private String aadhaarFileContent;

    private String photoFileName;
    private String photoFileType;

    @Lob
    private String photoFileContent;

    private String status = "PENDING_VERIFICATION";

    private boolean reupload = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate = new Date();

    // ✅ Getters & Setters
    public Long getKycId() { return kycId; }
    public void setKycId(Long kycId) { this.kycId = kycId; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getPanFileName() { return panFileName; }
    public void setPanFileName(String panFileName) { this.panFileName = panFileName; }

    public String getPanFileType() { return panFileType; }
    public void setPanFileType(String panFileType) { this.panFileType = panFileType; }

    public String getPanFileContent() { return panFileContent; }
    public void setPanFileContent(String panFileContent) { this.panFileContent = panFileContent; }

    public String getAadhaarFileName() { return aadhaarFileName; }
    public void setAadhaarFileName(String aadhaarFileName) { this.aadhaarFileName = aadhaarFileName; }

    public String getAadhaarFileType() { return aadhaarFileType; }
    public void setAadhaarFileType(String aadhaarFileType) { this.aadhaarFileType = aadhaarFileType; }

    public String getAadhaarFileContent() { return aadhaarFileContent; }
    public void setAadhaarFileContent(String aadhaarFileContent) { this.aadhaarFileContent = aadhaarFileContent; }

    public String getPhotoFileName() { return photoFileName; }
    public void setPhotoFileName(String photoFileName) { this.photoFileName = photoFileName; }

    public String getPhotoFileType() { return photoFileType; }
    public void setPhotoFileType(String photoFileType) { this.photoFileType = photoFileType; }

    public String getPhotoFileContent() { return photoFileContent; }
    public void setPhotoFileContent(String photoFileContent) { this.photoFileContent = photoFileContent; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isReupload() { return reupload; }
    public void setReupload(boolean reupload) { this.reupload = reupload; }

    public Date getUploadDate() { return uploadDate; }
    public void setUploadDate(Date uploadDate) { this.uploadDate = uploadDate; }
}
