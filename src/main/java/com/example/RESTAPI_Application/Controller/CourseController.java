package com.example.RESTAPI_Application.Controller;

import com.example.RESTAPI_Application.Models.Course;
import com.example.RESTAPI_Application.Store.CourseStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseStore courseStore;

    public CourseController(CourseStore courseStore) {
        this.courseStore = courseStore;
    }
    @GetMapping("/getAll")
    public List<Course> getAll(){
        return courseStore.getAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Course> create(@RequestBody Course course){

        return ResponseEntity.ok(courseStore.create(course));
    }

}
