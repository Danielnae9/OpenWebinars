package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.repository.findById(id);
    }
}
