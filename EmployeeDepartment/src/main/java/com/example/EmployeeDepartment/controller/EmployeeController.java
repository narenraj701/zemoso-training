package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.services.EmployeeService;
import com.example.EmployeeDepartment.validator.EmployeeValidator;
import com.example.EmployeeDepartment.validator.UpdateEmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeValidator employeeValidator;
    @Autowired
    private UpdateEmployeeValidator updateEmployeeValidator;

    @GetMapping("")
    public String getAllEmployees(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("emps", employees);
        return "employees-list";
    }

    @PostMapping("/{depId}")
    public String addEmployee(@PathVariable Integer depId,@Valid @ModelAttribute("obj") Employee employee, BindingResult result,Model model) {
        employeeValidator.validate(employee,result);
        if (result.hasErrors()) {
            return "employee-form";
        }
        Employee emp=service.addEmployee(employee, depId);
        model.addAttribute("empId",emp.getId());
        model.addAttribute("depId",emp.getDepartment().getId());

        return "resultPage";
       // return "redirect:/departments/" + departmentid + "/employees";
    }
    @PostMapping("/update/{depId}")
    public String UpdateEmployee(@PathVariable Integer depId,@Valid @ModelAttribute("obj") Employee employee, BindingResult result,Model model) {
        updateEmployeeValidator.validate(employee,result);
        if (result.hasErrors()) {
            return "updateEmployeeForm";
        }
        Employee emp=service.addEmployee(employee, depId);
        model.addAttribute("empId",emp.getId());
        model.addAttribute("depId",emp.getDepartment().getId());

        return "resultPage";
        // return "redirect:/departments/" + departmentid + "/employees";
    }
    @GetMapping("/{id}/{depId}")
    public String updateEmployee(@PathVariable(name = "id") int id,@PathVariable Integer depId, Model model) {
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("obj", emp);
        model.addAttribute("replace","Update");
        model.addAttribute("depId",depId);
        return "updateEmployeeForm";
    }

    @GetMapping("/delete/{id}/{depId}")
    public String deleteEmployee(@PathVariable(name = "id") int id,@PathVariable(name = "depId") int depId) {
        service.deleteEmployee(id);
        return "redirect:/departments/" + depId + "/employees";
    }

    @GetMapping("/showEmployeeForm/{depId}")
    public String showEmployeeForm(@PathVariable Integer depId, Model model) {
        Employee employee = new Employee();
        model.addAttribute("obj", employee);
        model.addAttribute("replace","Add");
        model.addAttribute("depId",depId);
        return "employee-form";
    }
}
