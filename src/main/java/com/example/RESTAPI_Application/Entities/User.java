package com.example.RESTAPI_Application.Entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Role is required")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="phone_id")
    @Valid
    private PhoneDetails phoneDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_detail_id")
    @Valid
    private UserDetail userDetail;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}