<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dodawanie uzytkownika</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script src='https://www.google.com/recaptcha/api.js'></script>
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
						<span id="errorFirstName"></span>
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
						<div class="has-error2">
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
						
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="type">Typ biletu</label>
					<div class="col-md-7">
						
						<form:select type="text" id="sel" path="type" onchange="getVal(this);" >
						<!--<form:input type="text" path="type" id="password" class="form-control input-sm" />
						 <form:option  value="ulgowy"> --ULGOWY--</form:option>
						  <form:option value="normalny"> --NORMALNY--</form:option>-->
						   <c:forEach items="${tickets}" var="ticket">
                   <form:option value="${ticket.type}">${ticket.type}</form:option>                  
                </c:forEach>
						   
						</form:select>
						<c:forEach items="${tickets}" var="ticket">                   
                   <input type="hidden" value="${ticket.price}" id="${ticket.type}" />
                </c:forEach>
						
						
						
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
						    	<div class="g-recaptcha" data-callback="recaptchaCallback"  style="margin-bottom: 20px" data-sitekey="6LcmpyAUAAAAAAQS1YEQn79uq7rNe8fWTrvt1i77"></div>
							<input type="submit" id="submitButton" value="Dodaj klienta" class="btn btn-primary btn-sm" disabled/> lub <a href="<c:url value='/list' />">Anuluj</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
		
		</c:otherwise>
					</c:choose>
	</div>
</body>

<script type="text/javascript">

function recaptchaCallback() {
    $('#submitButton').removeAttr('disabled');
};



function getVal(item)
{
   var par= item.value;
   var element = document.getElementById(par);
   var element2 = document.getElementById("password");
   element2.value=element.value;
   
}

$(function(){
    $('#firstName').keyup(function(){
    	var myLength = $("#firstName").val().length;
		var myTextBox = $("#firstName").val();
		
		

		
		if($.isNumeric(myTextBox) || myLength<0 || myLength>20 ){
			
			$("div .has-error").empty();
			 $("div .has-error").append("Blad wprowadzania danych!");
			 $('#submitButton').attr("disabled", true);
			}
		else{
			$("div .has-error").empty();
			
			}
		 
    });
});


$(function(){
    $('#lastName').keyup(function(){
    	var myLength = $("#lastName").val().length;
		var myTextBox = $("#lastName").val();


		 var regex = new RegExp(/[^0-9]/g);
		    var containsNonNumeric = this.value.match(regex);
		    if (containsNonNumeric){
		       
		    }
		
		

		
		if($.isNumeric(myTextBox) || myLength<0 || myLength>20 ){
			
			$("div .has-error2").empty();
			 $("div .has-error2").append("Blad wprowadzania danych!");
			 $('#submitButton').attr("disabled", true);
			}
		else{
			$("div .has-error2").empty();
			
			}
		 
    });
});

$(document).ready(function() {
	$( ".generic-container" ).click(function() {

		var myLength = $("#lastName").val().length;
		var myTextBox = $("#lastName").val();

		if($.isNumeric(myTextBox) || myLength<0 || myLength>20 ){
			
			$("div .has-error2").empty();
			 $("div .has-error2").append("Blad wprowadzania danych!");
			 $('#submitButton').attr("disabled", true);
			}
		else{
			$("div .has-error2").empty();
			
			}
		 
			
		
		});
});

$(document).ready(function() {
	$( ".generic-container" ).click(function() {

		var myLength = $("#firstName").val().length;
		var myTextBox = $("#firstName").val();

		if($.isNumeric(myTextBox) || myLength<0 || myLength>20 ){
			
			$("div .has-error").empty();
			 $("div .has-error").append("Blad wprowadzania danych!");
			 $('#submitButton').attr("disabled", true);
			}
		else{
			$("div .has-error").empty();
			
			}
		 
			
		
		});
});

</script>

</html>