<?php 

//ex4 array multidimensional ordenação por diferentes colunas

$dados_alunos[] = array('nome' => 'João',  'nota' => 67, 'faltas' => 2);
$dados_alunos[] = array('nome' => 'Marcos', 'nota' => 86, 'faltas' => 1);
$dados_alunos[] = array('nome' => 'Ana', 'nota' => 85, 'faltas' => 6);
$dados_alunos[] = array('nome' => 'Gustavo', 'nota' => 98, 'faltas' => 2);
$dados_alunos[] = array('nome' => 'Marcelo', 'nota' => 100, 'faltas' => 6);
$dados_alunos[] = array('nome' => 'Carlos', 'nota' => 55, 'faltas' => 7);

foreach ($dados_alunos as $key => $row) {
    $nome[$key]  = $row['nome'];
    $nota[$key]  = $row['nota'];
    $faltas[$key] = $row['faltas'];
}


function sort_my_array($arr, $field, $direction)
{
	array_multisort($field, $direction, $arr);
	return $arr;

}

// print_r($_GET['ordena']);
if(isset($_GET['ordena']) )
{
	if(isset($_GET['direcao'])&& $_GET['direcao'] == 'desc' ){
		$direction = SORT_DESC;
	} else {
		$direction = SORT_ASC;
	}
	switch ($_GET['ordena']) {
		case 'nome':
			$dados_alunos = sort_my_array($dados_alunos,$nome,$direction);
			break;
		case 'nota':
			$dados_alunos = sort_my_array($dados_alunos,$nota,$direction);
			break;
		case 'faltas':
			$dados_alunos = sort_my_array($dados_alunos,$faltas,$direction);
			break;
		
		default:
			# code...
			break;
	}
} 
$link_direction = '';
if(isset($_GET['direcao']) && $_GET['direcao'] == 'desc'){
	$link_direction = '&direcao=asc';
} else {
	$link_direction = '&direcao=desc';
}
echo $link_direction;
echo "<br />";
echo "<table width='400' border='1'>";
echo "<tr>";
echo "<td><a href='10-arrays_links_get.php?ordena=nome".$link_direction."'>Nome</a></td>";
echo "<td><a href='10-arrays_links_get.php?ordena=nota".$link_direction."'>Nota</a></td>";
echo "<td><a href='10-arrays_links_get.php?ordena=faltas".$link_direction."'>Faltas</a></td>";
echo "</tr>";

// Obtemos uma lista de colunas


foreach ($dados_alunos as $key => $row) {
    $nome[$key]  = $row['nome'];
    $nota[$key]  = $row['nota'];
    $faltas[$key] = $row['faltas'];
    echo "<td>".$nome[$key]."</td><td>".$nota[$key]."</td><td>".$faltas[$key]."</td>";
	echo "<tr>";
}
echo "</table>";


?>
