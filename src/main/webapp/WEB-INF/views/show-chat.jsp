<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Chat</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h3>Hello ${name}!</h3> <br />
		<form:form action="/send-message" method="POST" commandName="message">
			<form:input path="message" type="text" class="form-control" required="required"/> <input
				type="submit" value="Send" />
				<form:errors path="message" cssClass="text-warning"/>
		</form:form>
	</div>

	<div class="container">
		<c:forEach items="${messages}" var="message">
		${message.user}: ${message.message} <br />
		</c:forEach>
	</div>

	<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>