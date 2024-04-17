package com.example.service;

import com.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
}
