package com.demo.dao;

import com.demo.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<StudentDTO> getAllStudents() throws SQLException;
    boolean addNewStudent(StudentDTO newStudent) throws SQLException;
    boolean updateStudent(StudentDTO student) throws SQLException;
    boolean deleteStudent(StudentDTO student)throws SQLException;
    StudentDTO getStudentById(int id) throws SQLException;
}
