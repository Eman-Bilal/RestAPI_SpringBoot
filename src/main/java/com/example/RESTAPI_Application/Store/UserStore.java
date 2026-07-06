package com.example.RESTAPI_Application.Store;

import com.example.RESTAPI_Application.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserStore {
    private final Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    public User create(User u)
    {
        u.setUserId(nextId);
        users.put(nextId, u);
        nextId++;
        return u;
    }
    public User getById(int id) {
        return users.get(id);
    }
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }
    public boolean update(int id, User u) {
        if (!users.containsKey(id))
            return false;
        u.setUserId(id);
        users.put(id, u);
        return true;
    }
    public boolean delete(int id) {
        return users.remove(id) != null;
    }
}