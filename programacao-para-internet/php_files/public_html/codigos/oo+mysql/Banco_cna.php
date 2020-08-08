<?php


class Banco {
    private $host = localhost;
    private $db;
    //private $query;
    private $connected = FALSE;
    private $pointer;
    private $resultado;
    
    function __construct($host, $user, $pwd ){
        $db = mysql_connect($host, $user, $pwd);
    
        if (!$db)
        {
            mylog('Não consegui conectar');
        } else {
            mylog('Estou Conectado!!<br />');
            setConnection(TRUE, $db);
        }
        
    }
    private function setConnection($status, $db){
        $this->connected = $status;
        $this->pointer = $db;
    }
    
    function executaQuery($query,$type = 'select'){

        mysql_select_db($this->db);    
        $resultado=mysql_query($query);
        if(!$resultado) {
            if($GLOBALS["is_dev"]) {
                mylog('Falha na execução<br /><b>'.$query.'</b>');
                mylog('<b>'.mysql_error().'</b>'); 
            } else {
                echo "Ocorreu um erro. Contate o administrador.";
            }
            exit();
        } else {
            mylog('Sucesso na query:'. $query);
        }   
        setResultado($resultado);
    }
    function getResultado(){
        return $this->resultado;
    }
    
    function setResultado($resultado){
        $this->resultado = $resultado;    
    }
    
}
@ $db = mysql_connect('localhost', 'root', '1q2w3e');

if (!$db)
{
 echo 'Não consegui conectar';
 exit;
} else {
  echo 'Conectado!!<br />';
}

if(mysql_select_db('nova_base', $db)){
    echo "Achei a base <br />";
}


$query_alteracao = "update seriado set sinopse=\"Elliot (Rami Malek) é um jovem\" where seriado.id=1;";
//echo 'query:'.$query_alteracao;
$resultado_query = mysql_query($query_alteracao, $db);
$linhas = mysql_affected_rows();
if($resultado_query != true){
    echo 'Erro na query '. mysql_error();
}

$query = "select * from seriado";
$resultado = mysql_query($query);
echo "<pre>";
print_r($resultado);
echo "</pre><br />";

$num_resultado = mysql_num_rows($resultado);
echo "linhas:".$num_resultado;


for ($i=0; $i <$num_resultado; $i++)
{   
     
    $row = mysql_fetch_array($resultado);
    $titulo = $row['titulo'];
    $sinopse = $row['sinopse'];
    echo "<h3>".$titulo."</h3><h3>".$sinopse."</h3><br />";

}
?>
</body>