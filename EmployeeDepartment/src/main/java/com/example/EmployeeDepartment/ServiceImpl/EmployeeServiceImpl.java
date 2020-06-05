package com.example.EmployeeDepartment.ServiceImpl;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.Exceptions.EmployeeNotFound;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee, int id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
        }
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (!emp.isPresent()) {
            throw new EmployeeNotFound("No Employee Exists with id " + id);
        }
        return emp.get();
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Optional<Employee> getEmployeeByEmailId(String emailId) {
        return employeeRepository.findByEmailId(emailId);
    }

}
