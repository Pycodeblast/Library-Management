package com.kaviya.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a book in the library system.
 */
@Data
@NoArgsConstructor // Creates a no-argument constructor
@AllArgsConstructor // Creates a constructor with parameters for all fields
public class Book {
    private String isbn; // Unique identifier for the book (International Standard Book Number)
    private String name; // Title of the book
    private String author; // Name of the book's author
    private Integer memberId; // ID of the member who borrowed the book; nullable if the book is available
    private boolean available = true; // Indicates whether the book is available for borrowing; defaults to true
}
