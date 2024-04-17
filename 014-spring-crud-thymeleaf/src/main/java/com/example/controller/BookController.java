package com.example.controller;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/")
    public String index(){
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String findAll(Model model){
        model.addAttribute("books", repository.findAll());
        return "book-list";
    }

    @GetMapping("/books/view/{id}")
    public String findById(Model model, @PathVariable Long id) {
        model.addAttribute("book", repository.findById(id).get());
        return "book-view";
    }

    @GetMapping("/books/form")
    public String getEmptyForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @GetMapping("/books/edit/{id}")
    public String getFormWithBook(@PathVariable Long id,  Model model) {
        if (repository.existsById(id)) {
            repository.findById(id).ifPresent(b -> model.addAttribute("book", b));
            return "book-form";
        } else {
            return "redirect:/books/form";
        }
    }

    @PostMapping("/books")
    public String create(@ModelAttribute Book book) {
        if (book.getId() != null) {
            //Actualización
            repository.findById(book.getId()).ifPresent(book1 -> {
                book1.setTitle(book.getTitle());
                book1.setAuthor(book.getAuthor());
                book1.setPrice(book.getPrice());
                repository.save(book1);
            });
        } else {
            //Creación
            repository.save(book);
        }
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }

        return "redirect:/books";
    }
}
