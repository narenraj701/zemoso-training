package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Department> getDepartments() {
        return  departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        if(!departmentRepository.existsById(department.getId()))
            return departmentRepository.save(department);
        Department dep= departmentRepository.findById(department.getId()).orElse(null);
        if(null==dep)
            dep=new Department();
        dep.setDepName(department.getDepName());
        departmentRepository.save(dep);
        return dep;
    }

    @Override
    public List<Employee> getEmployees(int dep_id) {
        List<Employee> employeeList= departmentRepository.findById(dep_id).get().getEmployees();
        return employeeList;
    }
    public Optional<Department> getDepById(int id){
        return departmentRepository.findById(id);
    }
}
