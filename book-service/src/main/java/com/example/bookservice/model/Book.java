package com.example.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String ISBN;
    @Column(nullable = false)
    private String title;
    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="category_id")
    private Category categoryId;
    @Lob
    private String image;
    @Column(nullable = false)
    private Date releaseDate;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private Integer totalPages;
    @Column(nullable = false)
    private String description;
    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="author_id")
    private Author authorId;
}
