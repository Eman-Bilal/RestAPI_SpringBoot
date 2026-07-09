package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Entities.Course;
import com.example.RESTAPI_Application.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository=courseRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course create(Course course) {
        return courseRepository.save(course);
    }

}
