package com.example.RESTAPI_Application.Store;
import org.springframework.stereotype.Component;
import com.example.RESTAPI_Application.Models.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CourseStore {
    private final Map<Integer, Course> courses= new HashMap<>();
    private int nextId =1;

    public Course create(Course c){
        c.setCourseId(nextId);
        courses.put(nextId,c);
        nextId++;
        return c;
    }

    public Course getById(int id) {
        return courses.get(id);
    }
    public List<Course> getAll(){
        return new ArrayList<>(courses.values());
    }
}
