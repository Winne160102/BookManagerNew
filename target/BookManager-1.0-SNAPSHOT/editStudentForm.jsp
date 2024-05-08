<%@include file="home.jsp"%>
<html>
<head>
  <title>Edit Student</title>
</head>
<body>
<h2>Edit Student</h2>
<form action="student?action=update" method="post">
  <input type="number" class="form-control" id="studentID" name="StudentID" value="<%= request.getParameter("studentID") %>" readonly>
  Name: <input type="text" id="name" name="Name" value="${student.name}"><br>
  Age: <input type="text" id="age" name="Age" value="${student.age}"><br>
  Gender:
  <input type="radio" name="Gender" value="true" <c:if test="${student.gender}"></c:if>>Male
  <input type="radio" name="Gender" value="false" <c:if test="${!student.gender}"></c:if>>Female

  <div>
    <input type="hidden" name="action" value="update">
    <input type="submit" value="Update Student">
  </div>
</form>
</body>
</html>
