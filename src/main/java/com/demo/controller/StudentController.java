package com.demo.controller;
import com.demo.dto.StudentDTO;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("dbURL");
        String jdbcUsername = getServletContext().getInitParameter("dbUsername");
        String jdbcPassword = getServletContext().getInitParameter("dbPassword");

        this.studentService = new StudentServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);
    }
    public StudentController(){}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
        try {
            switch (action) {
                case "new":
                    RequestDispatcher addDispatcher = request.getRequestDispatcher("addStudentForm.jsp");
                    addDispatcher.forward(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    this.showEditForm(request, response);
                    break;
                case "update":
                    this.updateStudent(request, response);
                    break;
                case "add":
                    this.addNewStudent(request, response);
                    break;
                default:
                    this.getListStudent(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void getListStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        List<StudentDTO> listStudent = this.studentService.getAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        StudentDTO existingStudent = this.studentService.getStudentById(studentID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editStudentForm.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int studentID = Integer.parseInt(request.getParameter("StudentID"));
        String name = request.getParameter("Name");
        int age = Integer.parseInt(request.getParameter("Age"));
        boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        StudentDTO updatedStudent = new StudentDTO(studentID, name, age, gender);
        this.studentService.updateStudent(updatedStudent);
        response.sendRedirect("student");
    }

    private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("Name");
        int age = Integer.parseInt(request.getParameter("Age"));
        boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        StudentDTO newStudent = new StudentDTO(name, age, gender);
        this.studentService.addNewStudent(newStudent);
        response.sendRedirect("student");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        StudentDTO studentToDelete = new StudentDTO();
        studentToDelete.setStudentID(studentID);
        this.studentService.deleteStudent(studentToDelete);
        response.sendRedirect("student");
    }
}