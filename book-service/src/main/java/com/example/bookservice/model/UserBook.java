package com.example.bookservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

enum STATUS
{
    START_READING,CURRENTLY_READING, WANT_TO_READ , READ ;
}
@Entity
@Data
@Table(name = "user_book_Details")
public class UserBook {
    @Id
    private UUID id;
    @Column(nullable = false)
    private UUID userId;
    @Column(nullable = false)
    private UUID bookId;
    @Column(nullable = false)
    private STATUS status;
    private int noOfPagesRead;
    @Column(nullable = false)
    private boolean bookmarked;
}
