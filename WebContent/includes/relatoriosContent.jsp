<?php
	error_reporting(0);
	ini_set(“display_errors”, 0 );
	
	$tipo = $_GET['tipo'];

	if($tipo == 'listaUsuarios'){
		include_once('../back-end/relatorios/listaUsuarios.php');
	}
	if($tipo == 'listaLocalidades'){
		include_once('../back-end/relatorios/listaLocalidades.php');
	}

?>