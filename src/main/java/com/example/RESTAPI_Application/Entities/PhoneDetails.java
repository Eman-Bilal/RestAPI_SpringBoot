package com.example.RESTAPI_Application.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+92\\d{10}$", message = "Phone number must be in the format +923000000000")
    private String primaryPhone;

    @Pattern(regexp = "^\\+92\\d{10}$", message = "Phone number must be in the format +923000000000")
    private String emergency;

    public PhoneDetails() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primary) {
        this.primaryPhone = primary;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }
}