<?php

$name = 'arquivo.txt';
$file = fopen($name, 'a+');
$lista = ['12','66'];
for($i = 0; $i < count($lista); $i++ ){
  $value[0] ."|".$value[1]."|".$value[2];  
    
  fputs($file, $lista[$i]);
}

foreach($lista as $value){
  fputs($file, $value);
}

fclose($file);




$leitura_arquivo = fopen($name, 'r');
if ($leitura_arquivo) {
    while (!feof($leitura_arquivo)) {
        $buffer = fgets($leitura_arquivo, 4096);
        echo $buffer;
    }
    fclose($leitura_arquivo);
}

?> 