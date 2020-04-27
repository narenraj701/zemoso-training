package com.example.EmployeeDepartment;
import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.services.DepartmentService;
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
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @Test
    public void getDepartmentsTest(){
        Department dep=new Department("Zemsoso");
        Mockito.when(departmentRepository.findAll()).thenReturn
                (Stream.of(new Department("Zemoso"),
                        new Department("Microsoft"))
                        .collect(Collectors.toList()));
        Assert.assertEquals(2, departmentService.getDepartments().size());
    }
    @Test
    public void addDepartmentTest(){
        Department dep=new Department("Zemoso");
        Mockito.when(departmentRepository.save(dep)).thenReturn(dep);
        Assert.assertEquals(dep, departmentService.addDepartment(dep));
    }
    @Test
    public void getDepByIdTest(){
        int id=1;
        Department dep=new Department(1,"Zemsoso");
        Mockito.when(departmentRepository.findById(id)).thenReturn(Optional.of(dep));
        Assert.assertEquals(1, departmentService.getDepById(id).get().getId());
    }

}
