package com.kaviya.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a member of the library.
 */
@Data // Lombok annotation to generate getter, setter, equals, hashCode, and toString methods
@NoArgsConstructor // Creates a no-argument constructor
@AllArgsConstructor // Creates a constructor with parameters for all fields
public class Member {
    private int memberId; // Unique identifier for the member
    private String name; // Name of the member
    private String contactInfo; // Contact information for the member (e.g., email or phone number)
    private List<Borrow> borrowedBooks = new ArrayList<>(); // List of borrowed books associated with the member

}
