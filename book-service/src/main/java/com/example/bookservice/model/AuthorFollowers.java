package com.example.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="author_followers")
public class AuthorFollowers {
    @Id
    private UUID id;
    @Column(nullable = false)
    private UUID authorId;
    @Column(nullable = false)
    private UUID userId;
}
