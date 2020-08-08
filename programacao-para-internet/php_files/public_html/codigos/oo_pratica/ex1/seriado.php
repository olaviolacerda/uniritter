<?php
class Seriado extends Temporada{
    //private $temporadas;
    private $idiomas=array();
    private $nome;
    function __construct($nome){
        $this->nome = $nome;
    }
    function addIdioma($idioma){
        array_push($this->idiomas,$idioma);
    }
    function getIdiomas(){
        return $this->idiomas;
    }
    function 
    
}

?>