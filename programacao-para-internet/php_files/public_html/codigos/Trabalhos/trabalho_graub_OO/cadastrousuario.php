				<?php 		  require_once('functions.php'); 		  addUser();		?>

<html>
<head>
	  <meta charset='UTF-8' />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Cadastro de Usuário</title>

<style>
.form-control {
	width:40%;

}
.form, h2 {
    margin-left: 36%;
	margin-top: 100px;
}
</style>
</head>
<body>
	<header>
		<div class="row">
			<div class="col-sm-10">
				<h2>Cadastro de Usuário</h2>
			</div>
			<div class="col-sm-2 text-right h2">
		     <div class='btn btn-info voltar' onclick='javascript:location.href="dashboardadmin.php"' >Voltar</div>

		    </div>
		</div>
	</header>
<div class="form">
<form name='form' method='post' action="cadastrousuario.php">
	<div class="form-group">
		<label>Username:</label> <input  class="form-control" type="text" name="user['username']" id="user" ><br/>
	</div>
	<div class="form-group">
		<label>Senha:</label> <input class="form-control" type="text" name="user['senha']" id="pswd" ><br/>
	</div>
  <!-- Fazer dps caso queira fazer
  <div class="form-group">
		<label>Confirmar senha:</label> <input class="form-control" type="text" name="pswd2" id="pswd2" ><br/>
	</div> -->
	<input  class="btn btn-primary" type="submit" name="submit" value="Salvar">

</form>
	</div>
</body>
</html>
