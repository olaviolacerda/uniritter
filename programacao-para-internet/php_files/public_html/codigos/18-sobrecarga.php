<?php
/*
* Retirado do artigo de 
* http://imasters.com.br/artigo/5350/php/simulando-sobrecarga-de-metodos-no-php/
*
*/
class Teste 
{
    function insertUser() 
   {
        // obtém o número de parâmetros passados à função
        $numParametros = func_num_args();
		
        // toma decisões baseando-se no número de parâmetros
        if ($numParametros == 1) 
        {
            // se for apenas um parâmetro, espera-se que o mesmo seja
            // um array com as informações do usuário
            
            // obtém o primeiro parâmetro
            $user = func_get_arg(0);
            
           // verifica se o primeiro parâmetro é realmente um array
            if (is_array($user)) 
            {
                // aqui você deve inserir um tratamento no array
                // para verificar se os campos necessários
                // foram passados (id, nome e email)
                
                // insere usuário no sistema
                echo "Usuário inserido com sucesso.<br/>";
                echo "ID: " . $user["id"] . "<br/>";
                echo "NOME: " . $user["nome"] . "<br/>";
                echo "EMAIL: " . $user["email"] . "<br/>";
            }    
             else 
            {    
                // gera um erro se não for um array
                echo "Parâmetro passado não é um array: " . $user . ".<br/>";
            }   
            
        } else if ($numParametros == 3) 
        {
            // caso a função receba 3 parâmetros, supõe-se
            // que eles sejam 'id', 'nome' e 'email' respectivamente
            
            // insere usuário no sistema
            echo "Usuário inserido com sucesso.<br/>";
            echo "ID: " . func_get_arg(0) . "<br/>";
            echo "NOME: " . func_get_arg(1) . "<br/>";
            echo "EMAIL: " . func_get_arg(2) . "<br/>";
        } else 
        {
            
            // se o número de parâmetros for diferente de
            // 1 e 3, um erro é gerado.
            
            echo "Quantidade de parâmetros incorreta.<br/>";
            echo "Parâmetros recebidos: " . func_num_args();
            
        }
    
    }
}

// crio um objeto da classe Teste
$objTeste = new Teste();

// insiro um usuário passando um array com todos os dados
$objTeste->insertUser(array("id" => 1, "nome" => "Pedro Padron", "email" => "padronaaargh.com.br"));

echo "<br/>";

// insiro um usuário fornecendo cada atributo como um parâmetro
$objTeste->insertUser(2, "George W. Bush", "jackasswhitehouse.gov");

echo "<br/>";

// isso gerará um erro, pois foram passados apenas dois parâmetros
$objTeste->insertUser(2, "Tony Blair");


?>