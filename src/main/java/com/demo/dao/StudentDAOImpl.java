package com.demo.dao;

import com.demo.common.DBConnection;
import com.demo.controller.StudentController;
import com.demo.dto.BookDTO;
import com.demo.dto.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    StudentDAOImpl(){}
    public StudentDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public List<StudentDTO> getAllStudents() throws SQLException {
        List<StudentDTO> listStudent = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                boolean gender = resultSet.getBoolean("Gender");
                StudentDTO student = new StudentDTO(studentID, name, age, gender);
                listStudent.add(student);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving all students: " + e.getMessage());
        }
        return listStudent;
    }

    @Override
    public boolean addNewStudent(StudentDTO newStudent) throws SQLException {
        String sql = "INSERT INTO students (Name, Age, Gender) VALUES (?, ?, ?)";
        connect();
        Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, newStudent.getName());
        statement.setInt(2, newStudent.getAge());
        statement.setBoolean(3, newStudent.isGender());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws SQLException {
        String sql = "UPDATE students SET Name = ?, Age = ?, Gender = ? WHERE StudentID = ?";
        connect();
        Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setBoolean(3, student.isGender());
        statement.setInt(4, student.getStudentID());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    @Override
    public boolean deleteStudent(StudentDTO student) throws SQLException {
        String sql = "DELETE FROM students WHERE StudentID = ?";

        connect();
        Connection conn = DBConnection.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, student.getStudentID());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    @Override
    public StudentDTO getStudentById(int StudentID) throws SQLException {
        StudentDTO student= null;
        String sql = "SELECT * FROM students WHERE StudentID = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, StudentID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("Name");
            int age = resultSet.getInt("Age");
            boolean gender = resultSet.getBoolean("Gender");

            student = new StudentDTO( name, age, gender);
        }
        resultSet.close();
        statement.close();
        return student;
    }
}
