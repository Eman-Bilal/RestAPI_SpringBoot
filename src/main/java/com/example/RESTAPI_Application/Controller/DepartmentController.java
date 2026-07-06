package com.example.RESTAPI_Application.Controller;

import com.example.RESTAPI_Application.Models.Department;
import com.example.RESTAPI_Application.Service.DepartmentService;
import com.example.RESTAPI_Application.Store.DepartmentStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentStore departmentStore;
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentStore departmentStore, DepartmentService departmentService) {
        this.departmentStore = departmentStore;
        this.departmentService = departmentService;
    }

    @PostMapping("create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(departmentStore.create(department));
    }

    @GetMapping("getAll")
    public List<Department> getAll() {
        return departmentStore.getAll();
    }

    @PostMapping("{departmentId}/addCourse/{courseId}")
    public ResponseEntity<String> addCourse(@PathVariable int departmentId, @PathVariable int courseId) {
        departmentService.addCourseToDepartment(departmentId, courseId);
        return ResponseEntity.ok("Course added to department");
    }
}