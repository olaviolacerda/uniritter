<?php
include('seriado.php');
    
$serie = new Seriado('Suits');
$serie->addIdioma('portugues br');
print_r($serie->getIdiomas());
?>