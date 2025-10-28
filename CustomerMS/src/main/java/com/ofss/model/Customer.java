package com.ofss.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER_NEW")
public class Customer  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_NEW_SEQ", allocationSize = 1)
	@Column(name = "CUSTOMER_ID")
	private Long customerId; // Hibernate won't generate, Oracle trigger will

    @NotBlank(message = "Full name is required")
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[6-9]\\d{9}", message = "Phone must be 10 digits starting with 6-9")
    @Column(name = "PHONE", nullable = false, unique = true)
    private String phone;

    @NotBlank(message = "Date of Birth is required")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Date of Birth must be in DD-MM-YYYY format")
    @Column(name = "DOB", nullable = false)
    private String dob;

    @NotBlank(message = "Address is required")
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @NotBlank(message = "PAN is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN format")
    @Column(name = "PAN", nullable = false, unique = true)
    private String pan;

    @NotBlank(message = "Aadhaar is required")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar must be 12 digits")
    @Column(name = "AADHAAR", nullable = false, unique = true)
    private String aadhaar;

    // Getters and Setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getAadhaar() { return aadhaar; }
    public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }
}
