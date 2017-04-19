 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Brak praw</title>
</head>
<body>
	<div class="generic-container">
		<div class="authbar">
			<span>Uzytkowniku <strong>${loggedinuser}</strong> nie masz dostepu do tej strony</span> <span class="floatRight"><a href="<c:url value="/logout" />">Wyloguj</a></span>
		</div>
	</div>
</body>
</html>