package com.example.EmployeeDepartment.ServiceImpl;

import com.example.EmployeeDepartment.DAO.DepartmentRepository;
import com.example.EmployeeDepartment.DAO.EmployeeRepository;
import com.example.EmployeeDepartment.entity.Department;
import com.example.EmployeeDepartment.entity.Employee;
import com.example.EmployeeDepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Optional<Employee> emp=employeeRepository.findById(id);
        if(!emp.isPresent())
            return null;
        return emp.get();
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

    @Override
    public Employee getEmployeeByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    private void delete(Employee emp, List<Employee> employees) {
        employees.remove(emp);
    }
}
