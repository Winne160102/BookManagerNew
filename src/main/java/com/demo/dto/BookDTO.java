package com.demo.dto;

public class BookDTO {
    private int bookID;
    private String name;
    private int totalPage;
    private int quantity;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookDTO(int bookID, String name, int totalPage, int quantity) {
        this.bookID = bookID;
        this.name = name;
        this.totalPage = totalPage;
        this.quantity = quantity;
    }

    public BookDTO(String name, int totalPage, int quantity) {
        this.name = name;
        this.totalPage = totalPage;
        this.quantity = quantity;
    }
}
