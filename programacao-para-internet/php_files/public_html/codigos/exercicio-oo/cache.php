<?php
interface Cache {

    /**
     * Indica se uma informacao esta guardada em cache
     * @param mixed $id Identificador da informacao
     * @return bool
     */
    public function em_cache($id);

    /**
     * Armazena uma informacao em cache, rotulado com um identificador.
     * Passando NULL como valor, o valor e' apagado.
     * @param mixed $id Identificador da informacao
     * @param mixed $valor Valor a ser armazenado
     * @return bool
     */
    public function set_valor($id, $valor);


    /**
     * Obtem uma informacao da cache atraves de um identificador
     * @param mixed $id Identificador da informacao
     * @return mixed
     */
    public function get_valor($id);
}