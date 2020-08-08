<?php 		  require_once('functions.php'); 		  addSerie();	indexseriados(); addSerieUsuario();	?>

<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootst	rap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Cadastro de Série</title>

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
<<header>
	<div class="row">
		<div class="col-sm-10">
			<h2>Cadastro Série</h2>
		</div>
		<div class="col-sm-2 text-right h2">
 <div class='btn btn-primary voltar' onclick='javascript:location.href="dashboardusuario.php"' >Voltar</div>
	     <div class='btn btn-info voltar' onclick='javascript:location.href="login.php?logout=true"' >Logout</div>

	    </div>
	</div>
</header>
<div class="form">
<form name='form' method='post' action="cadastroserie.php">
	<div class="form-group">
	<label>Série:</label>
	<select class="form-control" name="series[seriadoId]">
	<?php if ($seriadosbanco) : ?>
	<?php foreach ($seriadosbanco as $seriado) : ?>
	<option value="<?php echo $seriado['id'] ?>"><?php echo $seriado['nome']; ?></option>
	<?php endforeach; ?>
	<?php else : ?>
		<tr>
			<td colspan="6">Nenhum registro encontrado.</td>
		</tr>
	<?php endif; ?>

	</select>
	</div>
	<input  class="btn btn-primary" type="submit" name="submit" value="Salvar">


</form>
<form name='form' method='post' action="cadastroserie.php">
	<div class="form-group">
		<label>Nova Série:</label> <input  placeholder="Caso sua série não esteja na lista" class="form-control" type="text" name="serie['nome']" id="serie" ><br/>
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
