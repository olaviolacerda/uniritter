<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
</html>

<body>

<?php
require_once('seriado.php');
require_once('head.php');

$seriado = new Seriado('Shadow Hunter', 'Caçador das sombras');
$seriado->addTemporada(1,'Caçador de ossos');
$seriado->addEpisodio(1, 1, 'Piloto', 48.4, 'bla bla bla 1');
$seriado->addEpisodio(1, 2, 'Um novo episódio', 49.1, 'bla bla bla 2');

$seriado->addTemporada(2,'Moedor de carne');
$seriado->addEpisodio(2, 1, 'Assassino 1', 48.4, 'bla bla bla 1');
$seriado->addEpisodio(2, 2, 'Assassino 2', 49.1, 'bla bla bla 2');
$seriado->addEpisodio(2, 2, 'Assassino 3 ', 49.1, 'bla bla bla 2');

$mrrobot = new Seriado('Mr Robot', 'Hacker que trabalha numa empresa e investiga todos a sua volta');
$mrrobot->addTemporada(1,'Anything');
$mrrobot->addEpisodio(1, 1, 'Piloto', 48.4, 'bla bla bla 1');
$mrrobot->addEpisodio(1, 2, 'Um novo episódio', 49.1, 'bla bla bla 2');

$listaSeriados = array();
array_push($listaSeriados, $seriado);
array_push($listaSeriados, $mrrobot);
?>

<table width='400' border='1'>
<tr><td>Série</td><td>Número de temporadas</td></tr>
<?php
for($i=0; $i< count($listaSeriados); $i++ ){
    echo "<tr><td>".$listaSeriados[$i]->getNomeSeriado() ."</td><td>". $listaSeriados[$i]->getNumeroTemporadas()."</td></tr>";
}

?>
</body>