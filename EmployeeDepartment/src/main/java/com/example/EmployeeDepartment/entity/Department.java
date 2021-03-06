package com.example.EmployeeDepartment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Pattern(regexp = "[a-zA-Z]+[ a-zA-Z]+",message = "Enter a valid Department name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(int id, String depName) {
        this.id = id;
        this.name = depName;
    }

    public Department(String depName, List<Employee> employees) {
        this.name = depName;
        this.employees = employees;
    }

    public Department(String depName) {
        this.name = depName;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depName='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
