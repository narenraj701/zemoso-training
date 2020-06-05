package com.example.EmployeeDepartment.DAOimpl;

import com.example.EmployeeDepartment.DAO.CustomRepo;
import com.example.EmployeeDepartment.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class RepoImpl implements CustomRepo {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Employee> getEmployeeNoDepartment() {
        Query query = entityManager.createNativeQuery("SELECT * FROM employees " +
                "WHERE dep_id is ?", Employee.class);
        query.setParameter(1, null);
        return query.getResultList();
    }
    public void addEmployee(String empid,String depid){
        int query = entityManager.createNativeQuery("UPDATE employees "+
                "set dep_id=? "+
                "WHERE id=?", Employee.class).
                setParameter(1,Integer.parseInt(depid)).
                setParameter(2,Integer.parseInt(empid)).
                executeUpdate();

    }
}
