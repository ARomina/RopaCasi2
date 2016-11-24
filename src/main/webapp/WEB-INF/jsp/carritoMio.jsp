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
	<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
			} else {
				response.sendRedirect("/ropa/carrito");
			}
		}
	%>
	<header id="header">
		<jsp:include page="header.jsp"/>	
		<jsp:include page="combo.jsp"/>		
	
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
								<li><a href="/ropa/home" >INICIO</a></li>
								<li class="dropdown keep-open"><a href="#">PRODUCTOS<i class="fa fa-angle-down"></i></a>
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
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12 padding-right">    				
					<h1 class="title text-center">Mi Carrito</h1>    			    				    				
				</div>			 		
			</div> 	
	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Producto</td>
							<td class="description"></td>
							<td class="price">Precio</td>
							<td class="quantity">Cantidad</td>
							<td class="price"></td>
							<td class="price">Estado</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${serviciocarrito}" var="producto">
						<tr>
							<td class="cart_product">
								<img class="achica" src="images/productos/${producto.key.nombreimagen}" />
							</td>
							<td class="cart_description text-left">
								<h4>${producto.key.nombreProducto}</h4>
								<p>Color: ${producto.key.color} <br/> Talle: ${producto.key.talle}</p>
							</td>
							<td class="cart_price">
								<p>$ ${producto.key.precio}</p>
							</td>
							<td class="cart_price">
								<div class="cart_quantity_button">
								<p>${producto.value}</p>
								</div>
							</td>
							<td class="cart_total">
								<h4>El producto ha sido enviado</h4>
							</td>
							<td class="cart_price">
								<a href="" class="cart_price color2">Ver Ruta</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
				<a href="/ropa/home"><input type="button" name="volver" class="btn btn-primary pull-right" value="Volver"/></a>
				<br/><br/>	
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