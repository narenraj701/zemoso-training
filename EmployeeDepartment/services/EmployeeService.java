package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee,int id);

    Employee editEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getEmployeeByLastName(String lastName);
}
