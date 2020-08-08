<?php
class DB_MySQL implements DB{
  private $instancia;
  private $erro;
  private $resultado = array();
  private $connector;
  
  function __construct($host, $user, $passwd, $db ){
    $this->connector = new mysqli($host, $user, $passwd, $db);
  }
  function execute($query){
    $result = $this->connector->query($query);
    if($result){
      $this->resultado[0] = $this->connector->affected_rows;
      if(is_object($result)){
        // a query está relacionada a um select
        $this->resultado[1] = array();
        for($i = 0; $i < $this->resultado[0]; $i++ ){
          array_push($this->resultado[1], $result->fetch_array(MYSQLI_ASSOC));
        }
      } else {
        $this->resultado[1] = array();
      }
      return $this->resultado;
    } else {
      $this->erro = $this->connector->error;
      return $this->erro;
    }
  }
  
  function __destruct(){
    $this->connector->close();
  }
}
?>