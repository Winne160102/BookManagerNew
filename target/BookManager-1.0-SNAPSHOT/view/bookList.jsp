<%@ page import="com.demo.common.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<h2>List of Books</h2>
<div class="tab-content mt-3">
  <div id="books" class="tab-pane fade show active">
    <table class="table">
      <thead>
      <tr>
        <th>BookID</th>
        <th>Name</th>
        <th>TotalPage</th>
        <th>Quantity</th>
        <th>Actions</th>
        <th><button class="btn"><a href="BookController?action=new">Add New Book</a></button></th>
      </tr>
      </thead>
      <tbody>
      <%
        try {
          Connection conn = DBConnection.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM books");
      %>
      <c:forEach var="book" items="${listBook}">
        <tr>
          <td>${book.bookID}</td>
          <td>${book.name}</td>
          <td>${book.totalPage}</td>
          <td>${book.quantity}</td>
          <td>
            <a href="students?action=edit&id=<c:out value='${book.bookID}' />">Edit</a>
            &nbsp;
            <a href="students?action=delete&id=<c:out value='${book.bookID}' />">Delete</a>
          </td>
        </tr>
      </c:forEach>
      <%
          rs.close();
          stmt.close();
          DBConnection.closeConnection(conn);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      %>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>
