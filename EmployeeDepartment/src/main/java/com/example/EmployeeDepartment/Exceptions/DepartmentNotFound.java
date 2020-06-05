package com.example.EmployeeDepartment.Exceptions;



public class DepartmentNotFound extends RuntimeException {
    public DepartmentNotFound(String s) {
        super(s);
    }
}