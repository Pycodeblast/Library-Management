package com.kaviya.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * Represents a borrowing record for a book in the library.
 */
@Data // Lombok annotation to generate getter, setter, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with parameters for all fields
public class Borrow {
    private Long bookId; // Unique identifier for the borrowed book (could also be a String)
    private LocalDate startDate; // The date when the book was borrowed
    private LocalDate endDate; // The date when the book is expected to be returned
    private Member member; // The member who borrowed the book
}
