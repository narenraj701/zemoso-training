package com.example.EmployeeDepartment.Exceptions;


public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String s){
        super(s);
    }
}
