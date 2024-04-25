package com.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.StudentDAOImpl;
import com.demo.dto.StudentDTO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentDAOImpl StudentDAO;

    /**
     * Default constructor
     */
    public StudentController() {
        StudentDAO = new StudentDAOImpl();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       StudentDAOImpl dao = new StudentDAOImpl();
        List<StudentDTO> list = null;
        try {
            list = dao.getAllStudents();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("listS", list);
        request.getRequestDispatcher("sudentList.jsp").forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
