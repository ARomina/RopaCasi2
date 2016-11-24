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
<%HttpSession sesion=request.getSession();%>
	<header id="header">
		<jsp:include page="header.jsp"/>	
		<jsp:include page="comboRegistro.jsp"/>		
	
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
								<li><a href="/ropa/administrar"  class="active">ADMINISTRACION</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
				
	</header>
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row ">  		
	    		<div class="col-sm-12 col-xs-12 padding-right"> 
					<h1 class="title text-center">ADMINISTRACION</h1>     			   			
					<h2 class="title text-center col-xs-4 col-sm-4">Usuarios</h2>  
					<h2 class="title text-center col-xs-4 col-sm-4">Productos</h2>
					<h2 class="title text-center col-xs-4 col-sm-4">Stock</h2>
				</div>			 		
			</div>    	
    		<div class="row">  
				<div class="col-xs-12 col-sm-12 col-md-12 padding-right"> 
					<div class="col-xs-4 col-sm-4">
						<form  id="main-contact-form" class="contact-form row" name="usuarios">													
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/altaUsuFormulario"><input type="button" name="altaU" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Alta"/></a>
							</div>
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/bajaOmodifUsu"><input type="button" name="bajaU" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Baja / Modificación"/></a>
							</div>	
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/verUsuarios"><input type="button" name="listaU" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Listado"/></a>
							</div>							
						</form>
					</div>
					<div class="col-xs-4 col-sm-4">
						<form  id="main-contact-form" class="contact-form row" name="productos">													
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/altaProFormulario"><input type="button" name="altaP" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Alta"/></a>
							</div>
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/bajaOmodifPro"><input type="button" name="bajaP" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Baja / Modificación"/></a>
							</div>	
							<div class="form-group col-md-12 col-sm-12">
								<a href="/ropa/verProductos"><input type="button" name="listaP" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Listado"/></a>
							</div>							
						</form>
					</div> 
					<div class="col-xs-4 col-sm-4">
						<div class="contact-form">
							<form  id="main-contact-form" class="contact-form row" name="stock">													
								<div class="form-group col-md-12 col-sm-12">
									<a href="/ropa/altaStock"><input type="button" name="altaS" class="btn btn-primary pull-left col-xs-5 col-md-5 col-sm-5" value="Alta Producto"/></a>
									<a href="/ropa/bajaStock"><input type="button" name="bajaS" class="btn btn-primary pull-right col-xs-5 col-md-5 col-sm-5" value="Baja Producto"/></a>								
								</div>
								<div class="form-group col-md-12 col-md-12">
									<a href="/ropa/agregarStock"><input type="button" name="bajaS" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Agregar Stock"/></a>
								</div>	
								<div class="form-group col-md-12 col-sm-12">
									<a href="/ropa/verStock"><input type="button" name="listaS" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Listado"/></a>
								</div>							
							</form>
						</div>
					</div>  
				</div>
	    	</div> 
	    	<div class="row ">  		
	    		<div class="col-sm-12 col-xs-12 padding-right"> 
					<h2 class="title text-center col-xs-12 col-sm-12">Categorías - Colores - Talles</h2>
				</div>			 		
			</div>
    		<div class="row">  
				<div class="col-xs-12 col-sm-12 col-md-12 padding-right"> 
					<div class="col-xs-12 col-sm-12">
						<form  id="main-contact-form" class="contact-form row" name="varios">
							<div class="form-group col-md-4 col-sm-4">
							</div>													
							<div class="form-group col-md-4 col-sm-4">
								<a href="/ropa/administrar2"><input type="button" name="cct" class="btn btn-primary pull-left col-xs-12 col-md-12 col-sm-12" value="Listado / Alta / Baja"/></a>
							</div>	
							<div class="form-group col-md-4 col-sm-4">
							</div>													
						</form>
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