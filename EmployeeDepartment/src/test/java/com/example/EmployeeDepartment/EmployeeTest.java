package com.example.EmployeeDepartment;

import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.Exceptions.EmployeeNotFound;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeesTest() {
        Department dep = new Department("Zemsoso");
        Mockito.when(employeeRepository.findAll()).thenReturn
                (Stream.of(new Employee("Naren", "Raju", dep),
                        new Employee("Vishal", "N", dep))
                        .collect(Collectors.toList()));
        Assert.assertNotNull(employeeRepository.findAll());
        Assert.assertEquals(2, employeeService.getEmployees().size());
    }

    @Test
    public void getEmployeeByIdTest() {
        int id = 1;
        Department dep = new Department("Zemsoso");
        Employee employee = new Employee(1, "Naren", "Raju", dep);
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.of((employee)));
        Assert.assertNotNull(employeeService.getEmployeeById(id).getId());
        Assert.assertEquals(1, employeeService.getEmployeeById(id).getId());
        boolean thrown = false;
        try {
            employeeService.getEmployeeById(2);
        } catch (EmployeeNotFound e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void saveEmpTest() {
        Department dep = new Department("Zemoso");
        Employee employee = new Employee(5, "Naren", "Raju", dep);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assert.assertNotNull(employeeService.addEmployee(employee, 5));
        Assert.assertEquals(employee, employeeService.addEmployee(employee, 5));
    }

    @Test
    public void deleteEmpTest() {
        employeeService.deleteEmployee(1);
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void getEmployeeByEmailIdTest() {
        Employee employee = new Employee("Naren", "Raju", null);
        Mockito.when(employeeRepository.findByEmailId("naren@gmail.com")).thenReturn(Optional.of(employee));
        Assert.assertNotNull(employeeService.getEmployeeByEmailId("naren@gmail.com"));
        Assert.assertEquals(Optional.of(employee), employeeService.getEmployeeByEmailId("naren@gmail.com"));
        Assert.assertEquals(Optional.empty(), employeeService.getEmployeeByEmailId("suresh@gmail.com"));
    }

    @Test
    public void editEmployeeTest() {
        Employee employee = new Employee("Naren", "Raju", null);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assert.assertNotNull(employeeRepository.save(employee));
        Assert.assertEquals(employee, employeeService.editEmployee(employee));
    }

}
