package com.kaviya.library.controller;

import com.kaviya.library.model.Borrow;
import com.kaviya.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    /**
     * Adds a new borrow entry to the system.
     * @param borrow The borrow entry to add.
     * @return The added borrow entry.
     */
    @PostMapping
    public ResponseEntity<Borrow> addBorrow(@RequestBody Borrow borrow) {
        System.out.println("Adding borrow: " + borrow);
        Borrow savedBorrow = borrowService.addBorrow(borrow);
        if (savedBorrow != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBorrow);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Handle not found case
        }
    }


    /**
     * Retrieves all borrow entries for a specific member.
     * @param memberId The ID of the member.
     * @return A list of borrow entries for the specified member.
     */
    @GetMapping("/member/{memberId}")
    public List<Borrow> getAllBorrowsForMember(@PathVariable int memberId) {
        return borrowService.getAllBorrowsForMember(memberId);
    }
}
