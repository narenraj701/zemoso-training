package com.example.EmployeeDepartment.ServiceImpl;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.DepartmentService;
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
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Employee> getEmployees(int dep_id) {
        Optional<Department> department = departmentRepository.findById(dep_id);
        if(!department.isPresent()) {
            return null;
        }
        List<Employee> employeeList = department.get().getEmployees();
        return employeeList;
    }

    public Optional<Department> getDepById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department getDepartmentByName(String depName) {
        return departmentRepository.findByDepartmentName(depName);
    }
}
