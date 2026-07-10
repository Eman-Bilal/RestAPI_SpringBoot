package com.example.RESTAPI_Application.Service;

import com.example.RESTAPI_Application.Entities.Department;
import com.example.RESTAPI_Application.Entities.User;
import com.example.RESTAPI_Application.Repository.DepartmentRepository;
import com.example.RESTAPI_Application.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userStore;
    private final DepartmentRepository departmentStore;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userStore, DepartmentRepository departmentStore, PasswordEncoder passwordEncoder) {
        this.userStore = userStore;
        this.departmentStore = departmentStore;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user, int departmentId) {
        Department dept = departmentStore.findById((long) departmentId)
            .orElseThrow(() -> new IllegalArgumentException("Department not found"));
        user.setDepartment(dept);
        user.getUserDetail().setPassword(passwordEncoder.encode(user.getUserDetail().getPassword()));
        return userStore.save(user);
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

    public List<User> getUser() {
        return userStore.findAll();
    }

    public User getUserById(int id){
        return (userStore.findById((long) id)).orElse(null);
    }

    public Boolean updateUser(int id, User userRecord){
        return userStore.findById((long)id).map(existing->{
            existing.getUserDetail().setFirstName(userRecord.getUserDetail().getFirstName());
            existing.getUserDetail().setLastName(userRecord.getUserDetail().getLastName());
            existing.getUserDetail().setCnic(userRecord.getUserDetail().getCnic());
            existing.getUserDetail().setEmail(userRecord.getUserDetail().getEmail());
            existing.getPhoneDetails().setPrimaryPhone(userRecord.getPhoneDetails().getPrimaryPhone());

            userStore.save(existing);
            return true;
        }).orElse(false);
    }

    public boolean deleteUser(int id){
      if (userStore.existsById((long) id)){
          userStore.deleteById((long) id);
          return true;
      }
        return false;
    }
}