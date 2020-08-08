<?php
$user = (isset($_GET['usuario']) ? $_GET['usuario'] : '');
$seriado = (isset($_GET['seriado']) ? $_GET['seriado'] : '');
$temporada = (isset($_GET['temporada']) ? $_GET['temporada'] : '');
$episodio = (isset($_GET['episodio']) ? $_GET['episodio'] : '');

  $dado = array($user => array(
      array( $seriado, $temporada, $episodio),
    ));

echo '<pre>';
print_r($dado);
print_r($dado['sjaviel']);

echo '</pre>';

?>