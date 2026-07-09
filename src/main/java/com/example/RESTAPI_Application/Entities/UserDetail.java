package com.example.RESTAPI_Application.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces")
    private String firstName;

    private String middleInitials;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces")
    private String lastName;

    @NotBlank(message = "Enter the Cnic")
    @Pattern(regexp = "\\d{5}-\\d{7}-\\d{1}", message = "Enter the Cnic with dashes")
    private String cnic;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
