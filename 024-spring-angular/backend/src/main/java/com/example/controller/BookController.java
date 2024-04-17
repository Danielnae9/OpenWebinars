package com.example.controller;

import com.example.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")

public class BookController {

    @GetMapping
    public List<Book> findAll() {
        System.out.println("findAll");
        return List.of(
          new Book(1L, "book1"),
          new Book(2L, "book2"),
          new Book(3L, "book3")
        );
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        System.out.println("findById " + id);
        return new Book(id, "book example");
    }

}
