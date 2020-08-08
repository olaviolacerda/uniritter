<?php 

// ex1 - Retornando a soma e o isset
// function retornaSoma($arg1, $arg2 )
// {
// 	if (!isset($arg1) || !isset($arg2) )
// 		return "Não foi possível calcular a soma.";

// 	return $arg1 + $arg2."\r\n";
// }

// $arg1 = 100;
// $arg2 = 123.5666;
// $resultado = retornaSoma($arg1, $arg2);

// echo $resultado;

// //-----------------------------------

//ex2 - Escopo

// for($i = 0; $i < 10 ; $i++)
// {
// 	$a = 10;
// 	echo $a."<br>";
// 	echo $i."<br>";
// }
// echo "\n\rValor de a: ".$a."<br>";
// echo "Valor de i: ".$i."<br>";

// function($b=1)
// {
// 	echo "b dentro da function ".$b;
// }

// echo $b;
// //--------------------------------------



//ex3 passagem por referencia
function foo (&$var)
{
    $var++;
}

$a=5;
foo ($a);
// $a é 6 aqui

echo $a;
//echo $var;
// //--------------------------------------


// // ex4 - Retornando a soma e o isset
// function retornaSoma($arg1, $arg2 )
// {
// 	if (!isset($arg1) || !isset($arg2) )
// 		return "Não foi possível calcular a soma.";

// 	return $arg1 + $arg2."\r\n";
// }

// function retornaSoma($arg1, $arg2, $arg3 )
// {
// 	if (!isset($arg1) || !isset($arg2) )
// 		return "Não foi possível calcular a soma.";

// 	return $arg1 + $arg2."\r\n";
// }

// $arg1 = null;
// $arg2 = 123.5666;
// $resultado = retornaSoma($arg1, $arg2);

// echo $resultado;

// //-----------------------------------


// ex5 - Sobrecarga de métodos
class Foo {
   function myFoo() {
      return "Foo";
   }
}

class Bar extends Foo {
   function myFoo() {
      return "Bar";
   }
}

$foo = new Foo;
$bar = new Bar;
echo($foo->myFoo()); //"Foo"
echo "\r\n";
echo($bar->myFoo()); //"Bar"
echo "\r\n";


// //-----------------------------------

// // ex5 - Sobrecarga de métodos
// class Foo {
//    function myFoo() {
//       return "Foo";
//    }
// }

// class Bar extends Foo {
//    function myBar() {
//       return "Bar";
//    }
// }

// $foo = new Foo;
// $bar = new Bar;
// //echo($foo->myFoo()); //"Foo"
// echo "\r\n";
// echo($bar->myBar()); //"Bar"
// echo($bar->myFoo()); //"Bar"
// echo "\r\n";


//-----------------------------------

?>