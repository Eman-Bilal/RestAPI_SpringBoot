package com.example.RESTAPI_Application.Repository;

import com.example.RESTAPI_Application.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
