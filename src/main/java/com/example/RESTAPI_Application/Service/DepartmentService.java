package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Models.Course;
import com.example.RESTAPI_Application.Models.Department;
import com.example.RESTAPI_Application.Store.CourseStore;
import com.example.RESTAPI_Application.Store.DepartmentStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentStore departmentStore;
    private final CourseStore courseStore;
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public DepartmentService(DepartmentStore departmentStore, CourseStore courseStore) {
        this.departmentStore = departmentStore;
        this.courseStore = courseStore;
    }

    public void addCourseToDepartment(int departmentId, int courseId) {
        Department dept = departmentStore.getById(departmentId);
        Course course = courseStore.getById(courseId);
        if (dept == null) throw new IllegalArgumentException("Department not found");
        if (course == null) throw new IllegalArgumentException("Course not found");
        dept.getCourses().add(course);
    }
}