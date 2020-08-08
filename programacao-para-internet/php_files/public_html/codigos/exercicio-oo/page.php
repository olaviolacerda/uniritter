<?php 
include_once 'CacheArquivo.php';
include_once 'CacheSessao.php';

function guardar_valor(Cache $cache, $chave, $valor) {
    $cache->set_valor($chave, $valor);
}

function recuperar_valor(Cache $cache, $chave) {
    return $cache->get_valor($chave);
}

$cacheArquivo = new CacheArquivo();
$cacheSessao = new CacheSessao();

//echo date("F j, Y, g:i:s a");
$contato[] = (array('nome' => 'Joao Gonçalves', 'email' => 'joaoddfs@fsf.com'));
$contato[] = (array('nome' => 'Fabio Hoe', 'email' => 'fabiohoe@gmai.com'));

$dados_para_cache = array('contatos' => $contato);

$valor = json_encode($dados_para_cache);
$chave = md5(date("F j, Y, g:i a"));
guardar_valor($cacheArquivo, $chave, $valor);
guardar_valor($cacheSessao, $chave, $valor);

$estutura = recuperar_valor($cacheArquivo, $chave);

$data = json_decode($estutura, true);

foreach($data["contatos"] as $item)
{
	echo "<b>nome:</b>" . $item['nome'] . "  <b>email:</b> ". $item['email'] . " <br />";
}
