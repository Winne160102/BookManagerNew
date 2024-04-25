package com.demo.dto;

import java.util.Date;

public class BorrowDTO {
    private int borrowID;
    private int studentID;
    private int bookID;
    private int quantity;
    private Date borrowDate;

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public BorrowDTO(int borrowID, int studentID, int bookID, int quantity, Date borrowDate) {
        super();
        this.borrowID = borrowID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
    }
}
