<?php 
echo "A referência para strings: <a href='http://php.net/manual/en/ref.strings.php'>http://php.net/manual/en/ref.strings.php </a>";
echo "<br />";

$frase = "Esta frase servirá para teste apenas";
echo $frase;
echo "<br />";

echo "<h2>Função substr </h2>";
echo "<br />";
echo "Pegando os 10 primeiros caracteres:<b>".substr($frase, 10)."</b>";
echo "<br />";
echo "Pegando os 5 caracteres a partir do começo:<b>".substr($frase, 0, 5)."</b>";
echo "<br />";

echo "<h2>Função explode </h2>";
echo "<br />";
$conjunto = explode(" ", $frase);
print_r($conjunto);
echo "O objeto json guarda todas as palavras neste exemplo ".json_encode($conjunto) ;
echo "<br />";
echo "Na saida abaixo, o valor bruto do array:";
print_r($conjunto);
echo "<br />";

echo "<h2>Função Strlen </h2>";
echo "<br />";
echo "O tamanho da string <b>".$frase ." </b> é ".strlen($frase) ;
echo "<br />";
?>
