package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Models.Department;
import com.example.RESTAPI_Application.Models.User;
import com.example.RESTAPI_Application.Repository.DepartmentRepository;
import com.example.RESTAPI_Application.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userStore;
    private final DepartmentRepository departmentStore;

    public UserService(UserRepository userStore, DepartmentRepository departmentStore) {
        this.userStore = userStore;
        this.departmentStore = departmentStore;
    }

    public List<User> getUsersByDepartment(int departmentId) {
        List<User> all = userStore.findAll();
        List<User> result = new ArrayList<>();
        for (User u : all) {
            if (u.getDepartment() != null && u.getDepartment().getId() == departmentId) {
                result.add(u);
            }
        }
        return result;
    }

    public User createUser(User user, int departmentId) {
        Department dept = departmentStore.findById((long) departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));
        user.setDepartment(dept);
        return userStore.save(user);
    }

    public List<User> getUser() {
        return userStore.findAll();
    }

    public User getUserById(int id){
        return (userStore.findById(Long.valueOf(id))).orElse(null);
    }

    public Boolean updateUser(int id, User userRecord){
        return userStore.findById((long)id).map(existing->{
            existing.getUserDetail().setFirstName(userRecord.getUserDetail().getFirstName());
            existing.getUserDetail().setCnic(userRecord.getUserDetail().getCnic());
            existing.getUserDetail().setEmail(userRecord.getUserDetail().getEmail());
            existing.getPhoneDetails().setPrimaryPhone(userRecord.getPhoneDetails().getPrimaryPhone());

            userStore.save(existing);
            return true;
        }).orElse(false);
    }

    public boolean deleteUser(int id){
        if(!userStore.existsById((long)id)){
            return false;
        }
        return true;
    }
}