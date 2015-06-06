<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="index.php">Guia Turístico de São Paulo</a>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<?php
									if(isset($_SESSION['login']) && isset($_SESSION['senha'])){
										echo "Bem vindo(a) ".$_SESSION['login'];
									}
								?>
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="roteiro.php">Meu Roteiro</a></li>
								<li><a href="editarUsuario.php">Editar Informações</a></li>
								<li class="divider"></li>
								<li><a href="back-end/logout.php">Logout</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<!--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Encontre uma localidade">
						</div>
						<button type="submit" class="btn btn-default">Localizar</button>
					</form>
				</div>->
				<!-- navbar-collapse -->
			</div>
		</div>
	</div>
	<!-- container-fluid -->
</nav>