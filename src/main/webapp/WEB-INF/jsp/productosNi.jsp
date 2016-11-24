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
				<h1 class="title text-center">Niños</h1>
					<div class="col-sm-3">
					<div class="left-sidebar">
						<div class="panel-group category-products" id="accordian">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="">Remeras</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="">Pantalones</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="">Conjuntos</a></h4>
								</div>
							</div>	
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="">Zapatos</a></h4>
								</div>
							</div>							
						</div>
					</div>
				</div>
				<div class="col-sm-9">
					<div class="features_items">
						<c:forEach items="${servicioproducto}" var="producto">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<h1>${producto.nombreProducto}</h1>										
											<img src="images/productos/${producto.nombreimagen}" alt=""/>
											<h3>$ ${producto.precio}</h3>
											<a href="/ropa/productoDetalle?id=${producto.id}" class="btn btn-default add-to-cart"><i class="fa fa-arrow-right"></i>Ver Detalles</a>
										</div>
										<div class="product-overlay" data-interval="false">
											<div class="overlay-content">
											<img src="images/productos/${producto.nombreimagen}" alt=""/>																					
											<h2>$ ${producto.precio}</h2>
											<a href="/ropa/productoDetalle?id=${producto.id}" class="btn btn-default add-to-cart"><i class="fa fa-arrow-right"></i>Ver Detalles</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</div>		
						<ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>					
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