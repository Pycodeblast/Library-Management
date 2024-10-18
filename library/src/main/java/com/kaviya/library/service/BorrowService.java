package com.kaviya.library.service;

import com.kaviya.library.dao.BorrowDAO;
import com.kaviya.library.dao.MemberDAO;
import com.kaviya.library.model.Borrow;
import com.kaviya.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    private final BorrowDAO borrowDAO;
    private final MemberDAO memberDAO;

    @Autowired
    public BorrowService(BorrowDAO borrowDAO, MemberDAO memberDAO) {
        this.borrowDAO = borrowDAO;
        this.memberDAO = memberDAO;
    }

    public Borrow addBorrow(Borrow borrow) {
        // Add the borrow entry to the borrow store
        Borrow savedBorrow = borrowDAO.addBorrow(borrow);

        // Update the member's borrowed books list
        Member member = memberDAO.getMember(borrow.getMember().getMemberId());
        if (member != null) {
            member.getBorrowedBooks().add(savedBorrow);

        }

        return savedBorrow; // Return the saved borrow entry
    }

    public List<Borrow> getAllBorrowsForMember(int memberId) {
        return borrowDAO.getAllBorrowsForMember(memberId);
    }
}
