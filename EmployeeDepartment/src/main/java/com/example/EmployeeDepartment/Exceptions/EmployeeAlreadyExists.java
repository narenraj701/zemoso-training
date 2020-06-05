package com.example.EmployeeDepartment.Exceptions;

public class EmployeeAlreadyExists extends RuntimeException {
    public EmployeeAlreadyExists(String s) {
        super(s);
    }
}
