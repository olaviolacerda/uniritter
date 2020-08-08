<?php 		  require_once('functions.php'); 		  login(); logout();	?>

<html>
<head>
	  <meta charset='UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Login de Usuário</title>

<style>
.form-control {
	width:40%;

}
.form, h2 {
    margin-left: 36%;
	margin-top: 100px;
}

.cadastro {
margin-left: 20%;


}
</style>
</head>
<body>
	<header>
		<div class="row">
			<div class="col-sm-6">
				<h2>Series avaliadas</h2>
			</div>
			<div class="col-sm-6 text-right h2">
		     <div class='btn btn-info voltar' onclick='javascript:location.href="avaliacaogeral.php"' >Avaliação Geral</div>

		    </div>
		</div>
	</header>

  <h2 > Login de Usuário </h2>
<div class="form">
<form name='form' method='post' action="login.php">
	<div class="form-group">
		<label>Username:</label> <input  class="form-control" type="text" name="login" id="login" ><br/>
	</div>
	<div class="form-group">
		<label>Senha:</label> <input class="form-control" type="text" name="senha" id="senha" ><br/>
	</div>

	<input  class="btn btn-primary" type="submit" name="entrar" value="Entrar" id="entrar">
  <div class='btn btn-info cadastro' onclick='javascript:location.href="cadastrousuario.php"' >Cadastrar</div>

</form>
	</div>
</body>
</html>
