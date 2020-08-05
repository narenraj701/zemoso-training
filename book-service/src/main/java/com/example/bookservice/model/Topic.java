package com.example.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="topics")
public class Topic {
    @Id
    private UUID id;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Category.class)
    private List<Category> categories;
    private String name;
}

