package com.demo.service;

import com.demo.dao.BookDAO;
import com.demo.dao.BookDAOImpl;
import com.demo.dto.BookDTO;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookDAO getBookDAO(){
        return this.bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public BookServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.bookDAO = new BookDAOImpl(jdbcURL, jdbcUsername, jdbcPassword);
    }


    @Override
    public List<BookDTO> getAllBooks() throws SQLException {
        return this.bookDAO.getAllBooks();
    }

    @Override
    public boolean addNewBook(BookDTO newBook) throws SQLException {
        return this.bookDAO.addNewBook(newBook);
    }

    @Override
    public boolean updateBook(BookDTO book) throws SQLException {
        return this.bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBook(BookDTO book) throws SQLException {
        return this.bookDAO.deleteBook(book);
    }

    @Override
    public BookDTO getBookById(int bookid) throws SQLException {
        return this.bookDAO.getBookById(bookid);
    }
}
