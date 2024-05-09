package com.demo.service;

import com.demo.dto.BorrowDTO;
import java.sql.SQLException;
import java.util.List;

public interface BorrowService {
    List<BorrowDTO> getAllBorrows() throws SQLException;
    boolean addNewBorrow(BorrowDTO newBorrow) throws SQLException;
    boolean updateBorrow(BorrowDTO borrow) throws SQLException;
    boolean deleteBorrow(BorrowDTO borrow)throws SQLException;
    BorrowDTO getBorrowById(int id) throws SQLException;
    List<BorrowDTO> searchBorrow(String keyword) throws SQLException;
}
