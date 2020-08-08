<?php
class Episodio{
    private $titulo;
    private $duracao;
    private $sinopse;
    private $ordem;
    private $id_temporada;
    private $id_seriado;
    
    function __construct($id_seriado, $id_temporada, $ordem, $titulo, $duracao, $sinopse){
        $this->id_seriado = $id_seriado;
        $this->id_temporada = $id_temporada;
        $this->ordem = $ordem;
        $this->titulo = $titulo;
        $this->duracao = $duracao;
        $this->sinopse = $sinopse;
    }
    function getInfoEpisodio(){
        return array($this->ordem, $this->titulo, $this->duracao, $this->sinopse);
    }
}
?>