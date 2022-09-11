<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student management System</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style> nav {font-size: 30px}	</style>
  <style> div {text-align: center;font-size: 25px}	</style>
</head>
<body>
	<h1 class="text-center">Student management System </h1>
	
	
	<nav><br>
		<a href="addStudent.jsp"><b>Add Student Details</b></a>&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp
		<a href="addClass.jsp"><b>Add Class Details</b></a>
				
	</nav><br><br>	<br><br>
	<div>
		
		<a href= ManageStudent>Manage Student </a><br><br>
		<a href= ManageClasses>Manage Class </a><br><br>
		<a href= ListTeacher>List Teacher </a><br><br>
		<a href= ListSubject>List Subject  </a><br><br>
		
	</div>
	<a href=home.jsp>back</a>
	
</body>
</html>