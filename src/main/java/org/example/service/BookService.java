package org.example.service;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;


@Service
public class BookService {

//    private final HashMap<Long, Book> books = new HashMap<>();
//    private long lastId = 0;

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBook(long id) {
        return bookRepository.findById(id).get();
    }

    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
