package com.kaviya.library.dao;

import com.kaviya.library.model.Book;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class BookDAOImpl implements BookDAO {

    private final HashMap<String, Book> bookStore = new HashMap<>();

    @Override
    public void addBook(Book book) {
        bookStore.put(book.getIsbn(), book);
    }

    @Override
    public Book getBook(String isbn) {
        return bookStore.get(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    @Override
    public void updateBook(Book book) {
        bookStore.put(book.getIsbn(), book);
    }

    @Override
    public Book save(Book book) {
        bookStore.put(book.getIsbn(), book);
        return book; // Return the saved book
    }
}
