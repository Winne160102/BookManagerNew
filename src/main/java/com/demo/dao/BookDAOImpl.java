package com.demo.dao;
import  com.demo.dao.BookDAO;
import com.demo.dto.BookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public BookDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super();
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    @Override
    public List<BookDTO> getAllBooks() throws SQLException {
        List<BookDTO> listBook = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int bookID = resultSet.getInt("BookID");
                String name = resultSet.getString("Name");
                int totalPage = resultSet.getInt("TotalPage");
                String type = resultSet.getString("Type");
                int quantity = resultSet.getInt("Quantity");
                BookDTO book = new BookDTO(bookID,name,totalPage,quantity);
                listBook.add(book);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving all books: " + e.getMessage());
        }
        return listBook;
    }

    @Override
    public boolean addNewBook(BookDTO newBook) throws SQLException {
        String sqlInsert = "INSERT INTO books ( BookID, Name, TotalPage, Type, Quantity) VALUES (?, ?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
        statement.setInt(1, newBook.getBookID());
        statement.setString(2, newBook.getName());
        statement.setInt(4, newBook.getTotalPage());
        statement.setInt(5, newBook.getQuantity());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public boolean updateBook(BookDTO book) throws SQLException {
        String sql = "UPDATE books SET  Name = ?, TotalPage = ?, Type = ?, Quantity=?  WHERE BookID = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getName());
        statement.setInt(2, book.getTotalPage());
        statement.setInt(3, book.getQuantity());
        statement.setInt(4, book.getBookID());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    @Override
    public boolean deleteBook(BookDTO book) throws SQLException {
        String sql = "DELETE FROM books where BookID = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getBookID());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    @Override
    public BookDTO getBookById(int bookID) throws SQLException {
        BookDTO book= null;
        String sql = "SELECT * FROM books WHERE BookID = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, bookID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("Name");
            int totalPage = resultSet.getInt("TotalPage");
            int quantity = resultSet.getInt("Quantity");

            book = new BookDTO(bookID, name, totalPage, quantity);
        }
        resultSet.close();
        statement.close();
        return book;
    }
}