package com.demo.service;

import com.demo.dao.BorrowDAO;
import com.demo.dao.BorrowDAOImpl;
import com.demo.dao.StudentDAO;
import com.demo.dao.StudentDAOImpl;
import com.demo.dto.BorrowDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BorrowServiceImpl implements BorrowService{
    private BorrowDAO borrowDAO;

    public BorrowDAO getBorrowDAO(){
        return this.borrowDAO;
    }

    public void setBorrowDAO(BorrowDAO borrowDAO){
        this.borrowDAO = borrowDAO;
    }

    public BorrowServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.borrowDAO = new BorrowDAOImpl(jdbcURL, jdbcUsername, jdbcPassword);
    }
    @Override
    public List<BorrowDTO> getAllBorrows() throws SQLException {
        return this.borrowDAO.getAllBorrows();
    }

    @Override
    public boolean addNewBorrow(BorrowDTO newBorrow) throws SQLException {
        return this.borrowDAO.addNewBorrow(newBorrow);
    }

    @Override
    public boolean updateBorrow(BorrowDTO borrow) throws SQLException {
        return this.borrowDAO.updateBorrow(borrow);
    }

    @Override
    public boolean deleteBorrow(BorrowDTO borrow) throws SQLException {
        return this.borrowDAO.deleteBorrow(borrow);
    }

    @Override
    public BorrowDTO getBorrowById(int borrowID) throws SQLException {
        return this.borrowDAO.getBorrowById(borrowID);
    }
}
