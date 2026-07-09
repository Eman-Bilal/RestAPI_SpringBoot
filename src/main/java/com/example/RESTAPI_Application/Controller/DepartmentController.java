package com.example.RESTAPI_Application.Controller;

import com.example.RESTAPI_Application.Entities.Department;
import com.example.RESTAPI_Application.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
  private final DepartmentService departmentService;

  public DepartmentController( DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @PostMapping("create")
  public ResponseEntity<Department> create(@RequestBody Department department) {
    return ResponseEntity.ok(departmentService.create(department));
  }

  @GetMapping("getAll")
  public List<Department> getAll() {
    return departmentService.getAll();
  }

  @PostMapping("{departmentId}/addCourse/{courseId}")
  public ResponseEntity<String> addCourse(@PathVariable int departmentId, @PathVariable int courseId) {
    try {
      departmentService.addCourseToDepartment(departmentId, courseId);
      return ResponseEntity.ok("Course added to department");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}