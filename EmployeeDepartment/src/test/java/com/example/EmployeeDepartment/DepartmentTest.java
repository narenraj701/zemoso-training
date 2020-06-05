package com.example.EmployeeDepartment;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.Exceptions.DepartmentNotFound;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void getDepartmentsTest() {
        Mockito.when(departmentRepository.findAll()).thenReturn
                (Stream.of(new Department("Zemoso"),
                        new Department("Microsoft"))
                        .collect(Collectors.toList()));
        Assert.assertNotNull(departmentService.getDepartments());
        Assert.assertEquals(2, departmentService.getDepartments().size());
    }

    @Test
    public void addDepartmentTest() {
        Department dep = new Department("Zemoso");
        Mockito.when(departmentRepository.save(dep)).thenReturn(dep);
        Assert.assertNotNull(departmentService.getDepartments());
        Assert.assertEquals(dep, departmentService.addDepartment(dep));
    }

    @Test
    public void getDepByIdTest() {
        int id = 1, id1 = 2;
        Department dep = new Department(1, "Zemsoso");
        Mockito.when(departmentRepository.findById(id)).thenReturn(Optional.of(dep));
        Assert.assertNotNull(departmentService.getDepartmentById(id));
        Assert.assertEquals(1, departmentService.getDepartmentById(id).get().getId());
        Assert.assertEquals(Optional.empty(),
                departmentService.getDepartmentById(id1));
    }

    @Test
    public void getDepartmentByNameTest() {
        String name = "Zemoso";
        Department dep = new Department(1, "Zemoso");
        Mockito.when(departmentRepository.findByName("Zemoso")).thenReturn(Optional.of(dep));
        Assert.assertNotNull(departmentService.getDepartmentByName(name));
        Assert.assertEquals("Zemoso",
                departmentService.getDepartmentByName("Zemoso").get().getName());
        Assert.assertEquals(Optional.empty(), departmentService.getDepartmentByName("Google"));
    }

    @Test
    public void getEmployeesByDepartmentId() {

        List<Employee> employeeList = new ArrayList<>();
        Department department = new Department(1, "Zemoso");
        Mockito.when(departmentRepository.findById(1)).thenReturn(Optional.of(department));
        boolean thrown = false;
        List<Employee> emps;
        emps = departmentService.getEmployees(1);
        System.out.println(emps);
        try {
            departmentService.getEmployees(2);

        } catch (DepartmentNotFound e) {
            thrown = true;
        }
        Assert.assertEquals(null, emps);
        Assert.assertTrue(thrown);

    }
}
