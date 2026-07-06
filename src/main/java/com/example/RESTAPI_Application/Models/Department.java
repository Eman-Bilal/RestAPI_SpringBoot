package com.example.RESTAPI_Application.Models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private int departmentId;
    private List<Course> courses = new ArrayList<>();

    public Department() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}