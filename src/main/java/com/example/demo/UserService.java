package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User getById(long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No user"));
    }

    public User save(User data) {
        return repo.save(data);
    }
}
