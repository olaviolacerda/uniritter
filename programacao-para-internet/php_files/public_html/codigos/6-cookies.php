<?php

$int=3600*24;
echo time();
setcookie("aula_data","valor",time()+$int);


echo $_COOKIE["aula_data"];

echo "<br />";

//para matar o cookie
setcookie("aula_data","sasas",time()-10000);
echo $_COOKIE["aula_data"];
 
print_r($_COOKIE);

?>
