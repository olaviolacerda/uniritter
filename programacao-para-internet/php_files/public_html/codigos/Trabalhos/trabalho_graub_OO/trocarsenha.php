<?php 		 if(!empty($_COOKIE['login'])){
 $login_cookie = $_COOKIE['login'];
 }
 require_once('functions.php'); 	trocarSenha();	?>

<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootst	rap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Avaliacao de Série</title>

<style>
.form-control {
	width:40%;

}
.form, h2 {
    margin-left: 36%;
	margin-top: 100px;
}
.logout {
float:right;
margin-right: 15px;
margin-top: -60px;

}

.cadastro {
margin-left: 20%;


}
</style>
</head>
<body>
<div class='btn btn-primary col-sm-2 logout' onclick='javascript:location.href=\"login.php?logout=true\"' >Logout</div>
  <h2 > Trocar Senha </h2>
<div class="form">
<form name='form' method='post' action="trocarsenha.php">

	<div class="form-group">
		<label>Nova Senha:</label> <input  class="form-control" type="text" name="senha" id="senha" ><br/>
	</div>
	<input  class="btn btn-primary" type="submit" name="submit" value="Salvar">
	 <div class='btn btn-info voltar' onclick='javascript:location.href="dashboardusuario.php"' >Voltar</div>

</form>
	</div>
</body>
</html>
