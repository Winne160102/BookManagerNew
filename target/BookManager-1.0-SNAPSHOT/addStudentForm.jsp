<%@ include file="home.jsp" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
<h2>Add New Student</h2>
<div class="container mt-4">
    <form id="studentForm" action="student?action=add" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="Name" >
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" class="form-control" id="age" name="Age" >
        </div>
        <div class="form-group">
            <label>Gender:</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="male" name="Gender" value="true">
                <label class="form-check-label" for="male">Male</label><br>
                <input type="radio" class="form-check-input" id="female" name="Gender" value="false">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
