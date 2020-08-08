<?php
require_once('episodio.php');
class Temporada {
    
    private $listaEpisodios = array();
    private $id_temporada;
    private $id_seriado;
    private $sinopse;
    
    function __construct($id_seriado, $id_temporada,$sinopse){
        $this->id_seriado = $id_seriado;
        $this->id_temporada = $id_temporada;
        $this->sinopse = $sinopse;
    }
    
    public function addEpisodio($ordem, $titulo, $duracao, $sinopse){
        array_push($this->listaEpisodios, new Episodio($this->id_seriado, $this->id_temporada, $ordem, $titulo, $duracao, $sinopse));
    }
    
    public function getEpisodios(){
        return $this->listaEpisodios;
    }
    
}