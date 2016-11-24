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
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
</head>
<body>
	<header id="header">
		<jsp:include page="header.jsp"/>	
		<jsp:include page="comboRegistro.jsp"/>	
	
		<div class="header-bottom responsive">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="/ropa">INICIO</a></li>
								<li class="dropdown"><a href="">PRODUCTOS<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="/ropa/productosMu">Mujeres</a></li>
										<li><a href="/ropa/productosHo">Hombres</a></li> 
										<li><a href="/ropa/productosNi">Niños</a></li> 
                                    </ul>
                                </li> 								
								<li><a href="/ropa/registro">REGISTRO</a></li> 
								<li><a href="/ropa/contacto" class="active">CONTACTO</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</header>
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12 padding-right">    				
					<h1 class="title text-center">Contacto </h1>    			    				    				
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-8">
	    			<div class="contact-form">
				    	<form:form action="/ropa/contactoMensajeExito" modelAttribute="mensaje" id="main-contact-form" class="contact-form row" name="contact-form" method="POST">
				            <div class="form-group col-md-6">
				                <form:input type="text" path="nombreMail" name="name" class="form-control" required="required" placeholder="Nombre" />
				                <form:errors path="nombreMail" class="color2"/>
				            </div>
				            <div class="form-group col-md-6">
				                <form:input type="email" path="emailMail" name="email" class="form-control" required="required" placeholder="Email" />
				                <form:errors path="emailMail" class="color2"/>
				            </div>
				            <div class="form-group col-md-12">
				                <form:input type="text" path="asuntoMail" name="subject" class="form-control" required="required" placeholder="Asunto" />
				                <form:errors path="asuntoMail" class="color2"/>
				            </div>
				            <div class="form-group col-md-12">
				                <form:textarea path="textoMail" name="message" id="message" required="required" class="form-control" rows="8" placeholder="Tu mensaje" />
				                <form:errors path="textoMail" class="color2"/>
				            </div>                        
				            <div class="form-group col-md-12">
				                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Enviar"/>
				            </div>
				        </form:form>
	    			</div>
	    		</div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Información de Contacto</h2>
	    				<address>
	    					<p>ROPA'S</p>
							<p>Florencio Varela 1903, B1754JEC San Justo, Buenos Aires</p>
							<p>Argentina</p>
							<p>Teléfono 4444 3333</p>
							<p>Email: info@ropas.com</p>
	    				</address>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Redes Sociales</h2>
							<ul>
								<li><a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a></li>
								<li><a href="https://twitter.com" target="_blank"><i class="fa fa-twitter"></i></a></li>
								<li><a href="https://linkedin.com" target="_blank"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="https://plus.google.com" target="_blank"><i class="fa fa-google-plus"></i></a></li>
							</ul>
	    				</div>
	    			</div>
    			</div>    			
	    	</div>  
    	</div>	
    </div>
	
<jsp:include page="footer.jsp"/>
	
  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>