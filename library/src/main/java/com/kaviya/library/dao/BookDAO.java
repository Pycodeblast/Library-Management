package com.kaviya.library.dao;

import com.kaviya.library.model.Book;
import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    Book getBook(String isbn);
    List<Book> getAllBooks();
    void updateBook(Book book); // Optional: to update book details

    Book save(Book book);
}
