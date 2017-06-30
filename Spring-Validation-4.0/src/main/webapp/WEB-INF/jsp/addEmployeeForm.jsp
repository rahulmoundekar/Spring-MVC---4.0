<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<head>
<head>
<title>Registration Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


</head>
</head>

<div class="box border">
    <div class="box-title">
        <h4><i class="fa fa-bars"></i>Employee Information</h4>
    </div>
    <div class="box-body">
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <c:if test="${not empty message1}">
            <div class="alert alert-danger">${message1}</div>
        </c:if>
        <c:if test="${not empty message2}">
            <div class="alert alert-danger">${message2}</div>
        </c:if>
        <c:if test="${not empty message3}">
            <div class="alert alert-danger">${message3}</div>
        </c:if>
        <font class="error-message">*</font><i>All Fields Mandatory</i><br><br>

        <form:form id="employeeForm" name="role" method="post" commandName="employeeForm" class="form-horizontal">
          
             <div class="form-group">
                    <form:label for="employeeName" path="employeeName" class="col-sm-2 control-label">Employee Name</form:label>
                    <div class="col-sm-6">
                        <form:input path="employeeName" class="form-control" id="employeeName" />
                        <form:errors class="label label-danger" path="employeeName"/>
                    </div>
             </div>
             
                <div class="form-group">
                    <form:label for="employeeEmail" path="employeeEmail" class="col-sm-2 control-label">Email</form:label>
                    <div class="col-sm-6">
                        <form:input path="employeeEmail" class="form-control" id="employeeEmail"   placeholder="Email"/>
                        <form:errors class="label label-danger" path="employeeEmail"/>
                    </div>
                </div>
                
                 <div class="form-group">
                  <form:label for="employeeEmail" path="employeeEmail" class="col-sm-2 control-label"></form:label>
                     <input type="button" value="Register" onclick="addstudent();"  class="btn btn-primary btn-lg">
			    </div>
            
        </form:form>
    </div>
</div>


<script>
		function addstudent()
		{
			employeeForm.action="saveEmployee.htm";
			employeeForm.submit();
		
		}
</script>


<html>



