<?php 

$valor= 1000;

for($i = 1; $i <= 36; $i++)
{
	$valor = $valor * 1.125;
	 
	echo "<br/>Valor no mês ".$i.": R$ ".round($valor, 2);

}

echo "<br/>Valor final: R$ ".round($valor, 2);
?>
