package com.example.bookservice.model;

import lombok.Data;

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
    private UUID userId;
    private UUID bookId;
    private STATUS status;
    private int noOfPagesRead;
    private boolean bookmarked;
}
