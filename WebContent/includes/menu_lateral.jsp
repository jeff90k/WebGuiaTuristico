<script>
	$(function() {
		$("#selectCategoria").on("change", function(event) {
			event.preventDefault();
			$.ajax({
				url: "back-end/selectCategoria.php",
				type: "post",
				data: "#selectCategoria",
				success: function(response) {
					$("#selectCategoria").html(response);
				},
				beforeSend: function () {
	                $("#response").html("Aguarde...");
	            },
	            /*error: function (err) {
	                console.log("Error: " + err.status);
	                console.log("Error Message: " + err.statusText);
	            }*/
			});
		});
	});
</script>
<form class="form-horizontal" id="form_members" role="form">
	<div class="form-group ">
		<legend>Filtros</legend>
		<label for="firstname">Categoria</label>
		<select class="form-control" name="region" id="selectCategoria">
			<?php
				require_once("back-end/conn.php");
				try {
					$stmt = $pdo->query("SELECT NOME AS CATEGORIA FROM CATEGORIA ORDER BY CATEGORIA");
				    
				    echo"<option>Todas as Categorias</option>";
				    while($row = $stmt->fetch()){
			    		echo "<option>".$row['CATEGORIA']."</option>";
			    	}
			    }
				catch (PDOException $ex) {
			    	echo $ex->getMessage();
				}
			?>
		</select>
	</div>
</form>