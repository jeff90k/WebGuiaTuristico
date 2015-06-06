<!DOCTYPE html>
<html>
<head>
	<?php
		error_reporting(0);
		ini_set(“display_errors”, 0 );
		
		session_start();
		if((!isset ($_SESSION['login'])) and (!isset ($_SESSION['senha']))){
			$_SESSION['url'] = "http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
			header('location:login.php');
		}
	?>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Guia Turístico de São Paulo</title>
	<!-- Latest compiled and minified CSS -->
	<link href="../css/bootstrap.css" rel="stylesheet">
	<!-- Optional theme -->
	<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/estilo.css">
	<script src="../js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <script>
    	function delLocalidadesRoteiro(id){		
			var r = confirm("Deseja realmente excluir esta localidade do roteiro?"); 
			if (r == true) {
				var xmlhttp;
				if (window.XMLHttpRequest){
					// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				 }
				else{
					// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange=function(){
					if (xmlhttp.readyState==4 && xmlhttp.status==200){
						var response = xmlhttp.responseText;
						window.location.reload();
					}
				}
				xmlhttp.open("GET","../back-end/delLocalidadeRoteiro.php?id="+id, true);
				xmlhttp.send();
			}	
		}
		</script>
</head>
<body>
	<div class="panel-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="text-center">Código</th>
					<th class="text-center">Nome</th>
					<th class="text-center">Endereço</th>
					<th class="text-center">Categoria</th>
					<th class="text-center">Faixa Etária</th>
					<th class="text-center">Ação</th>
				</tr>
			</thead>
			<tbody>
				 <?php
					require_once("../back-end/conn.php");
					try {
						session_start();
						$stmt = $pdo->query("SELECT T.ID FROM TURISTA T WHERE T.LOGIN='".$_SESSION['login']."'");
						$getID = $stmt->fetchColumn(0);

						$sql = "SELECT L.ID AS ID_LOCALIDADE, L.NOME AS NOME_LOCALIDADE, L.ENDERECO AS ENDERECO_LOCALIDADE, L.NOME AS CATEGORIA_NOME,
								L.FAIXA_ETARIA AS FAIXA_ETARIA,	R.ID AS ROTEIRO_ID FROM LOCALIDADE L
								INNER JOIN CATEGORIA C ON L.CATEGORIA_ID = C.ID
								INNER JOIN LOCALIDADE_ROTEIRO LR ON L.ID = LR.LOCALIDADE_ID
								INNER JOIN ROTEIRO R ON R.ID = LR.ROTEIRO_ID AND ROTEIRO_ID = '".$getID."' ORDER BY L.ID";
						$statement = $pdo->query($sql);
					    foreach($statement as $row) {
					    	$rows = $statement->rowCount();
					    	echo"<tr>
								<td class='text-center'>".$row['ID_LOCALIDADE']."</td>
								<td class='text-center'>".$row['NOME_LOCALIDADE']."</td>
								<td class='text-center'>".$row['ENDERECO_LOCALIDADE']."</td>
								<td class='text-center'>".$row['CATEGORIA_NOME']."</td>
								<td class='text-center'>".$row['FAIXA_ETARIA']."</td>
								<td class='text-center'>
									<button type='button' class='btn btn-default' onclick='delLocalidadesRoteiro(".$row['ID_LOCALIDADE'].")' data-dismiss='modal'>Excluir</button>
								</td>
							</tr>";
					    }
					}
					catch (PDOException $ex) {
				    	echo $ex->getMessage();
					}
					echo "<div id='response' class='pull-right'>Número de registros encontrados: ".$rows."</div>";
				?>
			</tbody>
		 </table>
	</div>
</body>
</html>