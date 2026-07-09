package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Models.Course;
import com.example.RESTAPI_Application.Models.Department;
import com.example.RESTAPI_Application.Repository.CourseRepository;
import com.example.RESTAPI_Application.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentStore;
    private final CourseRepository courseStore;

    public DepartmentService(DepartmentRepository departmentStore, CourseRepository courseStore) {
        this.departmentStore = departmentStore;
        this.courseStore = courseStore;
    }

    public void addCourseToDepartment(int departmentId, int courseId) {
        Department dept = departmentStore.findById((long) departmentId)
                .orElseThrow(()-> new IllegalArgumentException("Department not found"));
        Course course = courseStore.findById((long) courseId)
                .orElseThrow(()-> new IllegalArgumentException("Course not found"));
        course.setDepartment(dept);
        courseStore.save(course);
    }

    public Department create(Department department){
        return departmentStore.save(department);
    }

    public List<Department> getAll() {
        return departmentStore.findAll();
    }
}