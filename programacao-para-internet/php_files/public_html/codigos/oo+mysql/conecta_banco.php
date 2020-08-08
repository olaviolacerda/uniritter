<?php
$is_dev = TRUE;
function mylog($message){
    if($GLOBALS["is_dev"]){
        echo $message . "<br />";
    }
}
function conectaBanco($host=localhost, $user='root', $pwd='1q2w3e' ){
    $db = mysql_connect($host, $user, $pwd);
    
    if (!$db)
    {
        mylog('Não consegui conectar');
        return null;
    } else {
        mylog('Estou Conectado!!<br />');
        return $db;
    }
    
}
function execQuery($query, $db, $type='select'){
    mysql_select_db($db);    
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
    if($type == 'select'){
        return $resultado;
    }

}
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
</html>

<body>




</body>
<?php
$myDb = conectaBanco();
if($myDb){
    $query = ("update seriado set sinopse=\"Elliot (Rami Malek) é um jovem\" where seriado.id=1;");
    execQuery($query,'nova_base', 'update');
    
    $query = "select * from seriado";
    $resultado = execQuery($query,'nova_base');
    $linhas = mysql_num_rows($resultado);
    mylog("Linhas:".$linhas);
    for ($i=0; $i <$linhas; $i++)
    {   
         
        $row = mysql_fetch_array($resultado);
        $titulo = $row['titulo'];
        $sinopse = $row['sinopse'];
        echo "<h3>".$titulo."</h3><h3>".$sinopse."</h3><br />";
    
    }

}

?>
</body>