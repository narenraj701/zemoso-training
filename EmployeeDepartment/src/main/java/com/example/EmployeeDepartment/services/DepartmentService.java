package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getDepartments();

    Department addDepartment(Department department);

    List<Employee> getEmployees(int dep_id);

    Optional<Department> getDepartmentById(int id);

    Optional<Department> getDepartmentByName(String depName);
}
