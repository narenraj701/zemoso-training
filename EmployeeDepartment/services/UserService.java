package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
