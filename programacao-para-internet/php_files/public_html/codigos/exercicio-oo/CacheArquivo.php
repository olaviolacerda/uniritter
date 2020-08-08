<?php 
include_once('cache.interface.php');

class CacheArquivo implements Cache {

    /**
     * {@inherit}
     */
    public function em_cache($id) {
        return file_exists('/tmp/cache_arquivo/'.strval($id));
    }

    /**
     * {@inherit}
     */
    public function set_valor($id, $valor) {
        if (!is_dir('/tmp/cache_arquivo')) {
             if (!mkdir('/tmp/cache_arquivo')) {
                 return false;
             }
        }

        // Se e' um valor: armazenar
        if (!is_null($valor)) {
            $arq = '/tmp/cache_arquivo/'.strval($id);
            $conteudo = serialize($valor);
            return file_put_contents($arq, $conteudo);

        // Se nao e' um valor: apagar
        } else {
            $arq = '/tmp/cache_arquivo/'.strval($id);
            return unlink($arq);
        }
    }


    /**
     * {@inherit}
     */
    public function get_valor($id) {
        if (!$this->em_cache($id)) {
            return null;
        }
        $conteudo = file_get_contents('/tmp/cache_arquivo/'.strval($id));
        $valor = unserialize($conteudo);
        return $valor;
    }
}