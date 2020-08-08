<html>
<head>
	  <meta charset='UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Login Séries</title>

<style>
.form-control {
	width:40%;
	
}

.form {
    margin-left: 36%;
	margin-top: 100px;
}
</style>




</head>
<body>
<div class="form">
<form name='form' method='post' action="login.php">
	<div class="form-group">
		<label>User:</label> <input  class="form-control" type="text" name="user" id="user" ><br/>
	</div>
	<div class="form-group">
		<label>Password:</label> <input class="form-control" type="text" name="pswd" id="pswd" ><br/>
	</div>
	<?php

if (  isset($_POST['user']) &&  isset($_POST['pswd'])){
$user = trim($_POST['user']);
$pswd = trim($_POST['pswd']);

$patternUser = '/toshi/';
$patternPswd = '/aluno/';
if (preg_match($patternUser,$user) == 1 && preg_match($patternPswd,$pswd)){
		print_r("Acerto mizeravi");
		echo '<br>';
	session_start();
	
	$_SESSION['user'] = "toshi";
	
		  header("location: seriesmanager.php");
		exit;
exit();
	
}  else {
		print_r("Usuario ou senha errado!");
		echo '<br>';
	
}
}
?>
	<input  class="btn btn-primary" type="submit" name="submit" value="Submit">  

</form>
	</div>
</body>
</html>