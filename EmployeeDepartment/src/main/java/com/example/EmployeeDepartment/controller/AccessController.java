package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.entity.User;
import com.example.EmployeeDepartment.services.EmployeeService;
import com.example.EmployeeDepartment.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;
import java.util.Optional;

@Controller
public class AccessController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;
    @GetMapping("/profile")
    public String profilePage(Model model, Authentication authentication)
    {
        String userName=authentication.getName();
        Optional<User> user=userService.findByUsername(userName);
        model.addAttribute("mobile",user.get().getMobile());
        return "profile";
    }
    @GetMapping("/employeeProfile/{id}")
    public String employeeView(@PathVariable(name = "id") int id, Model model){
        Employee employee=employeeService.getEmployeeById(id);
        byte[] image=employee.getPic();
        model.addAttribute("pic",Base64.getEncoder().encodeToString(image));
        int dep_id=employee.getDepartment().getId();
        model.addAttribute("dep_id",dep_id);
        model.addAttribute("employeeObj",employee);
        return "employeeProfile";
    }
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id){
        Employee employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+"Resume"+"\"")
                .body(new ByteArrayResource(employee.getResume()));
    }
}
