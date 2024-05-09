package com.demo.dao;

import com.demo.dto.BookDTO;
import com.demo.dto.BorrowDTO;
import com.demo.dto.StudentDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface BorrowDAO {
    List<BorrowDTO> getAllBorrows() throws SQLException;
    boolean addNewBorrow(BorrowDTO newBorrow) throws SQLException;
    boolean updateBorrow(BorrowDTO borrow) throws SQLException;
    boolean deleteBorrow(BorrowDTO borrow)throws SQLException;
    BorrowDTO getBorrowById(int borrowID) throws SQLException;
    List<BorrowDTO> searchBorrow(String keyword) throws SQLException;
}
