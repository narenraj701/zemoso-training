package com.example.bookservice.model;

import lombok.Data;

import java.util.UUID;
@Data
public class UserStats {
    private UUID userId;
    private int currentlyReadingCount;
    private int booksToReadCount;
    private int booksReadCount;
    private int targetCount;
}
