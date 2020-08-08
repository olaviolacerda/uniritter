<?php

$dados_alunos[] = array('nome' => 'João',  'grauA' => 7, 'grauB' => 8, 'media' => 7.5);
$dados_alunos[] = array('nome' => 'Pedro',  'grauA' => 4, 'grauB' => 9, 'media' => 7);
$dados_alunos[] = array('nome' => 'Marcela',  'grauA' => 9, 'grauB' => 4, 'media' => 5);
$dados_alunos[] = array('nome' => 'Roberto',  'grauA' => 6, 'grauB' => 6, 'media' => 6);

echo "<table border=\"1\">";
foreach ($dados_alunos as $key => $row) {
 	echo "<tr>";
    $nome[$key]  = $row['nome'];
    $grauA[$key]  = $row['grauA'];
    $grauB[$key]  = $row['grauB'];
    $media[$key] = $row['media'];
    echo "<td>".$nome[$key]."</td><td>".$grauA[$key]."</td><td>".$grauB[$key]."</td><td>".$media[$key]."</td>";
	echo "</tr>";
}
echo "</table>";
array_multisort($media, SORT_DESC, $grauA, SORT_DESC, $dados_alunos);

echo "<table border=\"1\">";
foreach ($dados_alunos as $key => $row) {
 	echo "<tr>";
    $nome[$key]  = $row['nome'];
    $grauA[$key]  = $row['grauA'];
    $grauB[$key]  = $row['grauB'];
    $media[$key] = $row['media'];
    echo "<td>".$nome[$key]."</td><td>".$grauA[$key]."</td><td>".$grauB[$key]."</td><td>".$media[$key]."</td>";
	echo "</tr>";
}
echo "</table>";
?>