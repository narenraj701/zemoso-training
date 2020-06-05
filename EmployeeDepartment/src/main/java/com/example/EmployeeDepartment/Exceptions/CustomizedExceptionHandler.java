package com.example.EmployeeDepartment.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler
    String handleException(DepartmentNotFound exc, Model model) {
        ErrorDetails error = new ErrorDetails();
        model.addAttribute("message", exc.getMessage());
        return "errorHandler";
    }

    @ExceptionHandler
    ResponseEntity<ErrorDetails> handleException(EmployeeNotFound exc) {
        ErrorDetails error = new ErrorDetails();

        error.setMessage(exc.getMessage());
        error.setDetails(String.valueOf(HttpStatus.NOT_FOUND));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
