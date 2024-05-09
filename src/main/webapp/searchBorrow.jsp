<%@ include file="home.jsp" %>
<html>
<head>
  <title>Search Borrow</title>
</head>
<body>
<h1>Search Borrow</h1>
<div class="container mt-4">
  <form id="searchForm" action="BorrowController?action=search" method="post">
    <div class="form-group">
      <label for="keyword">Keyword:</label>
      <input type="text" class="form-control" id="keyword" name="keyword">
    </div>
    <button type="submit" class="btn btn-primary">Search</button>
  </form>
</div>

<h2>Search Result</h2>
<table class="table table-bordered">
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
  <c:forEach items="${searchResult}" var="borrow">
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
</body>
</html>
