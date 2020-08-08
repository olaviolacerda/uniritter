<?php 		  require_once('functions.php');    indexusuarios();	rmvUser();?>

<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootst	rap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Excluir Usuarios</title>

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
<div class='btn btn-primary col-sm-2 logout' onclick='javascript:location.href="login.php?logout=true"' >Logout</div>
  <h2 > Excluir Usuario </h2>
<div class="form">
<form name='form' method='post' action="excluirusuario.php">
<div class="form-group">
<label>Usuario:</label>
<select class="form-control" name="usuario[id]">
<?php if ($usuarios) : ?>
<?php foreach ($usuarios as $usuario) : ?>
<option value="<?php echo $usuario['id'] ?>"><?php echo $usuario['username']; ?></option>
<?php endforeach; ?>
<?php else : ?>
	<tr>
		<td colspan="6">Nenhum registro encontrado.</td>
	</tr>
<?php endif; ?>

</select>
</div>


	<input  class="btn btn-primary" type="submit" name="submit" value="Excluir">
	 <div class='btn btn-info voltar' onclick='javascript:location.href="dashboardadmin.php"' >Voltar</div>

</form>
	</div>
</body>
</html>
