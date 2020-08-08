<?php 
include_once 'CacheArquivo.php';
include_once 'CacheSessao.php';
require_once('show.php');

function guardar_valor(Cache $cache, $chave, $valor) {
    $cache->set_valor($chave, $valor);
}

function recuperar_valor(Cache $cache, $chave) {
    return $cache->get_valor($chave);
}


function salvarArquivo($dados_para_cache, $chave,  $cacheArquivo, $cacheSessao){
  $valor = json_encode($dados_para_cache);
  guardar_valor($cacheArquivo, $chave, $valor);
  guardar_valor($cacheSessao, $chave, $valor);
   echo "Salvo!<br />";
}



function addSerie($seriesName, $chaveArquivo,  $cacheArquivo, $cacheSessao){

  $chave = md5($chaveArquivo);
  $estutura = recuperar_valor($cacheArquivo, $chave);
  $data = json_decode($estutura, true);
  $repetido = false;
  if(count($data) == 0){
      $serie = new Show($seriesName);
      $data[] = (array('serie' => $serie));
      $dados_para_cache = array('series' => $data);
      salvarArquivo($dados_para_cache,$chave,$cacheArquivo,$cacheSessao);
    }
    else {
       foreach($data["series"] as $item)
       {
         if (strcmp( $item["serie"]["name"],$seriesName) == 0 ){
            $repetido = true;
         }
       }
      if($repetido == true ){
         
      } else {
        
       
        $serie = new Show($seriesName);
           array_push($data['series'], array('serie' => $serie) );
          $dados_para_cache = array('series' => $data['series']);
        salvarArquivo($dados_para_cache,$chave,$cacheArquivo,$cacheSessao);
      }
    }

  
}

function addSerie2($seriesName,$temp, $ep, $chaveArquivo,  $cacheArquivo, $cacheSessao){

  $chave = md5($chaveArquivo);
  $estutura = recuperar_valor($cacheArquivo, $chave);
  $data = json_decode($estutura, true);
  $repetido = false;
  if(count($data) == 0){
      $serie = new Show($seriesName);
      $serie->season = $temp;
      $serie->episode = $ep;
      $data[] = (array('serie' => $serie));
      $dados_para_cache = array('series' => $data);
      salvarArquivo($dados_para_cache,$chave,$cacheArquivo,$cacheSessao);
    }
    else {
       foreach($data["series"] as $key=>$item)
       {
         
         if (strcmp( $item["serie"]["name"],$seriesName) == 0 ){
          
           $data["series"][$key]["serie"]["season"] = $temp; 
            $data["series"][$key]["serie"]["episode"] = $ep;
            $dados_para_cache = array('series' => $data['series']);
        salvarArquivo($dados_para_cache,$chave,$cacheArquivo,$cacheSessao);
           return 0;
         }
       }
     
        
       
        $serie = new Show($seriesName);
       $serie->season = $temp;
      $serie->episode = $ep;
           array_push($data['series'], array('serie' => $serie) );
          $dados_para_cache = array('series' => $data['series']);
        salvarArquivo($dados_para_cache,$chave,$cacheArquivo,$cacheSessao);
    }

  
}



function showSeries($chaveArquivo,  $cacheArquivo, $cacheSessao){
   $chave = md5($chaveArquivo);
  $estutura = recuperar_valor($cacheArquivo, $chave);
  $data = json_decode($estutura, true);
  return $data;
}




