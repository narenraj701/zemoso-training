package com.example.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

enum STATUS
{
    START_READING, READ, WANT_TO_READ;
}
@Entity
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
