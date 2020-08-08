<?php

/*
Prós:
Se temos uma variável que necessita ser utilizada através de diversas páginas e 
arquivos, pode ser interessante utilizá-la como parte da sessão, ao invés de passar como variável em um get ou post na 
QueryString.

Variáveis de sessão permitem a customização de variáveis. Cada usuário tem pode ter uma experiência customizada. 
É verdade que podemos também armazenar com outros mecanismos como cache em disco, cache em memória, no navegador, etc. 

Uma característica importante é que não temos a necessidade de 'liberar' aquelas variáveis de sessão quando
não mais são utilizadas. 

Contras:
Variáveis de sessão e cookies são muito parecidas na maneira de utilizar. Se um usuário configurar seu navegador
para não aceitar cookies, isso acabará impossibilitando o uso de sessão do php. 

O tempo de expiração da sessão é 20 minutos por padrão depois que o usuário deixa o site. 
As variáveis persistem até esta expiração. Este timout é customizável pelo web server admin. 

Com o aumento do número de usuários, seu servidor terá a experiência dramática de perda de performance se forem utilizados
muitos objetos de sessão. 

*/

//ex1 - criando sessões e utilizando as variáveis
session_start();

echo 'Página #1';

$_SESSION['favcolor'] = 'verde';
$_SESSION['animal']   = 'gatos';
$_SESSION['time']     = time();

// Or maybe pass along the session id, if needed
echo '<br /><a href="16-sessao2.php?' . SID . '">page 2</a>';


// unset($_SESSION['favcolor']);
// print_r($_SESSION[session_id()]);
//print_r($_COOKIE);


// Session variables are stored in the global variable $_SESSION

foreach($_SESSION as $key => $value) 
{ 
    echo $key . " = " . $value . "<br>"; 
}


session_destroy();




//ex2

// session_name('UnR');
// session_start();

// echo 'Página #1';

// $_SESSION['favcolor'] = 'verde';
// $_SESSION['animal']   = 'gatos';
// $_SESSION['time']     = time();

// // Works if session cookie was accepted
// echo '<br /><a href="page2.php">page 2</a>';

// // Or maybe pass along the session id, if needed
// echo '<br /><a href="page2.php?' . SID . '">page 2</a>';

// // unset($_SESSION['favcolor']);
// // print_r($_SESSION[session_id()]);
// print_r($_COOKIE);


// // Session variables are stored in the global variable $_SESSION

// foreach($_SESSION as $key => $value) 
// { 
//     echo $key . " = " . $value . "<br>"; 
// }


// session_destroy();

?>
