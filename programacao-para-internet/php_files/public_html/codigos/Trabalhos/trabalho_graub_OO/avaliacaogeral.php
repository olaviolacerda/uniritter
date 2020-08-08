<?php
   require_once('functions.php');
   index();
   indexseriados();
	?>

<html>
<head>
	  <meta charset='UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Avaliação de serie</title>

<style>
.form-control {
	width:40%;

}


.logout {
float:right;
margin-right: 15px;
margin-top: 15px;

}

a {

  color: white;
}

.form, h2{
    margin-left: 25%;
	margin-top: 100px;
}
.bemvindo{
margin-left:15px;
}
h4{
    margin-left: 25%;

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
	     <div class='btn btn-info voltar' onclick='javascript:location.href="dashboardusuario.php"' >Voltar</div>

	    </div>
	</div>
</header>

<?php if (!empty($_SESSION['message'])) : ?>
	<div class="alert alert-<?php echo $_SESSION['type']; ?> alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<?php echo $_SESSION['message']; ?>
	</div>
	<?php clear_messages(); ?>
<?php endif; ?>

<hr>

<table class="table table-hover">
<thead>
	<tr>
		<th>ID</th>
		<th width="30%">Nome</th>

		<th>Nota</th>
    	<th>Quantidade de Avaliações</th>

	</tr>
</thead>
<tbody>
  <?php if ($seriadosbanco) : ?>
    <?php foreach ($seriadosbanco as $seriadoreal) : ?>
      <?php
        $notamedia = 0;
        $numeronotamedia = 0;
      ?>
<?php if ($seriados) : ?>
<?php foreach ($seriados as $seriado) : ?>
<?php if ($seriado['seriadoId'] == $seriadoreal['id'] && $seriado['avaliado'] == 1) : ?>
  <?php
    $notamedia += $seriado['nota'];
    $numeronotamedia ++;
  ?>

<?php endif; ?>
<?php endforeach; ?>
<?php
if($notamedia != 0)
  $notamedia = $notamedia/$numeronotamedia;


?>
<tr>
  <td><?php echo $seriadoreal['id'];  ?></td>
  <td><?php echo $seriadoreal['nome']; ?></td>
  <td><?php echo $notamedia; ?></td>
  <td><?php echo $numeronotamedia; ?></td>
</tr>
<?php else : ?>
	<tr>
		<td colspan="6">Nenhum registro encontrado.</td>
	</tr>
<?php endif; ?>
<?php endforeach; ?>
<?php endif; ?>
</tbody>
</table>

</body>
</html>
