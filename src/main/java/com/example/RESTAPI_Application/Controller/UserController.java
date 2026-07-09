package com.example.RESTAPI_Application.Controller;

import com.example.RESTAPI_Application.Entities.User;
import com.example.RESTAPI_Application.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create/{departmentId}")
    public ResponseEntity<?> create(@PathVariable int departmentId,@Valid @RequestBody User userRecord) {
        try {
            User created = userService.createUser(userRecord, departmentId);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("getAll")
    public List<User> getAll() {
        return userService.getUser();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("byDepartment/{departmentId}")
    public List<User> getByDepartment(@PathVariable int departmentId) {
        return userService.getUsersByDepartment(departmentId);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@Valid @RequestBody User userRecord) {
        boolean updated = userService.updateUser(id, userRecord);
        if (!updated) {
            return ResponseEntity.badRequest().body("Id not Found");
        }
        return ResponseEntity.ok("User Updated: " + userRecord);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        if (!deleted) {
            return ResponseEntity.badRequest().body("Id not Found");
        }
        return ResponseEntity.ok("User Deleted");
    }
}
