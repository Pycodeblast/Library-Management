package com.kaviya.library.dao;

import com.kaviya.library.model.Borrow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BorrowDAOImpl implements BorrowDAO {

    private final List<Borrow> borrowStore = new ArrayList<>();

    /**
     * Adds a borrow entry to the in-memory store.
     *
     * @param borrow The borrow entry to add.
     * @return The added borrow entry.
     */
    @Override
    public Borrow addBorrow(Borrow borrow) {
        borrowStore.add(borrow);
        System.out.println("Borrow added: " + borrow); // Log the added borrow for clarity
        return borrow; // Return the added borrow entry
    }

    /**
     * Retrieves all borrow entries for a specific member.
     * @param memberId The ID of the member.
     * @return A list of borrow entries for the specified member.
     */
    @Override
    public List<Borrow> getAllBorrowsForMember(int memberId) {
        return borrowStore.stream()
                .filter(borrow -> borrow.getMember() != null && borrow.getMember().getMemberId() == memberId)
                .collect(Collectors.toList());
    }
}
