package com.kaviya.library.service;

import com.kaviya.library.dao.MemberDAO;
import com.kaviya.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    /**
     * Adds a new member to the system and returns the added member.
     * @param member The member to add.
     * @return The added member.
     */
    public Member addMember(Member member) {
        return memberDAO.addMember(member);
    }

    /**
     * Retrieves a member by their ID.
     * @param memberId The ID of the member.
     * @return The member with the specified ID or null if not found.
     */
    public Member getMember(int memberId) {
        return memberDAO.getMember(memberId);
    }

    /**
     * Retrieves all members in the system.
     * @return A list of all members.
     */
    public List<Member> getAllMembers() {
        return memberDAO.getAllMembers();
    }
    // New method to check if the member has borrowed books
    public boolean hasBorrowedBooks(int memberId) {
        Member member = getMember(memberId);
        return member != null && !member.getBorrowedBooks().isEmpty();
    }
}
