package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Models.Department;
import com.example.RESTAPI_Application.Models.User;
import com.example.RESTAPI_Application.Store.DepartmentStore;
import com.example.RESTAPI_Application.Store.UserStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserStore userStore;
    private final DepartmentStore departmentStore;

    public UserService(UserStore userStore, DepartmentStore departmentStore) {
        this.userStore = userStore;
        this.departmentStore = departmentStore;
    }

    public List<User> getUsersByDepartment(int departmentId) {
        List<User> all = userStore.getAll();
        List<User> result = new ArrayList<>();
        for (User u : all) {
            if (u.getDepartment() != null && u.getDepartment().getDepartmentId() == departmentId) {
                result.add(u);
            }
        }
        return result;
    }

    public User createUser(User user, int departmentId) {
        Department dept = departmentStore.getById(departmentId);
        if (dept == null) throw new IllegalArgumentException("Department not found");
        user.setDepartment(dept);
        return userStore.create(user);
    }

    public UserStore getUserStore() {
        return userStore;
    }
}