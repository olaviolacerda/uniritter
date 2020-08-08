<?php
include_once('Banco.php');

class Usuario {
    private usuario;
    private senha;
    private perfil;
    
    function __construct($usuario, $senha){
        $this->usuario = $usuario;
        $this->senha = sha1($senha);
    }
    function logout(){
        setPerfil(null);
    }
    function login(){
        $userDB = new Banco();
        $userDB->executaQuery('select usuario,perfil where usuario=\"'. $this->usuario.'\" and senha=\"'. $this->senha.'\";');
        if($userDB->getResultado()){
            setPerfil($userDB->getResultado()['perfil']);
        } else {
            mylog('Erro ao autenticar');
        }
    }
    
    function setPerfil($perfil){
        $this->perfil($perfil);
    }
    function getPerfil(){
        return $this->perfil;
    }
    
 
    
}
?>