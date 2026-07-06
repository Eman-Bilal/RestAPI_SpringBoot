package com.example.RESTAPI_Application.Store;

import com.example.RESTAPI_Application.Models.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DepartmentStore {
    private final Map<Integer, Department> departments = new HashMap<>();
    private int nextId = 1;

    public Department create(Department d) {
        d.setDepartmentId(nextId);
        departments.put(nextId, d);
        nextId++;
        return d;
    }
    public Department getById(int id) {
        return departments.get(id);
    }
    public List<Department> getAll() {
        return new ArrayList<>(departments.values());
    }
}