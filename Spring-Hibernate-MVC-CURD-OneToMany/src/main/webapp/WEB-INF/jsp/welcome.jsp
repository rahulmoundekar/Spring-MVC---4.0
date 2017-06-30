<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Spring CURD</title>
</head>

<body>
	<form:form modelAttribute="studentForm" method="post" action="insert"
		class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Student Details</legend>

			<form:input id="id" path="id" name="id" type="hidden"
						placeholder="" class="form-control input-md" required="" />

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Enter Name</label>
				<div class="col-md-4">
					<form:input id="name" path="name" name="name" type="text"
						placeholder="" class="form-control input-md" required="" />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="mobile">Enter
					Mobile</label>
				<div class="col-md-4">
					<form:input id="mobile" path="mobile" name="mobile" type="text"
						placeholder="" class="form-control input-md" required="" />

				</div>
			</div>
			<c:forEach items="${studentForm.addresses}" var="address"
				varStatus="row">
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="aid"></label>
					<div class="col-md-4">
						<form:input path="addresses[${row.index}].aid" id="aid" name="aid"
							type="hidden" placeholder="" class="form-control input-md"
							required="" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Enter
						Address</label>
					<div class="col-md-4">
						<form:input id="address" path="addresses[${row.index}].address"
							name="address" type="text" placeholder=""
							class="form-control input-md" required="" />

					</div>
				</div>
			</c:forEach>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<button id="" name="" class="btn btn-primary">Register</button>
				</div>
			</div>

		</fieldset>
	</form:form>
	<hr>
	<div class="container">
		<h2>Student Info</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Address</th>
					<th>address</th>
					<th>edit</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${studentFormList}" var="st">
					<tr>
						<td>${st.id}</td>
						<td>${st.name}</td>
						<td>${st.mobile}</td>

						<c:forEach items="${st.addresses}" var="addr">
							<td>${addr.address}</td>
						</c:forEach>
						<td><a href="edit?id=${st.id}">edit</a></td>
						<td><a href="delete?id=${st.id}">delete</a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>
