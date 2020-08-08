<?php

if($_REQUEST['username'] == "aluno" && $_REQUEST['password'] == "1q2w3e")
{
	echo "<h2> Usuário ". $_REQUEST['username'] . " logado </h2>";
} else {
	echo "<h3> Usuário ou senha inválidos</h3>";
}

?>