<%@include file="home.jsp"%>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<h2>Add New Book</h2>
<div class="container mt-4">
    <form id="booklist" action="book?action=insert" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="Name" >
        </div>
        <div class="form-group">
            <label for="totalPage">Total Page:</label>
            <input type="number" class="form-control" id="totalPage" name="TotalPage" >
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="Quantity" >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
