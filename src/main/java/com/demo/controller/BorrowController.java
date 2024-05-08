package com.demo.controller;

import com.demo.dto.BorrowDTO;
import com.demo.service.BorrowService;
import com.demo.service.BorrowServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/BorrowController")
public class BorrowController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BorrowService borrowService;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("dbURL");
        String jdbcUsername = getServletContext().getInitParameter("dbUsername");
        String jdbcPassword = getServletContext().getInitParameter("dbPassword");

        this.borrowService = new BorrowServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public BorrowController() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
        try {
            switch (action) {
                case "new":
                    RequestDispatcher addDispatcher = request.getRequestDispatcher("addBorrowForm.jsp");
                    addDispatcher.forward(request, response);
                    break;
                case "delete":
                    deleteBorrow(request, response);
                    break;
                case "add":
                    addNewBorrow(request,response);
                    break;
                default:
                    getListBorrow(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getListBorrow(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<BorrowDTO> listBorrow = this.borrowService.getAllBorrows();

        request.setAttribute("listBorrow", listBorrow);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrowList.jsp");
        dispatcher.forward(request, response);
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrowForm.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBorrow(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int borrowID = Integer.parseInt(request.getParameter("borrowID"));

        BorrowDTO borrowToDelete = new BorrowDTO();
        borrowToDelete.setBorrowID(borrowID);
        this.borrowService.deleteBorrow(borrowToDelete);

        response.sendRedirect("borrow");
    }

    private void addNewBorrow(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String borrowDateStr = request.getParameter("borrowDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date borrowDate = null;

        try {
            java.util.Date utilDate = dateFormat.parse(borrowDateStr);
            borrowDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BorrowDTO newBorrow = new BorrowDTO(studentID, bookID, quantity, borrowDate);
        this.borrowService.addNewBorrow(newBorrow);
        response.sendRedirect("borrow");
    }
}