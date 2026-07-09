package com.example.RESTAPI_Application.Entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}