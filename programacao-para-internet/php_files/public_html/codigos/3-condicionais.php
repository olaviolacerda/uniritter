<?php 
$numero_inteiro = 123;
$numero_decimal = 7.34;
$array = ["abc", "aaaaass"];
$string_exemplo = "Testando";

if(is_int($numero_inteiro))
	echo $numero_inteiro. " é inteiro.";
elseif (is_double($numero_inteiro)) 
	echo $numero_inteiro . " é decimal";
elseif (is_string($numero_inteiro)) 
	echo $numero_inteiro . " é string";
elseif (is_array($numero_inteiro)) 
	print_r($numero_inteiro);

echo "<br />";

if(is_int($numero_decimal))
	echo $numero_inteiro. " é inteiro.";
elseif (is_float($numero_decimal)) 
	echo $numero_decimal . " é decimal";
elseif (is_string($numero_decimal)) 
	echo $numero_decimal . " é string";
elseif (is_array($numero_decimal)) 
	print_r($numero_decimal);

echo "<br />";

if(is_int($array))
	print_r($numero_inteiro. " é inteiro.");
elseif (is_double($array)) 
	echo $array . " é decimal";
elseif (is_string($array)) 
	echo $array . " é string";
elseif (is_array($array)) 
	print_r($array);

echo "<br />";

if(is_int($string_exemplo))
	print_r($string_exemplo. " é inteiro.");
elseif (is_double($string_exemplo)) 
	echo $string_exemplo . " é decimal";
elseif (is_string($string_exemplo)) 
	echo $string_exemplo . " é string";
elseif (is_string_exemplo($string_exemplo)) 
	print_r($string_exemplo);

echo "<br />";

?>