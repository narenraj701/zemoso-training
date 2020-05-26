package com.example.EmployeeDepartment.Exceptions;



public class NoDepartmentExists extends RuntimeException {
    public NoDepartmentExists(String s) {
        super(s);
    }
}