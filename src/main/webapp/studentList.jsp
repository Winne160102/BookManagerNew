<%@ page import="com.demo.common.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="home.jsp"%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<h2>List of Student</h2>
<div class="tab-content mt-3">
    <div id="students" class="tab-pane fade show active">
        <table class="table">
            <thead>
            <tr>
                <th>StudentID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Actions</th>
                <th><button class="btn"><a href="StudentController?action=new">Add New Student</a></button></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.gender ? 'Male' : 'Female'}</td>
                    <td>
                        <a href="student?action=edit&studentID=<c:out value='${student.studentID}' />">Edit</a>
                        &nbsp;
                        <a href="student?action=delete&studentID=<c:out value='${student.studentID}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>