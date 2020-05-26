package com.example.EmployeeDepartment.DAO;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByLastName(String lastName);
}
