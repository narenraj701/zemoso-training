package com.example.EmployeeDepartment.validator;


import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class EmployeeValidator implements Validator {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (employeeService.getEmployeeByLastName(employee.getLastName())!=null) {
            errors.rejectValue("lastName", "duplicate.LastName");
        }

    }
}
