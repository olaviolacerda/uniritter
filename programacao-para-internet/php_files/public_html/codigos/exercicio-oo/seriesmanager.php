<html>
  
<head>
  <meta charset='UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Incluir Séries</title>

<style>
.form-control {
	width:40%;
	
}
	.table{
		width: 40%;
	}
.form {
  margin-left: 36%;
	margin-top: 100px;
}
</style>




</head>
<body>
	<?php
		session_start();
		$user = $_SESSION['user'];
	?>
	
<div class="form">
<form name='form' method='POST' action="seriesmanager.php">
	<?php echo "<h1>Bem vindo " . $user ."  !!! </h1><br />"; ?>
	<div class="form-group">
		<label>Serie:</label> <input class="form-control" type="text" name="serie" id="serie" ><br/>
		<label>Temporada:</label> <input class="form-control" type="text" name="temp" id="temp" ><br/>
		<label>Episodio:</label> <input class="form-control" type="text" name="ep" id="ep" ><br/>
	</div>
	<?php
	include_once 'cacheseries.php';
	include_once 'show.php';
	$cacheArquivo = new CacheArquivo();
  $cacheSessao = new CacheSessao();

	
// ADICIONAR SÉRIE PHP
	if(	isset($_POST['serie']) && !empty($_POST['serie']) && !empty($_POST['temp']) && isset($_POST['temp']) && !empty($_POST['ep']) && isset($_POST['ep'])) {
	$temp = trim($_POST['temp']);
	$ep = trim($_POST['ep']);
	$serie = trim($_POST['serie']);
	addSerie2($serie,$temp,$ep, $user,$cacheArquivo, $cacheSessao);
	$temp = null;
  $ep = null;
  $serie = null;
  }else if(	isset($_POST['serie']) && !empty($_POST['serie'])) {
		
		$serie = trim($_POST['serie']);
		
		addSerie($serie, $user,$cacheArquivo, $cacheSessao);
		 $serie = null;
	}
$data = showSeries($user, $cacheArquivo, $cacheSessao);
	
	?>
	<input  class="btn btn-primary" type="submit" name="submit" value="Enviar">  
	
</form>
	<h2>
		Veja aqui suas séries favoritas
	</h2>
	
		
	<table class="table">
  <thead>
    <tr>
      <th>Serie</th>
      <th>Temporada</th>
      <th>Episódio</th>
    </tr>
  </thead>
  <tbody>
    
      <?php
	if(!empty($data["series"])){
		
foreach($data["series"] as $item)
{
	 echo "<tr><td>" .$item['serie']["name"] . "</td>  <td>" . $item['serie']["season"]   .  " </td><td>" .  $item['serie']["episode"]  . "</td></tr>";
}
	}
 

?>
    
  
   
  </tbody>
</table>
	
	
	</div>


	
	
	
</body>
</html>