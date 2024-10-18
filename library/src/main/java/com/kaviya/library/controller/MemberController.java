package com.kaviya.library.controller;

import com.kaviya.library.model.Member;
import com.kaviya.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        System.out.println("Adding member: " + member);
        Member savedMember = memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember); // Returns 201 Created
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable int memberId) {
        Member member = memberService.getMember(memberId);
        if (member != null) {
            boolean hasBorrowedBooks = memberService.hasBorrowedBooks(memberId); // Check if the member has borrowed books
            // You can add this info to the response if desired
            System.out.println("Has borrowed books: " + hasBorrowedBooks);
            return ResponseEntity.ok(member); // Returns 200 OK with member details
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Returns 404 Not Found
        }
    }


    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        if (members.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Returns 204 No Content
        }
        return ResponseEntity.ok(members); // Returns 200 OK with the list of members
    }
}
