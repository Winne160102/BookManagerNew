<%@include file="home.jsp"%>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<div class="container mt-4">
    <form id="bookForm" action="book?action=update" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="Name" value="${book.name}">
        </div>
        <div class="form-group">
            <label for="totalPage">Total Pages:</label>
            <input type="number" class="form-control" id="totalPage" name="TotalPage" value="${book.totalPage}">
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="Quantity" value="${book.quantity}">
        </div>
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="bookID" value="${book.bookID}">
        <button type="submit" class="btn btn-primary">Update Book</button>
    </form>
</div>
</body>
</html>
