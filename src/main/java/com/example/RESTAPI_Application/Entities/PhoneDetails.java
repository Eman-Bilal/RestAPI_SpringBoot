package com.example.RESTAPI_Application.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // AUTO-INCREMENT
    private Long id;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+92\\d{10}$", message = "Phone number must be in the format +923000000000")
    @Column(unique = true)
    private String primaryPhone;

    @Pattern(regexp = "^\\+92\\d{10}$", message = "Phone number must be in the format +923000000000")
    @Column(unique = true)
    private String emergency;
}