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
      <c:forEach var="book" items="${listBook}">
        <tr>
          <td>${book.bookID}</td>
          <td>${book.name}</td>
          <td>${book.totalPage}</td>
          <td>${book.quantity}</td>
          <td>
            <a href="book?action=edit&bookID=${book.bookID}">Edit</a>
            &nbsp;
            <a href="book?action=delete&bookID=${book.bookID}">Delete</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>