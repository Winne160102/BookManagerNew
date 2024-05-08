<%@include file="home.jsp"%>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<form action="book?action=update" method="post">
    Name: <input type="text" name="Name" value="${book.name}"><br>
    Total Pages: <input type="text" name="TotalPage" value="${book.totalPage}"><br>
    Quantity: <input type="text" name="Quantity" value="${book.quantity}"><br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="BookID" value="${book.bookID}">
    <input type="submit" value="Update Book">
</form>
</body>
</html>
