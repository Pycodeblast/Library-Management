package com.kaviya.library.dao;
import com.kaviya.library.model.Member;
import java.util.List;

public interface MemberDAO {
    Member addMember(Member member);
    Member getMember(int memberId);
    List<Member> getAllMembers();
}

