package com.example.EmployeeDepartment.validator;

import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmployeeValidator implements Validator {

    @Autowired
    EmployeeService employeeService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty");
        if (employeeService.getEmployeeByEmailId(employee.getEmailId()).isPresent()) {
            errors.rejectValue("emailId", "duplicate.emailId");
        }
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(employee.getEmailId());
        if(!matcher.matches()) {
            errors.rejectValue("emailId", "validity.emailId");
        }
        regex = "(0/91)?[7-9][0-9]{9}";
        pattern = Pattern.compile(regex);
        matcher=pattern.matcher(employee.getMobileNumber());
        if(!matcher.matches()) {
            errors.rejectValue("mobileNumber", "validity.mobileNumber");
        }
        Date date= new Date();
        int age=date.getYear()-employee.getDateOfBirth().getYear();
        if(age<16){
            errors.rejectValue("dateOfBirth", "validity.age");
        }
        if(employee.getDateOfJoining().before(date)){
            errors.rejectValue("dateOfJoining", "validity.join");
        }
    }
}
