package com.example.EmployeeDepartment.Exceptions;


public class NoEmployeeExists extends RuntimeException {
    public NoEmployeeExists(String s){
        super(s);
    }
}
