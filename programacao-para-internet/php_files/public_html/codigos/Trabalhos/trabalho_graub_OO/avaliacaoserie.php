<?php 		if(!empty($_COOKIE['login'])){
$login_cookie = $_COOKIE['login'];
}  require_once('functions.php'); 	indexseriados();	index();	addAvaliarSerie();	?>

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
<div class='btn btn-primary col-sm-2 logout' onclick='javascript:location.href="login.php?logout=true"' >Logout</div>
  <h2 > Avaliacao de Série </h2>
<div class="form">
<form name='form' method='post' action="avaliacaoserie.php">
<div class="form-group">
<label>Série:</label>
<select class="form-control" name="serie[seriadoId]">
<?php if ($seriadosbanco) : ?>
<?php foreach ($seriadosbanco as $seriadoreal) : ?>
	<?php foreach ($seriados as $seriado) : ?>
	<?php if ($seriado['seriadoId'] == $seriadoreal['id'] && $seriado['userId'] == $login_cookie) : ?>
<option value="<?php echo $seriadoreal['id'] ?>"><?php echo $seriadoreal['nome']; ?></option>
	<?php endif; ?>
	<?php endforeach; ?>






<?php endforeach; ?>
<?php else : ?>
	<tr>
		<td colspan="6">Nenhum registro encontrado.</td>
	</tr>
<?php endif; ?>

</select>
</div>

	<div class="form-group">
		<label>Temporada:</label> <input  class="form-control" type="text" name="serie[temporada]" id="temporada" ><br/>
	</div>
	<div class="form-group">
		<label>Episodio:</label> <input  class="form-control" type="text" name="serie[episodio]" id="episodio" ><br/>
	</div>
	<div class="form-group">
		<label>Nota:</label> <input  class="form-control" type="text" name="serie[nota]" id="nota" ><br/>
	</div>

	<input  class="btn btn-primary" type="submit" name="submit" value="Salvar">
	 <div class='btn btn-info voltar' onclick='javascript:location.href="dashboardusuario.php"' >Voltar</div>

</form>
	</div>
</body>
</html>
