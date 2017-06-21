<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Chat</title>
</head>
<body>
	Hello ${name}!
	<br />
	<form action="/send-message" method="POST">
		<input type="text" name="message" /> <input type="submit" value="Send" />
	</form>
	
	<c:forEach items="${messages}" var="message">
		${message.user}: ${message.message} <br/>
	</c:forEach>
</body>
</html>