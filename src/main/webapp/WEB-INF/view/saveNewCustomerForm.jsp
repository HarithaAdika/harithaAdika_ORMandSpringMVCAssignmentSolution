<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer Details</title>
<style type="text/css">
.header {
	text-align: center;
	veritcal-align: center;
	background: #1abc9c;
	color: white;
	font-size: 30px;
}
</style>
</head>

<body>

	<div class="container">

		<h3 class="header">Customer Relationship Directory</h3>
		<hr>

		<p class="h4 mb-4">Save Customer</p>

		<form action="/CustomerManagement/customers/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />
			
			<div class="form-inline">

				<label for="firstName">First Name</label>

			</div>

			<div class="form-inline">
				<input type="text" name="firstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="Enter FristName">

			</div>
			<div class="form-inline">

				<label for="firstName">Last Name</label>

			</div>

			<div class="form-inline">

				<input type="text" name="lastName" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Enter LastName">

			</div>
			<div class="form-inline">

				<label for="firstName">Email ID</label>

			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Enter Email Id">

			</div>

			<button type="submit" class="btn btn-info col-2">Submit</button>

		</form>

		<hr>
		<a href="/CustomerManagement/customers/list">Back to Customer Management List</a>

	</div>
</body>

</html>










