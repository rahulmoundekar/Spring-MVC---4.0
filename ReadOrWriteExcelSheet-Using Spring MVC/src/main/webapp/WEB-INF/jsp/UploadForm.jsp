<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC File Upload Demo</title>
</head>
<body>
	<center>
		<h1>Spring MVC File Upload Demo</h1>

		<form:form modelAttribute="uploadItem" name="frm" method="post"
			enctype="multipart/form-data" action="uploadFile">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					 <input type="file"
						name="fileUpload" />
				</p>
				<p id="buttons">
					<input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form:form>
		<a href="retrive">Write Excel from Db</a>

	</center>
</body>
</html>