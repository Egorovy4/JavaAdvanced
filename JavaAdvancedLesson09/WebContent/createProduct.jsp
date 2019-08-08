<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Creating</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

<link rel="stylesheet" href="css/productCreating.css">
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<form class="createProduct">
				<div class="form-group">
					<input type="text" class="form-control productName"
						placeholder="Enter product name">
				</div>

				<div class="form-group">
					<input type="text" class="form-control productDescription"
						placeholder="Enter description">
				</div>

				<div class="form-group">
					<input type="number" class="form-control productPrice"
						placeholder="Enter price">
				</div>

				<button class="btn btn-primary createProduct">Submit</button>
			</form>
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
	<script src="js/serverCalls.js"></script>
	<script src="js/header.js"></script>
</body>
</html>