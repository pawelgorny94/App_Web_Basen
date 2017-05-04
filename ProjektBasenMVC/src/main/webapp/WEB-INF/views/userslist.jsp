<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



<html >


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Wejscie na basen</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
	
	
	<script>
	
	//function wypis() {
	   
		//var s= document.getElementById('wejscie').style["visibility"] = "hidden";
		//var s= document.getElementById('wejscie').
	//};

	$(function() {

		
			
		
		
    $('#wej').click(function(){  //Adds click event listener  

    	if ($('#wejscie').css("visibility") == "hidden") {
    		$('#wejscie').css("visibility", "visible");
        } else {
        	$('#wejscie').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});


	$(function() {

		
		
		
		
		$('#sprz').click(function(){  //Adds click event listener  

	    	if ($('#sprzedaz').css("visibility") == "hidden") {
	    		$('#sprzedaz').css("visibility", "visible");
	        } else {
	        	$('#sprzedaz').toggle('slow');
	        }

	        
	    	 //$('#wejscie').css("visibility", "visible");
	       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
	       

	        });
	});

	


$(function() {

	
	
	
	

	$('#wyj').click(function(){  //Adds click event listener  

    	if ($('#wyjscie').css("visibility") == "hidden") {
    		$('#wyjscie').css("visibility", "visible");
        } else {
        	$('#wyjscie').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});
$(function() {

	
	
	
	

	$('#sta').click(function(){  //Adds click event listener  

    	if ($('#stan').css("visibility") == "hidden") {
    		$('#stan').css("visibility", "visible");
        } else {
        	$('#stan').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});

$(function() {

	
	
	
	

	$('#prac').click(function(){  //Adds click event listener  

    	if ($('#pracownicy').css("visibility") == "hidden") {
    		$('#pracownicy').css("visibility", "visible");
        } else {
        	$('#pracownicy').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});


function getSummary(id)
{
   $.ajax({

     type: "GET",
     url: 'http://localhost:8081/SpringMVCHibernateWithSpringSecurityExample/list',
     data: "id=" + id, // appears as $_GET['id'] @ your backend side
     success: function(data) {
           // data is ur summary
          $('#wejscie').html(data);
     }

   });

}



$(function() {

	
	
	
	

	$('#wpusc').click(function(){  //Adds click event listener  

    	if ($('#wejscie').css("visibility") == "hidden") {
    		$('#wejscie').css("visibility", "visible");
        } else {
        	$('#wejscie').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});

$(function() {

	
	
	
	

	$('#ustal').click(function(){  //Adds click event listener  

    	if ($('#ustalaniecennika').css("visibility") == "hidden") {
    		$('#ustalaniecennika').css("visibility", "visible");
        } else {
        	$('#ustalaniecennika').toggle('slow');
        }

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});

$(function() {
var test;
$("#start").on("click", function (event) {
    var pageVisisted = new Date();

    test = setInterval(function () {
        var timeOnSite = new Date() - pageVisisted;
        var secondsTotal = timeOnSite / 1000;
        var minutes = Math.floor(secondsTotal / 60) % 3600;
        var seconds = Math.floor(secondsTotal) % 60;

        document.getElementById('counter').innerHTML = minutes + ":" + seconds;
    }, 1000);
});



$("#stop").on("click", function (event) {
    //double check onclick is working
   // alert('test');
   // $( "#tabwyj").
   $('#tabwyj tr').each(function() {
	   var id = $(this).find('td.hidden:first');
	 // id.visibility="visible";
	
    //if ($(this).find('td:visible').length){
    	//alert(id);
       //  $(this).css("visibility", "hidden");
   // }
});
  
    clearInterval(test);
});

});

$(function() {

	
	
	
	

	$('#start').click(function(){  //Adds click event listener  

    	
		$('#wyjscie').css("visibility", "hidden");
        	$('#wyjscie').css("visibility", "visible");

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});



$(function() {

	
	
	
	

	$('#stop').click(function(){  //Adds click event listener  

		var bla = $('#idhidden').val();
		$('#wyjscie').css("visibility", "hidden");
        	//$('#kasa').css("visibility", "visible");
        	$('#kasa').show();
        	 $('#msg').val(bla);

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});

$(function() {

	
	
	
	

	$('#rozlicz').click(function(){  //Adds click event listener  

		var bla = $('#msg').val();
		var bla2 = $('#msg2').val();
		var sum=0;
		sum += parseInt($('#msg').val()); 
		sum += parseInt($('#msg2').val()); 
		
        	 $('#podsumowanie').val(sum+" PLN");

        
    	 //$('#wejscie').css("visibility", "visible");
       // $('#wejscie').toggle('slow'); // Toggles visibility.  Use the 'slow' parameter to add a nice effect.
       

        });
});

$(function(){
	$('#clkas').click(function(){
		$('#kasa').css("visibility", "hidden");
		});
	});


</script>

</head>

<body>




<div class="generic-container" style="width:1300px;height:580px">
		<%@include file="authheader.jsp" %>	
		
	
		
		<table style="position:fixed; "cellspacing="40" cellpadding="50" >
<tr>
<td>
<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
<input type="button" id="prac" class="btn btn-primary btn-lg" style="width: 120px;height: 120px;margin: 6px;" value="Pracownicy">
</sec:authorize>
<sec:authorize access="hasRole('USER') ">
<input type="button"  title="Niedostepne w tym trybie" class="btn btn-primary disabled" style="width: 120px;height: 120px;margin: 6px;" value="Pracownicy">
</sec:authorize>

</td>

<td><input type="button" class="btn btn-primary btn-lg" id="sprz" style="width: 120px;height: 120px;margin: 6px;"  value="Sprzedaz"></td>
</tr>
<tr>
<td><input type="button" class="btn btn-primary btn-lg" onclick="wypis()" id="wej" style="width: 120px;height: 120px;margin: 6px;"  value="Wejscie"></td>
<td><input type="button" class="btn btn-primary btn-lg" id="wyj" style="width: 120px;height: 120px;margin: 6px;"  value="Wyjscie"></td>
</tr>
<tr>
<td><input type="button" class="btn btn-primary btn-lg" id="sta" style="width: 120px;height: 120px;margin: 6px;"  value="Stan"></td>
<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
<td><input type="button" class="btn btn-primary btn-lg" id="ustal" style="width: 120px;height: 120px;margin: 6px;"  value="Cennik"></td>
</sec:authorize>
<sec:authorize access="hasRole('USER') ">
<td><input type="button" title="Niedostepne w tym trybie" class="btn btn-primary disabled" id="ustal" style="width: 120px;height: 120px;margin: 6px;"  value="Cennik"></td>
</sec:authorize>
</tr>
<tr>
<td><input type="button"  class="btn btn-primary btn-lg" style="width: 120px;height: 120px;margin: 6px;"  value="Inne"></td>
<td><a href="<c:url value="/logout" />"><input type="button"   class="btn btn-primary btn-lg" style="width: 120px;height: 120px;margin: 6px;"  value="Wyloguj"></a></td>
</tr>




</table>
		
		
		
		
		<div  id="wejscie" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility: hidden;margin-left: 300px;">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Wejscie na basen </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Imie</th>
				        <th>Nazwisko</th>
				        <th>Indentyfikator</th>
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${allclients}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.id}</td>
						<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
						<td><a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-success custom-width">Edycja</a></td>
							<td><a href="<c:url  value='/delete-user-${user.id}' />"  id="wpusc" class="btn btn-danger custom-width">Usun</a></td>
							<td><button   id="start" class="btn btn-info custom-width">Wpusc</button></td>
				        </sec:authorize>
					   
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	    	
	    		
	    	
	    	
		</div>
		
		<div id="sprzedaz" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility:hidden;margin-left: 300px;margin-bottom: 500px;z-index: 50px; ">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Sprzedaz biletu </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Imie</th>
				        <th>Nazwisko</th>
				        
				         <th>Bilet</th>
				          
				        
				        
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${allclients}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						
						<td>${user.type}</td>
						
						 <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-success custom-width">Edycja</a></td>
				        </sec:authorize>
						
						
					   
					</tr>
				</c:forEach>
				
				
	    		</tbody>
	    	</table>
	    	 <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
	    	<div style="width:200px" class="well">
		 		<a href="<c:url value='/newuser' />">Nowy klient</a>
		 	</div>
		 	</sec:authorize>
		</div>
		
		
		<div id="wyjscie" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility:hidden;margin-left: 300px;margin-bottom: 500px;z-index: 50px; ">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Wyjscie z basenu </span></div>
			<table id="tabwyj" class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Imie</th>
				        <th>Nazwisko</th>
				        <th style="">Indentyfiaktor</th>
				        <th style="">Cena</th>
				        <th style="">Czas</th>
				          
				                
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${allclients}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.id}</td>
						<td >${user.price}</td>
						<td><span id="counter"></span></td>
						 <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-success custom-width">Edycja</a></td>
				        </sec:authorize>
						<td><a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-danger custom-width">Wypusc</a></td>
						
					   <td><button  id="stop" class="btn btn-warning custom-width">Rozlicz</button></td>
					  <td><input id="idhidden" type="hidden" value="${user.price}"/></td>
					   
					</tr>
				</c:forEach>
				
				
	    		</tbody>
	    	</table>
		</div>
                
                <div id="stan" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility:hidden;margin-left: 300px;margin-bottom: 500px;z-index: 50px; ">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Stan klientów na basenie </span></div>
			<table id="tabstan" class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Imie</th>
				        <th>Nazwisko</th>
				        <th style="">Indentyfiaktor</th>
				          
				                
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${allclients}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.id}</td>
					</tr>
				</c:forEach>
				
				
	    		</tbody>
	    	</table>
		</div>



		
		<div id="ustalaniecennika" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility:hidden;margin-left: 300px;margin-bottom: 500px;z-index: 50px; ">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Ustalanie cennika </span></div>
			<table id="tabwyj" class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Rodzaj</th>
				        <th>Cena</th>
				       
				          
				                
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${tickets}" var="user">
				
					<tr>
						<td>${user.type}</td>
						<td> ${user.price} </td>						
						
						  <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							
							<td><a href="<c:url value='/price-ticket-${user.type}' />" class="btn btn-danger custom-width">Ustal</a></td>
				        </sec:authorize>
					   
					</tr>
					
				</c:forEach>
				
				
	    		</tbody>
	    	</table>
		</div>
		
		<div id="pracownicy" class="panel panel-default"  style="position:fixed; width:900px;float:right;visibility:hidden;margin-left: 300px;margin-bottom: 500px;z-index: 50px; ">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Pracownicy obslugi recepcji basenu</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Imie</th>
				        <th>Nazwisko</th>
				        <th style="">E-mail</th>
				       
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						
						   <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							
							<td><a href="<c:url value='/delete-userp-${user.ssoId}' />" class="btn btn-danger custom-width">Usun</a></td>
				        </sec:authorize>
						
						
					   
					</tr>
				</c:forEach>
				<tr>
				<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/newuserp' />" class="btn btn-success custom-width">Dodaj </a></td>
							
				        </sec:authorize>
				
				</tr>
				
	    		</tbody>
	    	</table>
		</div>
		
		<div id="kasa" class="panel panel-primary"  style="position:fixed; width:900px;float:right;display:none; margin-top:330px;margin-left: 300px;margin-bottom: 200px;z-index: 50px;">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Rozliczenie</span>
		  	
		  	 <span id="clkas" class="pull-right" style=" background:rgba(0, 0, 0, 0.15);
    display: inline-block;padding: 6px 12px;border-radius: 4px;cursor: pointer;" data-effect="slideUp"><i class="fa fa-times"></i></span>
		  	</div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Opcje</th>
				        <th>Koszty</th>
				        <th style="">Podsumowanie</th>
				       
				        
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				
					<tr>
						
						
						   <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							
							<td><a id="rozlicz" href="#" class="btn btn-primary custom-width">Rozlicz</a></td>
				        </sec:authorize>
						
						<td>
						<div class="input-group">
    <span class="input-group-addon">Koszt podstawowy</span>
    
    <input id="msg" type="text" class="form-control" name="msg"  placeholder="kasa nieaktywna">
  </div>
						
						</td>
					   
					   <td><label>DO ZAPLATY:</label></td>
					   
					   
					</tr>
				
				<tr>
				<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/invoke' />" class="btn btn-danger custom-width">Faktura </a></td>
							
				        </sec:authorize>
				        
				        
						<td>
						<div class="input-group">
    <span class="input-group-addon">Koszty dodatkowe</span>
    <input id="msg2" type="text" class="form-control" name="msg" placeholder="kasa nieaktywna">
  </div>
						
						</td>
						<td><input type="text" style="color: red;border: none;" id="podsumowanie"/> </td>
						
				
				</tr>
				
				
	    		</tbody>
	    	</table>
		</div>
		
		
   	</div>



</body>
</html>