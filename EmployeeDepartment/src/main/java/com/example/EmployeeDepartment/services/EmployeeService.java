package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee,int id);

    Employee editEmployee(Employee employee);

    void deleteEmployee(int id);

    Optional<Employee> getEmployeeByEmailId(String emailId);
}
