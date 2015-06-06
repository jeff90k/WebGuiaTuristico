<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Guia Turístico de São Paulo</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
		<link rel="stylesheet" type="text/css" href="css/menu-submenu.css">
		<script src="js/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="js/bootstrap.min.js"></script>
		<style>
			.mapa {height: 500px; margin-left: 20px;}		
		</style>
	</head>
    <body>
    <%@	include file="includes/navbar.jsp" %>
	<%@	include file="includes/loginModal.jsp" %>
     	<br /><br /><br /><br />
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-7 col-md-11 mapa" id="mapa">
				<!-- MAPA DE LOCALIDADES -->
			</div>
		</div>
	</div>
	<br />
	<%@	include file="includes/footer.jsp" %>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrapValidator.min.js"></script>
    <!-- Maps API Javascript -->
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyB3saDw0YhwPQCBhXMUZkxluWkduBNcJ6E&sensor=false">
    </script>
    <!-- Caixa de informaÃ§Ã£o -->
    <script src="js/infobox.js"></script>
    <!-- Agrupamento dos marcadores -->
	<script src="js/markerclusterer.js"></script>
	<!-- Arquivo de inicializaÃ§Ã£o do mapa -->
	<script src="js/mapa.js"></script>
</body>
</html>