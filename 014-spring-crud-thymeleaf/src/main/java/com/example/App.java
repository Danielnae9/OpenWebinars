package com.example;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);

		var repository = context.getBean(BookRepository.class);

		List<Book> books = List.of(
				new Book(null, "Book 1", "Author 1", 10.99),
				new Book(null, "Book 2", "Author 2", 9.99),
				new Book(null, "Book 3", "Author 3", 12.59),
				new Book(null, "Book 4", "Author 4", 7.99)
		);

		repository.saveAll(books);
	}

}
