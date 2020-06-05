package com.example.EmployeeDepartment.DAO;

import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomRepo {
    public List<Employee> getEmployeeNoDepartment();
    void addEmployee(String empid,String depid);
}
