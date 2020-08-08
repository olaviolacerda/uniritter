<?php 		 include('banco/database.php');	 ?>
<?php require_once 'config.php'; ?>
<?php require_once DBAPI; ?>
<?php
/**		 *  Cadastro de Clientes		 */
date_default_timezone_set('America/Sao_Paulo');

$seriados = null;
$seriado = null;
$seriadosbanco = null;
$usuarios = null;

function index() {
	global $seriados;
	$seriados = find_all('usuarios_seriados');
}


function indexseriados(){
	global $seriadosbanco;
	$seriadosbanco = find_all('seriados');
}

function indexusuarios(){
	global $usuarios;
	$usuarios = find_all('usuarios');
}
function find_all( $table ) {
	  return find($table);
	}

function find( $table = null, $id = null ) {

	$database = open_database();
	$found = null;

	try {
	  if ($id) {
	    $sql = "SELECT * FROM " . $table . " WHERE id = " . $id;
	    $result = $database->query($sql);

	    if ($result->num_rows > 0) {
	      $found = $result->fetch_assoc();
	    }

	  } else {

	    $sql = "SELECT * FROM " . $table;
	    $result = $database->query($sql);

	    if ($result->num_rows > 0) {
	      $found = $result->fetch_all(MYSQLI_ASSOC);

	    }
	  }
	} catch (Exception $e) {
	  $_SESSION['message'] = $e->GetMessage();
	  $_SESSION['type'] = 'danger';
  }

	close_database($database);
	return $found;
}

function addUser() {
  if (!empty($_POST['user'])) {
  $user = $_POST['user'];

  foreach ($user as $key => $value) {
    $values = "$value";
    break;
  }

        $db = open_database();

          $numrows = $db->query("SELECT * FROM usuarios WHERE username = '$values'") or die("erro ao selecionar");

              if ($numrows->num_rows<=0){

                save('usuarios', $user);
                echo"<script language='javascript' type='text/javascript'>alert('Login criado com sucesso!');window.location.href='cadastrousuario.php';</script>";
logMsg("O usuario " . $values . " foi criado. " );
              }else{
                echo"<script language='javascript' type='text/javascript'>alert('Usuario existente!');window.location.href='cadastrousuario.php';</script>";


          }

	}
  }

  function addSerie() {
  if (!empty($_POST['serie'])) {
  $serie = $_POST['serie'];

	if(!empty($_COOKIE['login'])){
 $login_cookie = $_COOKIE['login'];
 $serieuser['userId'] = $login_cookie;
 }


  foreach ($serie as $key => $value) {
    $values = "$value";
    break;
  }

        $db = open_database();

          $numrows = $db->query("SELECT * FROM seriados WHERE nome = '$values'") or die("erro ao selecionar");

              if ($numrows->num_rows<=0){

                save('seriados', $serie);
								$numrows = $db->query("SELECT * FROM seriados WHERE nome = '$values'") or die("erro ao selecionar");

								$found = $numrows->fetch_all(MYSQLI_ASSOC);
						  foreach($found as $founded){
								 $serieuser['seriadoId'] = $founded['id'];
						  }
							save('usuarios_seriados', $serieuser);



                echo"<script language='javascript' type='text/javascript'>alert('Serie cadastrada com sucesso!');window.location.href='cadastroserie.php';</script>";
	logMsg("O usuario " . $login_cookie . " adicionou a serie " . $values);
              }else{
                echo"<script language='javascript' type='text/javascript'>alert('Serie existente!');window.location.href='cadastroserie.php';</script>";


          }

	}
  }


	function addSerieUsuario() {
 if (!empty($_POST['series'])) {
 $serie = $_POST['series'];


 if(!empty($_COOKIE['login'])){
$login_cookie = $_COOKIE['login'];
$serie['userId'] = $login_cookie;
}
$db = open_database();
$userIdSearch = $serie['userId'];
$seriadoIdSearch =  $serie['seriadoId'];



$numrows = $db->query("SELECT * FROM usuarios_seriados WHERE userId = '$userIdSearch' AND seriadoId = '$seriadoIdSearch'  ") or die("erro ao selecionar");
if ($numrows->num_rows > 0) {

			 echo"<script language='javascript' type='text/javascript'>alert('Serie já adicionada!');</script>";

		 }else {
							 save('usuarios_seriados', $serie);
							 echo"<script language='javascript' type='text/javascript'>alert('Série adicionada!');</script>";
								 logMsg("O usuario " . $login_cookie . " adicionou a série de id " . $seriadoIdSearch);

				 }

 }

	}




   function addAvaliarSerie() {
  if (!empty($_POST['serie'])) {
  $serie = $_POST['serie'];


  if(!empty($_COOKIE['login'])){
 $login_cookie = $_COOKIE['login'];
 $serie['userId'] = $login_cookie;
 }
 $serie['avaliado'] = 1;
 $db = open_database();
 $userIdSearch = $serie['userId'];
 $seriadoIdSearch =  $serie['seriadoId'];



 $numrows = $db->query("SELECT * FROM usuarios_seriados WHERE userId = '$userIdSearch' AND seriadoId = '$seriadoIdSearch'  ") or die("erro ao selecionar");
if ($numrows->num_rows > 0) {
	      $found = $numrows->fetch_all(MYSQLI_ASSOC);
		  foreach($found as $founded){
			  update('usuarios_seriados',$founded['id'],$serie);
		  }
        echo"<script language='javascript' type='text/javascript'>alert('Avaliação de serie atualizada com sucesso!');</script>";
				logMsg("O usuario " . $login_cookie . " alterou a avaliação da serie de id " . $seriadoIdSearch);
	    }else {

                echo"<script language='javascript' type='text/javascript'>alert('Serie Avaliada com sucesso!');</script>";
									logMsg("O usuario " . $login_cookie . " avaliou a serie de id " . $seriadoIdSearch);

          }

	}

   }

	 function trocarSenha() {
	if (!empty($_POST['senha'])) {
	$senha = $_POST['senha'];


	if(!empty($_COOKIE['login'])){
 $login_cookie = $_COOKIE['login'];
 }
 $db = open_database();
$senhaAlterar['senha'] = $senha;


			 update('usuarios',$login_cookie,$senhaAlterar);
				echo"<script language='javascript' type='text/javascript'>alert('Senha alterada com sucesso!');</script>";
logMsg("O usuario " . $login_cookie . " alterou a senha");


					}

 }


 function trocarSenhaUserAdmin() {
if (!empty($_POST['usuario'])) {
$usuario = $_POST['usuario'];
$db = open_database();
		 update('usuarios',$usuario['id'],$usuario);
			echo"<script language='javascript' type='text/javascript'>alert('Senha alterada com sucesso!');</script>";
logMsg("O usuario de id " . $usuario['id'] . " foi alterado a senha pelo admin");


				}

}


function rmvUser(){
	if (!empty($_POST['usuario'])) {
	$usuario = $_POST['usuario'];
logMsg("O usuario de id " . $usuario['id'] . " foi removido pelo admin");
remove('usuarios',$usuario['id']);

				echo"<script language='javascript' type='text/javascript'>alert('Usuario removido com sucesso!');window.location.href='excluirusuario.php';</script>";


	}


}






function logout() {
  if (isset($_GET['logout'])) {
		logMsg("O usuario deslogou");
  setcookie("login",null);

  }

}




  /**
   *	Atualizacao/Edicao de Cliente
   */
  function login() {
      if (!empty($_POST['login'])) {
    $login = $_POST['login'];
      $entrar = $_POST['entrar'];
      $senha =$_POST['senha'];
      $db = open_database();
        if (isset($entrar)) {
        $numrows = $db->query("SELECT * FROM usuarios WHERE username = '$login' AND senha = '$senha'") or die("erro ao selecionar");
            if ($numrows->num_rows<=0){
              echo"<script language='javascript' type='text/javascript'>alert('Login e/ou senha incorretos');window.location.href='login.php';</script>";
              die();
            }else{
				foreach ($numrows as $key => $value) {
			break;
				}
              setcookie("login",$value['id']);
							setcookie("admin",$value['admin']);
							logMsg("O usuario " . $value['username'] . " acabou de logar.");
             header("Location:dashboardusuario.php");
            }
        }
      }
  }



	function remove( $table = null, $id = null ) {

	  $database = open_database();

	  try {

	    if ($id) {

	      $sql = "DELETE FROM " . $table . " WHERE id = " . $id;
				$result = $database->query($sql);

	        $_SESSION['message'] = "Registro Removido com Sucesso.";
	        $_SESSION['type'] = 'success';

	    }
	  } catch (Exception $e) {

	    $_SESSION['message'] = $e->GetMessage();
	    $_SESSION['type'] = 'danger';
	  }

	  close_database($database);
	}


function update($table = null, $id = 0, $data = null) {

  $database = open_database();

  $items = null;

  foreach ($data as $key => $value) {
    $items .= trim($key, "'") . "='$value',";
  }

  $items = rtrim($items, ',');

  $sql  = "UPDATE " . $table;
  $sql .= " SET $items";
  $sql .= " WHERE id=" . $id . ";";

  try {
    $database->query($sql);

    $_SESSION['message'] = 'Registro atualizado com sucesso.';
    $_SESSION['type'] = 'success';

  } catch (Exception $e) {

    $_SESSION['message'] = 'Nao foi possivel realizar a operacao.';
    $_SESSION['type'] = 'danger';
  }

  close_database($database);
}

function logMsg( $msg, $file = 'main.log' )
{

    $date = date( 'Y-m-d H:i:s' );


    $msg = sprintf( "[%s] [%s]: %s%s", $date, 'info', $msg, PHP_EOL );

    file_put_contents( $file, $msg, FILE_APPEND );
}
