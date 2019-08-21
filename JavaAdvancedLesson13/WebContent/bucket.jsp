<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cabinet</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

<link rel="stylesheet" href="css/bucket.css">
</head>
<body>
	<h1>Welcome to the cabinet ${userEmail}</h1>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names.." title="Type in a name">

			<table id="myTable">

			</table>

		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="js/header.js"></script>
	<script src="js/bucket.js"></script>
</body>
</html>