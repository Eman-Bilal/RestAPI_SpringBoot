package com.example.RESTAPI_Application.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Course Name is required")
    @Column(unique = true)
    private String courseName;

    @NotBlank(message = "Course code is required")
    @Column(unique = true)
    private String courseCode;

    @NotNull(message = "Course credit hours are required")
    private int creditHours;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("courses")
    private Department department;
}