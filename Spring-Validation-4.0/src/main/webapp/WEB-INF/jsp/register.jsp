<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page</title>
</head>
<body>

	<form:form commandName="studentForm" id="studentForm"
		name="studentForm">

		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
				 <form:errors path="name" class="formError"/>
			</tr>
			<tr>
				<td>City :</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Register"
					onclick="addstudent()">
			    </td>
			</tr>
		</table>
	</form:form>

	<script>
		function addstudent()
		{
		studentForm.action="addStudent.html";
		studentForm.submit();
		
		}
	</script>

</body>
</html>