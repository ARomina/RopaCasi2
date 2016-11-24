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
								<li class="dropdown keep-open"><a href="#"  class="active">PRODUCTOS<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="/ropa/productosMu">Mujeres</a></li>
										<li><a href="/ropa/productosHo">Hombres</a></li> 
										<li><a href="/ropa/productosNi">Niños</a></li> 
                                    </ul>
                                </li> 								
								<li><a href="/ropa/registro">REGISTRO</a></li> 
								<li><a href="/ropa/contacto">CONTACTO</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<section>
		<div class="container">
			<div class="row">				
				<div class="col-sm-12 padding-right">
				<h1 class="title text-center">${producto.categoria}</h1>
					<div class="col-sm-7 col-md-7 text-center">
							<img src="images/productos/${producto.nombreimagen}" class="detallefoto" alt="" />
					</div>
					<div class="col-sm-5 col-md-5">
						<div class="features_items">
								<div class="product-information text-center">				
									<h3><b>${producto.nombreProducto}</b></h3>
									<h4>${producto.descripcion}</h4>
									<p>Código: 108-${producto.id}-0</p>
									<h5>Color: <b>${producto.color}</b></h5>
									<h5>Talle: <b>${producto.talle}</b></h5>
									<h4 class="color2">$ ${producto.precio}</h4>
									<p>Disponibilidad: <b>${disponible}</b></p>
									<p><b>Novedad: </b>${producto.novedad}</p>
									<br/>
									  <a href="/ropa/agregarAListaDeseos?id=${producto.id}" class="color2"><i class="fa fa-star-o"></i> A Lista de Deseos</a>
									<form:form action="/ropa/agregarAlCarrito" modelAttribute="producto" role="form"  method="POST" name="altaCarrito">
									<p><b>Cantidad: </b><input type="number" min="1" max="99" value="1" id="unidades" name="unidades"/></p>
                                     <input type="hidden" value="${producto.id}" id="id" name="id"/>
                                     
								<!--  	<%if (session.getAttribute("user") != null) {
									String name = (String) session.getAttribute("user");%>
									<input type="hidden" value="<%out.print(name);%>" id="usuario" name="usuario"/><%};%>    -->                                 
  
     								<button type="submit" class="btn btn-default cart">
									<i class="fa fa-shopping-cart"></i>Agregar al Carrito
									</button>                                
                                    </form:form>									


									<br/>									
								</div>
							</div>							
						</div>
				</div>
			</div>
		</div>
	</section>
	
<jsp:include page="footer.jsp"/>	

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/main.js"></script>
	<script src="js/html5shiv.js"></script>
	
</body>
</html>