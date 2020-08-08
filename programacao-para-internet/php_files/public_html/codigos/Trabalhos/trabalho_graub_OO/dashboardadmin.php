<?php
if(!empty($_COOKIE['login'])){
 $login_cookie = $_COOKIE['login'];
 }

 if(!isset($login_cookie)){
    header('Location: login.php');
  }

 if(!empty($_COOKIE['admin'])){
  $admin_cookie = $_COOKIE['admin'];
}
  if($admin_cookie != 1){
  header('Location: dashboardusuario.php');
  }

   require_once('functions.php');
   indexusuarios();
	?>

<html>
<head>
	  <meta charset='UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Gerenciador de Usuarios</title>

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


<!--<div class='bemvindo col-sm-9'>
<h3 >
Bem-Vindo, $login_cookie
</h3>
</div>
<div class='btn btn-primary col-sm-2 logout' onclick='javascript:location.href=\"login.php?logout=true\"' >Logout</div>
<br>
<h2 > Gerenciador de séries</h2> -->


<header>
	<div class="row">
		<div class="col-sm-4">
			<h2>Usuarios</h2>
		</div>
		<div class="col-sm-8 text-right h2">
	    	<a class="btn btn-primary" href="cadastrousuario.php"><i class="fa fa-plus"></i> Novo Usuario</a>
			<a class="btn btn-primary" href="trocarsenhausuario.php"><i class="fa fa-plus"></i> Trocar Senha</a>
      	<a class="btn btn-primary" href="excluirusuario.php"><i class="fa fa-plus"></i> Excluir Usuario</a>
	     <div class='btn btn-info voltar' onclick='javascript:location.href="login.php?logout=true"' >Logout</div>

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
		<th >Id</th>
		<th>Nome</th>
		<th>Senha</th>
		<th>Admin</th>
	</tr>
</thead>
<tbody>
<?php if ($usuarios) : ?>
<?php foreach ($usuarios as $usuario) : ?>
	<tr>
		<td><?php echo $usuario['id']; ?></td>
		<td><?php echo $usuario['username']; ?></td>
		<td><?php echo $usuario['senha']; ?></td>
		<td><?php echo $usuario['admin']; ?></td>

	</tr>
<?php endforeach; ?>
<?php else : ?>
	<tr>
		<td colspan="6">Nenhum registro encontrado.</td>
	</tr>
<?php endif; ?>
</tbody>
</table>

</body>
</html>
