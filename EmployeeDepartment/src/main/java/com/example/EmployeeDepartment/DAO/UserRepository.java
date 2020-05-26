package com.example.EmployeeDepartment.DAO;

import com.example.EmployeeDepartment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
