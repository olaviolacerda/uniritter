<?php

// $_REQUEST
// $_POST
// print_r($_POST);
if(isset($_POST)){
  foreach($_POST as $key => $value){
    echo "Campo:".$key ."  Valor:". $value."<br>";
  }
} else {
  echo "Não foi possivel tratar o form";
}
  
?>