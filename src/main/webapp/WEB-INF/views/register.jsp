<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">

		<form:form action="/register" method="POST" commandName="user">
			username: <form:input path="username" type="text" minlength="4"
				class="form-control" required="required" />
			email: <form:input path="email" type="email" class="form-control"
				required="required" />
			password: <form:input path="password" type="password"
				class="form-control" required="required" minlength="6" />
			<br />
			<input type="submit" value="Register" />
		</form:form>

		<br />Already registered? <a href="/login">Login</a>
	</div>


	<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>