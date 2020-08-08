<?php
// ex 1 - Encontrar uma substring em uma string
// $minha_string = 'Meu nome é Sandro Javiel';
// $busca_string   = 'Javiel';
// $pos = strpos($minha_string, $busca_string);

// if($pos === false)
// 	echo "Não encontrei \"" . $busca_string."\".\r\n";
// else
// 	echo $pos."\r\n";

// // --------------------------------------------

// ex 2 - Substituir uma substring em uma string
//$busca_string   = 'Meu';

// $minha_string = str_replace("Javiel", "sobrenome", 'Meu nome é Sandro Javiel');

// // echo $trocar;

// echo "\n\r";
// echo $minha_string;
// echo "\n\r";

// // --------------------------------------------


// // ex 3 - Validar um email por regex
// $minha_string = "scjaviel@gmail.com";
// $padrao = '/(^[A-z].{1,10})@([A-z]{1,10}\.(com|org))$/';
// // $minha_string = "def";
// // $padrao = '/^def/';
// preg_match($padrao, $minha_string, $matches, PREG_OFFSET_CAPTURE);

// print_r($matches);
// echo "\n\r";

// // --------------------------------------------

// // ex 3 - Validar um video youtube por regex
// $minha_string = "http://www.youtube.com/watch?v=e8ih8YmWX5s";
// $minha_string = "https://youtu.be/e8ih8YmWX5s";

// $padrao = "/http(s)*:\/\/((www)*.youtube.com\/watch\?v=(.+)|youtu.be\/(.+))/";
// preg_match($padrao, $minha_string, $matches, PREG_OFFSET_CAPTURE);
// print_r($matches);
// echo "\n\r";
// // --------------------------------------------


// ex com replace
// $valor_bruto = "100.35";
// $valor_display = str_replace(".", ",", $valor_bruto);
// if(strpos("R$", $valor_display) === false)
// {
// 	$valor_display = "R$ ".$valor_display;
// }

// echo $valor_display;
// // --------------------------------------------

// // ex com explode
// $linha = "Nome;sobrenome_meio;sobrenome_fim;idade;email";
// $campos = explode(";", $linha);
// echo "<pre>";
// print_r($campos);
// echo "</pre>";

// ex com implode
//echo "<pre>";
//print_r($_SERVER);
//echo "</pre>";
// echo "\r\n";
$linha = implode("||", $_SERVER);

echo($linha);
// echo "\r\n";
// echo "\r\n";

// print_r($_SERVER["SCRIPT_NAME"]);

?>

