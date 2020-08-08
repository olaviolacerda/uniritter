<?php

include('m2brimagem.class.php');

function troca_nome($nome, $tipo){
	$tipo_errado = substr("{$nome}", strpos("{$nome}", ".") + 1);  
	$nome_certo = str_replace("{$tipo_errado}","{$tipo}","{$nome}");	
	rename($nome, $nome_certo);
}

function verifica_tipo($image) {
	
	$tipo = substr("{$image}", strpos("{$image}", ".") + 1);  
	

	switch (exif_imagetype("{$image}")) {
    case 1:
		if(strcmp($tipo,"gif") != 0){
			troca_nome($image, "gif");
		}
        break;
    case 2:
        if(strcmp($tipo, "jpeg") != 0 && strcmp($tipo,"jpg") != 0){
			troca_nome($image, "jpg");
		}
        break;
	case 3:
       if(strcmp($tipo,"png") != 0){
			troca_nome($image, "png");
		}
        break;
}
	
}


function redimensiona_imagem($imagem){
	list($width, $height) = getimagesize($imagem);
	$nova_imagem = new m2brimagem($imagem);
	$nova_imagem->redimensiona(400, $height);
	$nova_imagem->grava($imagem);
}

function mostra_tamanho($imagem){
	$tamanho = filesize($imagem) / 1024;
	$tamanho = round($tamanho, 1);
	echo "A {$imagem} tem tamanho: {$tamanho}kb.<br />";
}

$imagem1 = "image1.gif";
$imagem2 = "image2.png";
$imagem3 = "image3.png";
$imagem4 = "image4.jpg";
$imagem5 = "image5.jpeg";

verifica_tipo($imagem1);
verifica_tipo($imagem2);
verifica_tipo($imagem3);
verifica_tipo($imagem4);
verifica_tipo($imagem5);
echo "Tamanho antes<br />";
mostra_tamanho($imagem1);
mostra_tamanho($imagem2);
mostra_tamanho($imagem3);
mostra_tamanho($imagem4);
mostra_tamanho($imagem5);

redimensiona_imagem($imagem1);
redimensiona_imagem($imagem2);
redimensiona_imagem($imagem3);
redimensiona_imagem($imagem4);
redimensiona_imagem($imagem5);
echo "Tamanho depois<br />";
mostra_tamanho($imagem1);
mostra_tamanho($imagem2);
mostra_tamanho($imagem3);
mostra_tamanho($imagem4);
mostra_tamanho($imagem5);
?>