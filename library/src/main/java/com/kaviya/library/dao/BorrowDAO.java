package com.kaviya.library.dao;

import com.kaviya.library.model.Borrow;
import java.util.List;

public interface BorrowDAO {
    Borrow addBorrow(Borrow borrow);
    List<Borrow> getAllBorrowsForMember(int memberId);
}

