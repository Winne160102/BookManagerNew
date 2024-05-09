package com.demo.dao;

import com.demo.common.DBConnection;
import com.demo.dto.BorrowDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowDAOImpl implements BorrowDAO{
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    BorrowDAOImpl(){}
    public BorrowDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super();
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        DBConnection.getConnection();
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    @Override
    public List<BorrowDTO> getAllBorrows() throws SQLException {
        List<BorrowDTO> listBorrow = new ArrayList<>();
        String sql = "SELECT * FROM borrows";
        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int borrowID = resultSet.getInt("BorrowID");
                int studentID = resultSet.getInt("StudentID");
                int bookID = resultSet.getInt("BookID");
                int quantity = resultSet.getInt("Quantity");
                Date borrowDate = resultSet.getDate("BorrowDate");
                BorrowDTO borrow = new BorrowDTO(borrowID, studentID, bookID, quantity, borrowDate);
                listBorrow.add(borrow);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving all borrows: " + e.getMessage());
        }
        return listBorrow;
    }

    @Override
    public boolean addNewBorrow(BorrowDTO newBorrow) throws SQLException {
        String sql = "INSERT INTO borrows (studentID, bookID, quantity, borrowDate) VALUES (?, ?, ?, ?)";

        connect();
        Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, newBorrow.getStudentID());
        statement.setInt(2, newBorrow.getBookID());
        statement.setInt(3, newBorrow.getQuantity());
        statement.setDate(4, new java.sql.Date(newBorrow.getBorrowDate().getTime()));

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public boolean updateBorrow(BorrowDTO borrow) throws SQLException {
        String sql = "UPDATE borrows SET  StudentID = ?, BookID = ?, Quantity =?, BorrowDate = ?  WHERE BorrowID = ?";

        connect();
        Connection conn = DBConnection.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, borrow.getStudentID());
        statement.setInt(2, borrow.getBookID());
        statement.setInt(3, borrow.getQuantity());
        statement.setDate(4, new java.sql.Date(borrow.getBorrowDate().getTime()));
        statement.setInt(5, borrow.getBookID());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    @Override
    public boolean deleteBorrow(BorrowDTO borrow) throws SQLException {
        String sql = "DELETE FROM borrows WHERE BorrowID = ?";

        Connection conn = DBConnection.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, borrow.getBorrowID());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    @Override
    public BorrowDTO getBorrowById(int borrowID) throws SQLException {
        BorrowDTO borrow= null;
        String sql = "SELECT * FROM borrows WHERE BorrowID = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, borrowID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int studentID = resultSet.getInt("StudentID");
            int bookID = resultSet.getInt("BookID");
            int quantity = resultSet.getInt("Quantity");
            Date date = resultSet.getDate("Date");
            borrow = new BorrowDTO(studentID, bookID, quantity, date);
        }
        resultSet.close();
        statement.close();
        return borrow;
    }

    @Override
    public List<BorrowDTO> searchBorrow(String keyword) throws SQLException {
        List<BorrowDTO> resultList = new ArrayList<>();
        String sql = "SELECT * FROM borrows WHERE StudentID LIKE ? OR BookID LIKE ? OR Quantity LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int borrowID = resultSet.getInt("BorrowID");
                    int studentID = resultSet.getInt("StudentID");
                    int bookID = resultSet.getInt("BookID");
                    int quantity = resultSet.getInt("Quantity");
                    Date borrowDate = resultSet.getDate("BorrowDate");
                    BorrowDTO borrow = new BorrowDTO(borrowID, studentID, bookID, quantity, borrowDate);
                    resultList.add(borrow);
                }
            }
        }
        return resultList;
    }
}
