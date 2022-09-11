<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class Form</title>
<title>Student management System</title>
	
</head>
<body>
	<h1 style="align:text-center"> Add Class</h1>

	<form action="AddClass" method="post">
	<fieldset>
		Class  :<br><input  name="classes" id="classes" type="text"> <br><br>
		Subject : <br> <input name="sub_name" id="sub_name" type="text" > <br><br>
		Teacher Name : <br> <input name="t_name" id="t_name" type="text" > <br><br>
	
		<input type="submit" value="AddClass"> <br><br>
		
	
		
	</fieldset>
	</form>
	
	<h3><a href="Home.html">Back </a></h3><h3 style="text-align:right"><a href="logout.jsp ">Logout  </a></h3>
</body>
</html>
