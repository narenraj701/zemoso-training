package com.example.EmployeeDepartment.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
