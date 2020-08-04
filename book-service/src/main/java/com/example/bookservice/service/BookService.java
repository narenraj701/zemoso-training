package com.example.bookservice.service;

import com.example.bookservice.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<Book> getBooks();
    Optional<Book> getBookById(UUID id);
}
