<form class="form-horizontal" id="form_members" role="form" action="back-end/sessions.php" method="post">
	<legend>Login no Sistema</legend>
	<div class="form-group">
		<label for="firstname" class="col-sm-3">Usuário</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" name="login" id="firstname" placeholder="Nome de Usuário">
			<input type="hidden"name="acao" value="login">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3">Senha</label>
		<div class="col-sm-9">
			<input type="password" class="form-control" name="senha" id="lastname" placeholder="Senha">
		</div>
	</div>
	<button type="submit" class="btn btn-default" name="submit" id="submit">Entrar</button>
	<button type="reset" class="btn btn-primary" data-dismiss="modal" id="submit">Limpar Campos</button>
	</br>
	<a href="cadastroUsuario.php">Não possuo cadastro</a>
</form>