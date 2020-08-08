<?php
$nome = strtoupper($_POST['nome']);
if(strlen($nome)> 30){
  echo "Excedeu o limite de caracteres";
} else {
  $pattern = "/([A-Z]+( )*)+/";
  if(preg_match($pattern, $nome, $matches)){
    print_r($matches);
    echo "Nome passou";
  }
}

?>