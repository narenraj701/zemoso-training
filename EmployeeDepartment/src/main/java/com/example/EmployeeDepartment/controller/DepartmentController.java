package com.example.EmployeeDepartment.controller;

import com.example.EmployeeDepartment.DAO.CustomRepo;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.services.EmployeeService;
import com.example.EmployeeDepartment.validator.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private DepartmentValidator departmentValidator;
    @Autowired
    CustomRepo customRepo;

    @GetMapping("/employees")
    public String getEmployeesWithNoDepartments(Model model) {
        List<Department> deps = departmentService.getDepartments();
        List<Employee> emps = customRepo.getEmployeeNoDepartment();
        model.addAttribute("noDepEmps", emps);
        model.addAttribute("depnames", deps);
        return "assignEmployees";
    }

    @GetMapping("/addEmp")
    public String addEmp(@PathParam("ID") String ID, @PathParam("EMPID") String EMPID, Model model) {
        System.out.println(ID);
        System.out.println(EMPID);
        customRepo.addEmployee(EMPID, ID);
        model.addAttribute("empid", EMPID);
        model.addAttribute("depid", ID);
        return "helper";
    }

    @GetMapping("")
    public String getDepartments(Model model) {
        List<Department> list = departmentService.getDepartments();
        model.addAttribute("deps", list);
        return "departments";
    }

    @PostMapping("")
    public String addDepartment(@Valid @ModelAttribute("depObj") Department dep, BindingResult result) {
        departmentValidator.validate(dep, result);
        if (result.hasErrors())
            return "Department-form";
        departmentService.addDepartment(dep);

        return "redirect:/departments";
    }

    @GetMapping("/{id}/employees")
    public String getEmployees(@PathVariable(name = "id") int id, Model model) {
        List<Employee> employeeList = departmentService.getEmployees(id);
        model.addAttribute("emps", employeeList);
        model.addAttribute("empDep", departmentService.getDepartmentById(id).get().getName());
        model.addAttribute("depId",id);
        return "employees-list";
    }

    @GetMapping("/showDepartmentForm")
    public String showDepartmentForm(Model model) {
        Department dep = new Department();
        model.addAttribute("depObj", dep);
        return "Department-form";
    }
}
