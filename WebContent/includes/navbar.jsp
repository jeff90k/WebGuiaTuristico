
<link rel="stylesheet" type="text/css" href="css/menu-submenu.css">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
	    <div class="col-md-11">
	    	<!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		        </button>
		        <a class="navbar-brand" href="/Biblioteca_IntraDS/index.php">Biblioteca IntraDS</a>
		    </div>
		    <div>
		        <ul class="nav navbar-nav navbar-left">
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sugestão <span class="caret"></span></a>
		            <ul class="dropdown-menu" role="menu">
		              <li><a href="" data-toggle="modal" data-target="#myModal">Enviar Sugestão</a></li>
		            </ul>
		          </li>
		        </ul>
		    </div>
		    <div>
		        <ul class="nav navbar-nav navbar-left">
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Item <span class="caret"></span></a>
		            <ul class="dropdown-menu" role="menu">
		              <li><a href="/Biblioteca_IntraDS/Item/incluirItem.php">Cadastrar</a></li>
		              <li><a href="/Biblioteca_IntraDS/Item/reservarItem.php">Reservar Item</a></li>
		              <li><a href="/Biblioteca_IntraDS/Classificacao/classificar.php">Avaliar</a></li>
		              <li class="divider"></li>
		              <li><a href="/Biblioteca_IntraDS/Item/Exemplar/incluirExemplar.php">Incluir Exemplar</a></li>
		            </ul>
		          </li>
		        </ul>
		    </div>
	    	<div>
		        <ul class="nav navbar-nav navbar-left">
		        	<li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Gerenciamento <span class="caret"></span></a>
			            <ul class="dropdown-menu" role="menu">
							<li><a href="/Biblioteca_IntraDS/parametrizacao/parametrizar.php">Parametrizar Sistema</a></li>
							<li><a href="/Biblioteca_IntraDS/Usuario/permissao.php">Atribuir Permissão</a></li>	            	<li class="divider"></li>
			            	<li class="dropdown-submenu">
			                	<a tabindex="-1" href="#">Relatórios</a>
			                	<ul class="dropdown-menu">
				                    <li><a href="/Biblioteca_IntraDS/Sugestao/listaSugestao.php">Listar Sugestões</a></li>
					                    <li class="dropdown-submenu">
				                    	<a href="#">Itens</a>
					                    <ul class="dropdown-menu">
		              						<li><a href="/Biblioteca_IntraDS/Item/listaItem.php">Listar Todos os Itens</a></li>
					                    </ul>
			                  		</li>
					                    <li class="dropdown-submenu">
				                    	<a href="#">Exemplar</a>
					                    <ul class="dropdown-menu">
		              						<li><a href="/Biblioteca_IntraDS/Item/Exemplar/listarExemplar.php">Listar Exemplares</a></li>
					                    </ul>
			                  		</li>
			                  </ul>
			                </li>
			            </ul>
		        	</li>
		        </ul>
		        <form action="CategController" method="GET" class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="hidden" name="funcao" value="listCategPerPage" />
						<input type="hidden" name="page" value="1" />
						<input type="hidden" name="perPage" value="5" />
						<i>
							<input type="text" name="categoria" class="form-control" placeholder="Pesquisar">
						</i>
					</div>
					<button type="submit" value="Pesquisar" class="btn btn-default">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</form>
	    	</div>
		</div>
	</div>
</nav>