package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    BookService bookService;
    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    void findAll() {

        when(bookRepository.findAll()).thenReturn(List.of());

        List<Book> books = bookService.findAll();

        //JUnit
        assertNotNull(books);
        assertEquals(0, books.size());
        //Mockito
        verify(bookRepository, times(1)).findAll();

    }

    @Test
    void findByIdFound() {

        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book(1L, "book1", "description1")));

        Optional<Book> bookOpt = bookService.findById(1L);

        //JUnit
        assertNotNull(bookOpt);
        assertTrue(bookOpt.isPresent());
        assertEquals("book1", bookOpt.get().getTitle());
        //Mockito
        verify(bookRepository, times(1)).findById(1L);

    }
}