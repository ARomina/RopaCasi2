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
	<link rel="stylesheet" href="css/sortable-theme-bootstrap.css" />
	<script src="js/sortable.min.js"></script>
	<script src="js/jquery-1.10.2.js"></script>	
</head>

<body>
	<header id="header">
		<jsp:include page="header.jsp"/>	
		<jsp:include page="combo.jsp"/>	
	
		<div class="header-bottom">
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
								<li><a href="/ropa/home">INICIO</a></li>
								<li class="dropdown"><a href="">PRODUCTOS<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="/ropa/productosMu">Mujeres</a></li>
										<li><a href="/ropa/productosHo">Hombres</a></li> 
										<li><a href="/ropa/productosNi">Niños</a></li> 
                                    </ul>
                                </li> 								
								<li><a href="/ropa/registro">REGISTRO</a></li> 
								<li><a href="/ropa/contacto">CONTACTO</a></li>
								<li><a href="/ropa/administrar" class="active">ADMINISTRACION</a></li>
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
	    		<h1 class="title text-center">BAJA O MODIFICACIÓN DE PRODUCTO</h1>     			   			
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-12">
	    			<div class="contact-form">
	    				<form:form action="" modelAttribute="producto" id="main-contact-form" class="contact-form row" role="form" method="POST" name="bajaProd">	
							<div class="col-md-12 container table-responsive">
								<table class="table table-bordered sortable-theme-bootstrap col-md-12" data-sortable>
								<thead>	
									<tr>
										<th>CODIGO</th>
										<th>IMAGEN</th>
										<th>CATEGORIA</th>
										<th data-sortable-type="alpha" data-sorted="true" data-sorted-direction="descending">NOMBRE</th>
										<th>DESCRIPCIÓN</th>
										<th>COLOR</th>
										<th>TALLE</th>
										<th>PRECIO</th>	
										<th>NOVEDAD</th>									
										<th class="text-center">ACCIÓN</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productos}" var="producto">
									<tr>
										<td>${producto.id}</td>
										<td><img src="images/productos/${producto.nombreimagen}" width="50px" height="50px" alt=""/></td>
										<td>${producto.descripcion}</td>
										<td>${producto.categoria}</td>
										<td>${producto.nombreProducto}</td>
										<td>${producto.color}</td>	
										<td>${producto.talle}</td>
										<td>${producto.precio}</td>	
										<td>${producto.novedad}</td>														
										<td>
											<a href="/ropa/modifProConfirma?id=${producto.id}" class="pull-left color2">Modificar</a><br/>	
										    <a href="/ropa/bajaProConfirma?id=${producto.id}" class="pull-right color2">Eliminar</a></td>											
										</tr>
									</c:forEach>
								</tbody>
								</table>							
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