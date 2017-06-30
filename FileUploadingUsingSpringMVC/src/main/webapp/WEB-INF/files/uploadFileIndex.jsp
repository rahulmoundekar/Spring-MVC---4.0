
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

 <body>
<form:form modelAttribute="uploadFile"  commandName="uploadFile" name="frm" method="post" action="upload.htm"
	enctype="multipart/form-data" >
	
	<fieldset><legend>Upload File</legend>
		<div class="form-group">
		
	<form:label class="col-md-4 control-label" for="fileData" path="">File</form:label>

	<form:input path="fileName" name="fileName" class="form-control input-md" />
	<form:input path="fileup" name="fileup" id="image" type="file" class="form-control input-md"/>
	<form:input path="fileup" name="fileup" id="image" type="file" class="form-control input-md"/>
	<%-- <form:input path="fileName" name="file" id="image" type="file" class="form-control input-md"/>
	<form:input path="fileName" name="file" id="image" type="file" class="form-control input-md"/>
	<form:input path="fileName" name="file" id="image" type="file" class="form-control input-md"/> --%>
	
	<input type="submit" value="Upload" class="btn btn-primary"/>
	</div>
		
		
	</fieldset>
</form:form>
</body>