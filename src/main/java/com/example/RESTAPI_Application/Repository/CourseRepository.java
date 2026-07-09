package com.example.RESTAPI_Application.Repository;

import com.example.RESTAPI_Application.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {

}
