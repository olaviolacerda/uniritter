<?php
// $content = json_encode($_SERVER);
echo "dsdsdsd";
$name = 'C:\Users\SandroJaviel\Documents\UniServerZ\www\codigos\log.txt';
$text = ' - Erro: dsfsdfsdfsd sd dfsf s';
$file = fopen($name, 'a');
fwrite($file, date("d/m/Y H:i:s");
($text);
fclose($file);

// $file = "arquivo.txt";

// //$f=file_put_contents($file, $content); // (PHP 5)

// echo "<br />";
// $handle = fopen("arquivo.txt", "w");
// if ($handle) {
//     while (!feof($handle)) {
//         $buffer = fgets($handle, 4096);
//         echo $buffer;
//     }
//     fclose($handle);
// }
// echo "<br />";
// $file = "/tmp/arquivo.txt";
// $handle = fopen($file, "r");
// $linha = 0; 
// if ($handle) {
//     while (!feof($handle)) {
//         $buffer = fgets($handle, 4096);
//         echo "linha".$linha;
//         $linha++;
//         echo htmlentities($buffer);
//     }
//     fclose($handle);
// }

?> 