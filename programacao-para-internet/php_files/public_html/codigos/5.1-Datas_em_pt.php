<?php 

// set the default timezone to use. Available since PHP 5.1
date_default_timezone_set('UTC');

function getDiaSemana($data) {
    list($ano, $mes, $dia) = explode("-", $data);
 
    $diasemana = date("w", mktime(0, 0, 0, $mes, $dia, $ano));
 
    switch ($diasemana) {
        case 0: $diasemana = "Domingo";
            break;
        case 1: $diasemana = "Segunda-Feira";
            break;
        case 2: $diasemana = "Terça-Feira";
            break;
        case 3: $diasemana = "Quarta-Feira";
            break;
        case 4: $diasemana = "Quinta-Feira";
            break;
        case 5: $diasemana = "Sexta-Feira";
            break;
        case 6: $diasemana = "Sábado";
            break;
    }
 
    return $diasemana;
}

echo getDiaSemana('2016-08-22'); 

 ?>