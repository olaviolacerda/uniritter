<?php
//Classe Seriado
require_once('temporada.php');
class Seriado {
    private $temporadas = array();
    private $nome;
    private $id;
    private $sinopse;  
    
        
    function __construct($nome, $sinopse){
        $this->nome = $nome;
        $this->sinopse = $sinopse;
        $this->id = sha1(time());
        
    }
    public function addTemporada($id_temporada, $sinopse){
        array_push($this->temporadas, new Temporada($this->id, $id_temporada, $sinopse));
    }
    public function getNomeSeriado(){
        return $this->nome;
    }
    public function getNumeroTemporadas(){
        return count($this->temporadas);
    }
    function addEpisodio($numero_temporada, $ordem, $titulo, $duracao, $sinopse){
        $this->temporadas[$numero_temporada-1]->addEpisodio($ordem, $titulo, $duracao, $sinopse);
    }
    function getTemporadas(){
        return $this->temporadas;
    }
    function getEpisodios($id_temporada){
        return $this->temporadas[$id_temporada-1]->getEpisodios();
    }


}

?>