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
	    		<h1 class="title text-center">${info}</h1>     			   			
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-4">
	    			<div class="contact-form">
		    	<form:form action="/ropa/altaStockBusca" modelAttribute="producto cantidad" role="form"  method="POST" name="altaProd">
		            <div class="form-group col-xs-8 col-md-8 col-sm-8">
		                <input type="number" min="1" max="9999" name="id" class="form-control" placeholder="Código de Producto" required="required"/>

		            </div>	
		            <div class="form-group col-xs-4 col-md-4 col-sm-4">
		                <input type="submit" name="stock" class="btn btn-primary" value="Buscar">
		            </div>																										
		        </form:form>
	    			</div>
	    		</div>			    				
	    	</div>  
    	</div>	<br/>
		 <div id="contact-page" class="container table-responsive">
						<table class="table table-bordered sortable-theme-bootstrap" data-sortable>
				<thead>
					<tr>
						<th>CODIGO</th>
						<th>IMAGEN</th>
						<th>CATEGORIA</th>
						<th data-sortable-type="alpha" data-sorted="true" data-sorted-direction="descending">NOMBRE</th>
						<th>COLOR</th>
						<th>TALLE</th>
						<th>PRECIO</th>
						<th>NOVEDAD</th>
						<th>CANTIDAD</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${producto.id}</td>
						<td><img src="images/productos/${producto.nombreimagen}" width="50px" height="50px" alt=""/></td>
						<td>${producto.categoria}</td>
						<td>${producto.nombreProducto}</td>
						<td>${producto.color}</td>
						<td>${producto.talle}</td>
						<td>${producto.precio}</td>
						<td>${producto.novedad}</td>
						<td>${cantidad}</td>
					</tr>
				</tbody>
			</table>
			<a href="/ropa/altaStockConfirma?id=${producto.id}"><input type="button" name="confirmar" class="btn btn-primary pull-right" value="Confirmar"/></a>
		</div>
    	<div class="bg">   	
			<div class="row">
				<div class="form-group col-md-3 col-sm-3">
				</div>
				<div class="form-group col-md-6 col-sm-6">
				<a href="/ropa/verStock"><input type="button" name="listaU" class="btn btn-primary pull-left col-xs-5 col-md-5 col-sm-5" value="Productos en Stock"/></a>
				<a href="/ropa/agregarStock"><input type="button" name="listaU" class="btn btn-primary pull-right col-xs-5 col-md-5 col-sm-5" value="Agregar Stock"/></a>						
				</div>	
				<div class="form-group col-md-3 col-sm-3">
				</div>			
				<br/>
				<a href="/ropa/administrar"><input type="button" name="volver" class="btn btn-primary pull-right" value="Volver"/></a>
				<br/><br/>
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