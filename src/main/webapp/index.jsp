<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<jsp:include page="WEB-INF/jsp/headerIndex.jsp"/>			
	</header>
	
	<section id="slider">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<img src="images/home/slider1.jpg" alt="">
									<div class="carousel-caption">
									<img src="images/home/logoblanco.png" alt=""/>
						                <h1>Tu tienda en linea</h1>
					                </div>
							</div>
							<div class="item">
								<img src="images/home/slider2.jpg" alt="">
									<div class="carousel-caption">
									<img src="images/home/logoblanco.png" alt=""/>									
						                <h1>La mejor manera de vestirte</h1>
					                </div>
							</div>
							
							<div class="item">
								<img src="images/home/slider3.jpg" alt="">
									<div class="carousel-caption">
									<img src="images/home/logoblanco.png" alt=""/>									
						                <h1>Comprá desde tu casa</h1>
					                </div>
							</div>
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

<%@include file="WEB-INF/jsp/footer.jsp" %>	

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/main.js"></script>
	<script src="js/html5shiv.js"></script>
	
</body>
</html>