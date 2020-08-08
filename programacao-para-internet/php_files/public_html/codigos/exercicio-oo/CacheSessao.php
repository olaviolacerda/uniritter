<?php
include_once('cache.interface.php');

class CacheSessao implements Cache {

    /**
     * Inicializa a sessao, caso nao tenha sido inicializada
     * @return void
     */
    private function iniciar_sessao() {
        if (!session_id()) {
            session_start();
        }
    }

    /**
     * {@inherit}
     */
    public function em_cache($id) {
        $this->iniciar_sessao();
        return array_key_exists(strval($id), $_SESSION['cache_sessao']);
    }

    /**
     * {@inherit}
     */
    public function set_valor($id, $valor) {
        $this->iniciar_sessao();

        // Se e' um valor: armazenar
        if (!is_null($valor)) {
            $conteudo = serialize($valor);
            $_SESSION['cache_sessao'][strval($id)] = $conteudo;
            return array_key_exists(strval($id), $_SESSION['cache_sessao']);

        // Se nao e' um valor: apagar
        } else {
            unset($_SESSION['cache_sessao'][strval($id)]);
            return !array_key_exists($_SESSION['cache_sessao'][strval($id)]);
        }
    }


    /**
     * {@inherit}
     */
    public function get_valor($id) {
        $this->iniciar_sessao();
        if (!$this->em_cache($id)) {
            return null;
        }
        $conteudo = $_SESSION['cache_sessao'][strval($id)];
        $valor = unserialize($conteudo);
        return $valor;
    }
}