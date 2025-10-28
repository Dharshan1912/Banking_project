package com.ofss.controller;

import com.ofss.dto.KycVerificationRequest;
import com.ofss.model.KycVerification;
import com.ofss.service.KycVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/api/kyc-verification")
@Tag(name = "KYC Verification API", description = "APIs to verify KYC documents and fetch verification history/status")
public class KycVerificationController {

    @Autowired
    private KycVerificationService verificationService;

    // ✅ Verify a KYC document
    @Operation(
            summary = "Verify a KYC document",
            description = "Saves KYC verification results like APPROVED or REJECTED, including remarks and verifier name"
    )
    @PostMapping("/verify")
    public ResponseEntity<KycVerification> verifyKyc(@RequestBody KycVerificationRequest request) {
        KycVerification savedVerification = verificationService.verifyKyc(
                request.getKycId(),
                request.getVerifiedBy(),
                request.getStatus(),
                request.getRemarks()
        );
        return ResponseEntity.ok(savedVerification);
    }

    // ✅ Get all verifications of a KYC (history)
    @Operation(
            summary = "Fetch KYC verification history",
            description = "Returns all verification records performed on a given KYC ID"
    )
    @GetMapping("/history/{kycId}")
    public ResponseEntity<List<KycVerification>> getVerificationHistory(@PathVariable Long kycId) {
        List<KycVerification> history = verificationService.getVerificationHistory(kycId);
        return ResponseEntity.ok(history);
    }

    // ✅ Get latest KYC verification status
    @Operation(
            summary = "Fetch current KYC verification status",
            description = "Returns the latest status of the given KYC ID (e.g., APPROVED, REJECTED)"
    )
    @GetMapping("/status/{kycId}")
    public ResponseEntity<String> getLatestStatus(@PathVariable Long kycId) {
        String status = verificationService.getLatestStatus(kycId);
        if (status == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(status);
    }
}
