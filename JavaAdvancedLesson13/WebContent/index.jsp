<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
<link rel="stylesheet" href="css/login.css">

<title>BookStore</title>
</head>

<body>
	<div class="login-page">
		<div class="form">
			<form class="register-form">
				<input class="firstName" type="text" placeholder="first name" /> <input
					class="lastName" type="text" placeholder="last name" /> <input
					class="email" type="text" placeholder="email address" /> <input
					class="age" type="text" placeholder="age" /> <input
					class="password" type="password" placeholder="password" /> <input
					class="cpassword" type="password" placeholder="confirm password" />

				<button class="register">create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>

			<form class="login-form">
				<input class="email" type="text" placeholder="email address" /> <input
					class="password" type="password" placeholder="password" />
				<button class="login">login</button>
				<p class="message">
					Not registered? <a href="#">Create an account</a>
				</p>
			</form>
		</div>
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<b>Success !</b> You are registered !
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="js/login.js"></script>
</body>
</html>