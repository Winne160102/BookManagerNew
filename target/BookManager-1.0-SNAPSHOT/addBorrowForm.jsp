<%@ include file="home.jsp" %>
<html>
<head>
  <title>Add New Borrow</title>
</head>
<body>
<h2>Add New Borrow</h2>
<div class="container mt-4">
  <form id="borrowForm" action="borrow?action=add" method="post">
    <div class="form-group">
      <label for="studentID">Student ID:</label>
      <input type="number" class="form-control" id="studentID" name="studentID">
    </div>
    <div class="form-group">
      <label for="bookID">Book ID:</label>
      <input type="number" class="form-control" id="bookID" name="bookID">
    </div>
    <div class="form-group">
      <label for="quantity">Quantity:</label>
      <input type="number" class="form-control" id="quantity" name="quantity">
    </div>
    <div class="form-group">
      <label for="borrowDate">Borrow Date:</label>
      <input type="date" class="form-control" id="borrowDate" name="borrowDate">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
</html>