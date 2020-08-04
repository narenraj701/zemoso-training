package com.example.bookservice.serviceImpl;

import com.example.bookservice.DAO.BookRepository;
import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        return bookRepository.findById(id);
    }
}
