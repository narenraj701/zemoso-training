package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    BookService bookService;

    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }


    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable UUID id){
        return bookService.getBookById(id);
    }
}
