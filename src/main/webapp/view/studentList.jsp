<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productList.css" />
    <title>List of Students</title>
</head>
<body>
<div class="survey-page">
    <h1 id="title">Student Management</h1>
    <div id="form-container">
        <h2>
            <a href="students?action=new">Add New Student</a>
        </h2>
        <table cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${listS}">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.gender ? 'Male' : 'Female'}</td>
                    <td>
<%--                        <a href="students?action=edit&id=<c:out value='${student.studentID}' />">Edit</a>--%>
<%--                        &nbsp;--%>
<%--                        <a href="students?action=delete&id=<c:out value='${student.studentID}' />">Delete</a>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
