package com.example.EmployeeDepartment.DAO;

import com.example.EmployeeDepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByName(String depName);
}
