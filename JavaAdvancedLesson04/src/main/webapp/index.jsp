<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lesson 4</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<form action="registration" method="post">
		<label>First Name : <br><input name="firstName"></label>
		<br>
		<label>Last Name : <br><input name="lastName"></label>
		<br>
		<label>Email : <br><input name="email"></label>
		<br>
		<label>Password : <br><input name="password"></label>
		<br><br>
		<input type="submit" value="Submit">
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>