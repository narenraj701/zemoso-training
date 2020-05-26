package com.example.EmployeeDepartment.validator;

import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DepartmentValidator implements Validator {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Department.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department department = (Department) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentName", "NotEmpty");
        if (departmentService.getDepartmentByName(department.getDepartmentName())!=null) {
            errors.rejectValue("departmentName", "duplicate.departmentName");
        }

    }
}