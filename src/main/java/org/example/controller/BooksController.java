package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}") // GET http://localhost:8080/books/23
    public ResponseEntity<Book> getBookInfo(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping  // GET http://localhost:8080/books
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping()  // POST http://localhost:8080/books
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping  // PUT http://localhost:8080/books
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Book foundeBook = bookService.editBook(book);
        if (foundeBook == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundeBook);
    }

    @DeleteMapping("{id}")  // DELETE http://localhost:8080/books/23
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
