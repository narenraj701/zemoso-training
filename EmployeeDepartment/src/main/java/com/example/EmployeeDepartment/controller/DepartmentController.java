package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.Exceptions.NoDepartmentExists;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.validator.DepartmentValidator;
import com.example.EmployeeDepartment.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    public static int departmentid;
    @Autowired
    private DepartmentValidator departmentValidator;

    @GetMapping("")
    public String getDepartments(Model model) {
        List<Department> list = departmentService.getDepartments();
        model.addAttribute("deps", list);
        return "departments";
    }

    @PostMapping("")
    public String addDepartment(@Valid @ModelAttribute("depObj") Department dep, BindingResult result) {
        departmentValidator.validate(dep,result);
        if (result.hasErrors())
            return "Department-form";
        departmentService.addDepartment(dep);

        return "redirect:/departments";
    }

    @GetMapping("/{id}/employees")
    public String getEmployees(@PathVariable(name = "id") int id, Model model) {
        departmentid = id;
        List<Employee> employeeList = departmentService.getEmployees(id);
        if(employeeList==null){
            throw new NoDepartmentExists("No Department with ->"+id);
        }
        model.addAttribute("emps", employeeList);
        return "employees-list";
    }

    @GetMapping("/showDepartmentForm")
    public String showDepartmentForm(Model model) {
        Department dep = new Department();
        model.addAttribute("depObj", dep);
        return "Department-form";
    }
}
