<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dodawanie uzytkownika</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>
		
		
		<c:choose>
				<c:when test="${add}">
					
					<div class="well lead">Dodawanie nowego uzytkownika aplikacji</div>
	 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">Imie</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Nazwisko</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">Nick</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Haslo</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Typ konta</label>
					<div class="col-md-7">
						<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="userProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Dodaj" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Anuluj</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Dodaj" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Anuluj</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
					
					</c:when>
					<c:otherwise>
					
					

		<div class="well lead">Nowy klient</div>
	 	<form:form method="POST" modelAttribute="allclients" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">Imie</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Nazwisko</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
				<c:choose>
				<c:when test="${edit}">
					<label class="col-md-3 control-lable" for="id">Indentyfiaktor</label>
					</c:when>
					<c:otherwise>
					<label class="col-md-3 control-lable" for="id"></label>
					</c:otherwise>
					</c:choose>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="id" id="ssoId" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<!--<form:input type="text" path="id" id="ssoId" class="form-control input-sm" />-->
								<div class="has-error">
									<form:errors path="id" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="price">Cena</label>
					<div class="col-md-7">
						<form:input type="text" path="price" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="price" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="type">Typ biletu</label>
					<div class="col-md-7">
						<!--<form:input type="text" path="type" id="password" class="form-control input-sm" />-->
						<form:select type="text" id="password" path="type"  >
						 <form:option  value="ulgowy"> --ULGOWY--</form:option>
						  <form:option value="normalny"> --NORMALNY--</form:option>
						   <form:option value="dzienny"> --DZIENNY--</form:option>
						</form:select>
						
						<div class="has-error">
							<form:errors path="type" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
		
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Aktualizuj" class="btn btn-primary btn-sm"/> lub <a href="<c:url value='/list' />">Anuluj</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Dodaj klienta" class="btn btn-primary btn-sm"/> lub <a href="<c:url value='/list' />">Anuluj</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
		
		</c:otherwise>
					</c:choose>
	</div>
</body>
</html>