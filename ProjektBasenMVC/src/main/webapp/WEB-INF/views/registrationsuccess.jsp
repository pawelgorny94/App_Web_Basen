<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Klienci basenu</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
	<!-- 	<%@include file="authheader.jsp" %> -->
		
		<div class="alert alert-success lead">
	    	${success}
		</div>
		<c:choose>
		<c:when test="${edit}">
		<div class="well lead">Edytujesz cene biletu</div>
		<form:form method="POST" modelAttribute="tickets" class="form-horizontal">
		<div class="row">
				<div class="form-group col-md-7">
					<label class="col-md-3 control-lable" for="type" title="Bilet"><h5>Bilet  ${type}</h5></label>
					
						
					<div class="col-md-4">
					<form:input type="text" path="price" style="width: 300px" title="Cena" id="price" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="price" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
		
		
		
			
		<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Zapisz" class="btn btn-primary btn-sm"/> lub <a href="<c:url value='/list' />">Anuluj</a>
						</c:when>
						<c:otherwise>
							<!--   <a href="<c:url value='/list' />">Przejdz do strony glownej</a>-->
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			</form:form>
			
			</c:when>
		
		<c:otherwise>
					<label class="col-md-3 control-lable" ></label>
					</c:otherwise>
					
					</c:choose>
		
			
		<span style="float:right">
			Przejdz do <a href="<c:url value='/list' />"> panel glowny</a>
		</span>
	
	</div>
</body>

</html>