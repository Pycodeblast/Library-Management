package com.kaviya.library.service;

import com.kaviya.library.dao.BookDAO;
import com.kaviya.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    public Book getBook(String isbn) {
        return bookDAO.getBook(isbn);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
}
