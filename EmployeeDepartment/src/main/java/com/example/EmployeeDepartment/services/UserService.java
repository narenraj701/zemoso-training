package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.User;

import java.util.Optional;

public interface UserService {
    void save(User user);

    Optional<User> findByUsername(String username);
}
