package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.dto.StudentDTO;

public class StudentDAOImpl {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private Connection jdbcConnection;

    public StudentDAOImpl() { }

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

    public List<StudentDTO> getAllStudents() throws SQLException {
        List<StudentDTO> listStud = new ArrayList<StudentDTO>();

        String sql = "SELECT * FROM students";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("studentID");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            boolean gender = resultSet.getBoolean("gender");
            StudentDTO student = new StudentDTO(id, name, age, gender);
            listStud.add(student);
        }

        resultSet.close();
        statement.close();

        disconnect();
        return listStud;
    }

//    public boolean addNewProduct(StudentDTO newProduct) throws SQLException {
//        String sqlInsert = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
//        connect();
//        PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
//        statement.setString(1, newProduct.getName());
//        statement.setString(2, newProduct.getDescription());
//        statement.setFloat(3, newProduct.getPrice());
//
//        boolean rowInserted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowInserted;
//    }
//
//    public boolean updateProduct(ProductDTO product) throws SQLException {
//        String sql = "UPDATE product SET name = ?, description = ?, price = ?  WHERE product_id = ?";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, product.getName());
//        statement.setString(2, product.getDescription());
//        statement.setFloat(3, product.getPrice());
//        statement.setInt(4, product.getId());
//
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowUpdated;
//    }
//
//    public boolean deleteProduct(ProductDTO product) throws SQLException {
//        String sql = "DELETE FROM book where product_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, product.getId());
//
//        boolean rowDeleted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowDeleted;
//    }
//
    public StudentDTO getStudentById(int id) throws SQLException {
        StudentDTO stud = null;
        String sql = "SELECT * FROM students WHERE studentID = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("name");
            int age = resultSet.getInt("age");
            boolean gender = resultSet.getBoolean("gender");

            stud = new StudentDTO(id, title, age, gender);
        }

        resultSet.close();
        statement.close();

        return stud;
    }
}
