package com.example.EmployeeDepartment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Size(min=2, max=30)
    @Column(name = "dep_name")
    private String depName;
    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(int id, String depName) {
        this.id = id;
        this.depName = depName;
    }

    public Department(String depName, List<Employee> employees) {
        this.depName = depName;
        this.employees = employees;
    }

    public Department(String depName) {
        this.depName=depName;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
