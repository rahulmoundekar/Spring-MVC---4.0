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
<title>Insert title here</title>
</head>

<body>

	<form:form modelAttribute="studentForm" method="post" action="insert">

		ID<form:input path="id" readonly="true" />
		<br>
		<br>
		First Name<form:input path="name" type="text" />
		<form:errors path="name" />
		<br>
		<br>
		Mobile<form:input path="mobile" type="text" />
		<form:errors path="mobile" />
		<br>
		<br>

		<c:forEach items="${studentForm.addresses}" var="address"
			varStatus="row">

			<form:input type="hidden" path="addresses[${row.index}].aid"
				readonly="true" />
			
		Address:<form:input path="addresses[${row.index}].address" type="text" />
			<form:errors path="addresses" />

		</c:forEach>

		<br>
		<form:input path="" type="submit" value="submit" />

	</form:form>


	<table>
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

</body>
</html>
