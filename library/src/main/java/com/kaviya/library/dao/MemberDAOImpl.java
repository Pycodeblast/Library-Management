package com.kaviya.library.dao;

import com.kaviya.library.model.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private final HashMap<Integer, Member> memberStore = new HashMap<>();

    /**
     * Adds a member to the in-memory store.
     *
     * @param member The member to add.
     * @return
     */
    @Override
    public Member addMember(Member member) {
        memberStore.put(member.getMemberId(), member);
        return member; // Return the added member
    }

    /**
     * Retrieves a member by their ID from the in-memory store.
     * @param memberId The ID of the member.
     * @return The member with the specified ID or null if not found.
     */
    @Override
    public Member getMember(int memberId) {
        return memberStore.get(memberId);
    }

    /**
     * Retrieves all members from the in-memory store.
     * @return A list of all members.
     */
    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(memberStore.values());
    }
}
