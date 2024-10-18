package com.kaviya.library.controller;

import com.kaviya.library.model.Book;
import com.kaviya.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        System.out.println("Request to add book: " + book);
        Book savedBook = bookService.addBook(book);
        System.out.println("Added book: " + savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        System.out.println("Retrieved book: " + book);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        System.out.println("Retrieved all books: " + books);
        return ResponseEntity.ok(books);
    }

    @PutMapping
    public ResponseEntity<Void> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        System.out.println("Updated book: " + book);
        return ResponseEntity.ok().build();
    }
}
