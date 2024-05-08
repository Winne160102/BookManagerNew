<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Search Borrow</title>
</head>
<body>
<h2>Search Borrow</h2>
<div class="container">
  <form action="search" method="GET">
    <div class="form-group">
      <label for="keyword">Keyword:</label>
      <input type="text" class="form-control" id="keyword" name="keyword">
    </div>
    <div class="form-group">
      <label for="borrowDate">Borrow Date:</label>
      <input type="date" class="form-control" id="borrowDate" name="borrowDate">
    </div>
    <div class="form-group">
      <label for="quantity">Quantity:</label>
      <input type="number" class="form-control" id="quantity" name="quantity">
    </div>
    <button type="submit" class="btn btn-primary">Search</button>
  </form>
</div>
<div class="container mt-4">
  <h3>Search Result</h3>
  <table class="table">
    <thead>
    <tr>
      <th>Borrow ID</th>
      <th>Student ID</th>
      <th>Book ID</th>
      <th>Quantity</th>
      <th>Borrow Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="borrow" items="${searchResult}">
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
</body>
</html>
