package com.example.EmployeeDepartment.services;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Department department = departmentRepository.findById(id).orElse(null);
        if (null != department) {
            employee.setDepartment(department);
        }
        //save employee
        Employee emp = employeeRepository.save(employee);
        //get list of employees for that department
        List<Employee> employeeList = emp.getDepartment().getEmployees();
        if (null == employeeList) {
            employeeList = new ArrayList<>();
        }
        if (!employeeList.contains(emp)) {
            employeeList.add(emp);
        }
        return emp;
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return;
        }
        Employee emp = getEmployeeById(id);
        Department dep = departmentRepository.
                findById(emp.getDepartment().getId()).orElse(null);
        if (null != dep) {
            delete(emp, dep.getEmployees());
        }
        employeeRepository.deleteById(id);
    }

    private void delete(Employee emp, List<Employee> employees) {
        employees.remove(emp);
    }
}
