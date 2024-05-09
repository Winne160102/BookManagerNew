<%@ include file="home.jsp" %>
<html>
<head>
  <title>Edit Student</title>
</head>
<body>
<h2>Edit Student</h2>
<div class="container mt-4">
  <form id="studentForm" action="student?action=update" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="Name" value="${student.name}">
    </div>
    <div class="form-group">
      <label for="age">Age:</label>
      <input type="text" class="form-control" id="age" name="Age" value="${student.age}">
    </div>
    <div class="form-group">
      <label>Gender:</label>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="male" name="Gender" value="true" <c:if test="${student.gender}">checked</c:if>>
        <label class="form-check-label" for="male">Male</label>
      </div>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="female" name="Gender" value="false" <c:if test="${!student.gender}">checked</c:if>>
        <label class="form-check-label" for="female">Female</label>
      </div>
    </div>
    <input type="hidden" name="action" value="update">
    <button type="submit" class="btn btn-primary">Update Student</button>
  </form>
</div>
</body>
</html>
