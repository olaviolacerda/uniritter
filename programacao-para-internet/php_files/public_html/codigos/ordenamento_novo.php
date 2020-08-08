<?php
// http://localhost/dashboard/php_files/public_html/codigos/ordenamento_novo.php?nome=olavio usar isso na url, claro, usando xampson
if(isset($_GET['nome'])){
	$ordenamento_nome = $_GET['nome'];
echo 'metodo 1: '.$ordenamento_nome."</br>";
}

$ordenamento_nome = (isset($_GET['nome'])? $_GET['nome']: '');
echo 'metodo 2: '.$ordenamento_nome;
?>