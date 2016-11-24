<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Ropa's - Tu tienda online</title>
	<link rel="shortcut icon" href="images/favicon.png">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<script src="js/jquery-1.10.2.js"></script>	

</head>
<body>
	<header id="header">
		<jsp:include page="header.jsp"/>	
		<jsp:include page="comboRegistro.jsp"/>	

	</header>
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12 padding-right">      			   			
					<h1 class="title text-center">Registro</h1>    			    				    				
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-12">
	    			<div class="formulario">
						<form:form action="/ropa/regUsuConfirma" modelAttribute="usuario" role="form" method="POST" name="form"  commandName="usuario">
							<div class="form-group col-md-12">			
								<form:input path="nombreYapellido" type="text" name="nombreYapellido" class="form-control" placeholder="Nombre y Apellido"/>
								<form:errors path="nombreYapellido" class="color2"/>
							</div>
							<div class="form-group col-md-6">
								<form:input path="dni" type="text" name="dni"  class="form-control" placeholder="DNI"/>	
								<form:errors path="dni" class="color2"/>							
							</div>
							<div class="form-group col-md-6">
								<form:input path="fechaNacimiento" type="text" name="fechaNac" class="form-control" placeholder="Fecha de nacimiento"/>
								<form:errors path="fechaNacimiento" class="color2"/>
							</div>
							<div class="form-group col-md-6">		
								<form:input path="domicilio" type="text" name="domicilio"  class="form-control" placeholder="Domicilio"/>
								<form:errors path="domicilio" class="color2"/>
							</div>
							<div class="form-group col-md-6">
								<form:input path="telefono" type="text" name="tel" class="form-control" placeholder="Teléfono"/>
								<form:errors path="telefono" class="color2"/>
							</div>
							<div class="form-group col-md-12">
								<form:input path="eMail" type="email" name="email" class="form-control" placeholder="E-mail"/>
								<form:errors path="eMail" class="color2"/>
							</div>
							<div class="form-group col-md-6">
								<form:input path="clave" type="password" name="clave" id="clave" class="form-control" placeholder="Contraseña"/>
								<form:errors path="clave" class="color2"/>	
							</div>
							<div class="form-group col-md-6">
								<form:input path="clave2" type="password" name="clave2" id="clave2" class="form-control" placeholder="Confirmar Contraseña"/>
								<form:errors path="clave2" class="color2"/>
							</div>
							<div class="form-group col-md-12">
								<div class="form-group col-md-6">
									<input type="reset" class="btn btn-primary pull-left"/>						
								</div>
								<div class="form-group col-md-6">
									<input type="submit" id= "boton" name="submit" class="btn btn-primary pull-right" value="Registrar"/>
								</div>
							</div>							
						</form:form>
	    			</div>
	    		</div>  			
	    	</div>  
    	</div>	
    </div>
	
<jsp:include page="footer.jsp"/>	

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/main.js"></script>
	<script src="js/html5shiv.js"></script>
	
</body>
</html>