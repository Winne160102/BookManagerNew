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

<h2>List of Borrow</h2>
<div class="tab-content mt-3">
    <div id="borrows" class="tab-pane fade show active">
        <table class="table">
            <thead>
            <tr>
                <th>BorrowID</th>
                <th>StudentID</th>
                <th>BookID</th>
                <th>Quantity</th>
                <th>BorrowDate</th>
                <th>Action</th>
                <th><button class="btn"><a href="borrow?action=new">Borrow A New Book</a></button></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="borrow" items="${listBorrow}">
                <tr>
                    <td>${borrow.borrowID}</td>
                    <td>${borrow.studentID}</td>
                    <td>${borrow.bookID}</td>
                    <td>${borrow.quantity}</td>
                    <td>${borrow.borrowDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>