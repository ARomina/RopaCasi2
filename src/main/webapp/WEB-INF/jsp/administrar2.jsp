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
					<h2 class="title text-center col-xs-4 col-sm-4">Categoría</h2>  
					<h2 class="title text-center col-xs-4 col-sm-4">Color</h2>
					<h2 class="title text-center col-xs-4 col-sm-4">Talle</h2>
				</div>			 		
			</div>    	
    		<div class="row">  
				<div class="col-xs-12 col-sm-12 col-md-12 padding-right"> 
					<div class="col-xs-4 col-sm-4">
						<div id="main-contact-form" class="contact-form row">													
							<div class="form-group col-md-12 col-sm-12">
								<form:form action="/ropa/altaCat" modelAttribute="categoria color talle" role="form" method="POST" name="altaCat" >
								  <div class="form-group">
									<input type="text" name="categoria" class="form-control" placeholder="Nueva Categoría" required="required" 
									pattern="[A-Z ÑÁÉÍÓÚ]{2,15}" title="Ej: CATEGORIA"/>
								<button type="submit"  class="btn btn-primary pull-right" id="boton">Ingresar</button>
								  </div>
								</form:form>
							</div>

							<div class="form-group col-md-12 col-sm-12">
								 <div id="contact-page" class="table-responsive">
									<table class="table table-bordered sortable-theme-bootstrap" data-sortable>
									<thead>
											<tr>
												<th data-sortable-type="alpha" data-sorted="true" data-sorted-direction="descending">LISTADO</th>
											</tr>
										</thead>
										<tbody>	
										<c:forEach items="${categorias}" var="categoria">
											<tr>
												<td>
													${categoria.categoria}
													<a href="/ropa/bajaCat?categoria=${categoria.categoria}" class="color2 pull-right col-xs-3 col-md-3 col-sm-3">Eliminar</a>
												</td>														
											</tr>
										</c:forEach>
									</tbody>
									</table>
							  	 </div>
							</div>							
						</div>
							<div class="form-group col-md-12 col-sm-12">

							</div>							
					</div>
					
					
					<div class="col-xs-4 col-sm-4">
						<div id="main-contact-form" class="contact-form row">													
							<div class="form-group col-md-12 col-sm-12">
								<form:form action="/ropa/altaCol" modelAttribute="color categoria talle" role="form" method="POST" name="altaCol" >
								  <div class="form-group">
									<input type="text" name="color" class="form-control" placeholder="Nuevo Color" required="required" 
									pattern="[A-Z ÑÁÉÍÓÚ]{2,15}" title="Ej: COLOR"/>
								<button type="submit"  class="btn btn-primary pull-right" id="boton">Ingresar</button>
								  </div>
								</form:form>
							</div>

							<div class="form-group col-md-12 col-sm-12">
								 <div id="contact-page" class="table-responsive">
									<table class="table table-bordered sortable-theme-bootstrap" data-sortable>
									<thead>
											<tr>
												<th data-sortable-type="alpha" data-sorted="true" data-sorted-direction="descending">LISTADO</th>
											</tr>
										</thead>
										<tbody>	
										<c:forEach items="${colores}" var="color">
											<tr>
												<td>
													${color.color}
													<a href="/ropa/bajaCol?color=${color.color}" class="color2 pull-right col-xs-3 col-md-3 col-sm-3">Eliminar</a>
												</td>														
											</tr>
										</c:forEach>
									</tbody>
									</table>
							  	 </div>
							</div>							
						</div>
							<div class="form-group col-md-12 col-sm-12">

							</div>							
					</div>
					
					<div class="col-xs-4 col-sm-4">
						<div id="main-contact-form" class="contact-form row">													
							<div class="form-group col-md-12 col-sm-12">
								<form:form action="/ropa/altaTal" modelAttribute="color categoria talle" role="form" method="POST" name="altaTal" >
								  <div class="form-group">
									<input type="text" name="talle" class="form-control" placeholder="Nuevo Talle" required="required" 
									pattern="[0-9A-Z ÑÁÉÍÓÚ]{1,15}" title="Ej: XL ó 42"/>
								<button type="submit"  class="btn btn-primary pull-right" id="boton">Ingresar</button>
								  </div>
								</form:form>
							</div>

							<div class="form-group col-md-12 col-sm-12">
								 <div id="contact-page" class="table-responsive">
									<table class="table table-bordered sortable-theme-bootstrap" data-sortable>
									<thead>
											<tr>
												<th data-sortable-type="alpha" data-sorted="true" data-sorted-direction="descending">LISTADO</th>
											</tr>
										</thead>
										<tbody>	
										<c:forEach items="${talles}" var="talle">
											<tr>
												<td>
													${talle.talle}
													<a href="/ropa/bajaTal?talle=${talle.talle}" class="color2 pull-right col-xs-3 col-md-3 col-sm-3">Eliminar</a>
												</td>														
											</tr>
										</c:forEach>
									</tbody>
									</table>
							  	 </div>
							</div>							
						</div>
							<div class="form-group col-md-12 col-sm-12">

							</div>							
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