package com.example.repository;

import com.example.model.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {

    private static Map<Long, Book> database;

    public BookRepository() {
        database = new ConcurrentHashMap<>();
        database.put(1L , new Book(1L, "Libro1", "Author1"));
        database.put(2L , new Book(2L, "Libro2", "Author2"));
        database.put(3L , new Book(3L, "Libro3", "Author3"));
        database.put(4L , new Book(4L, "Libro4", "Author4"));
        database.put(5L , new Book(5L, "Libro5", "Author5"));
        database.put(6L , new Book(6L, "Libro6", "Author6"));
        database.put(7L , new Book(7L, "Libro7", "Author7"));
    }

    public Mono<Book> findById(Long id){
        return Mono.just(database.get(id));
    }

    public Flux<Book> findAll(){
        return Flux.fromIterable(database.values());
    }

    public Mono<Boolean> existById(Long id){
        return database.containsKey(id) ? Mono.just(true) : Mono.just(false);
    }

    public Mono<Book> save(Book book){
        if (book.getId() == null){
            Long id = database.values().stream().mapToLong(Book::getId).max().orElse(0L) + 1;
            book.setId(id);
        }
        database.put(book.getId(), book);
        return Mono.just(book);
    }

    public Mono<Void> deleteById(Long id){
        database.remove(id);
        return Mono.empty();
    }

    public Mono<Void> deleteAll(){
        database.clear();
        return Mono.empty();
    }

}
