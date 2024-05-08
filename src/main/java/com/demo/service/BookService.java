package com.demo.service;

import com.demo.dto.BookDTO;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks() throws SQLException;
    boolean addNewBook(BookDTO newBook) throws SQLException;
    boolean updateBook(BookDTO book) throws SQLException;
    boolean deleteBook(BookDTO book)throws SQLException;
    BookDTO getBookById(int bookid) throws SQLException;
}
