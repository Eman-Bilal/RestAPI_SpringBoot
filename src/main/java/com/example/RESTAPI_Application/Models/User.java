package com.example.RESTAPI_Application.Models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private int userId;
    private String role;

    @Embedded
    private PhoneDetails phoneDetails;
    @Embedded
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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