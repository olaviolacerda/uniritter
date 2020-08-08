<html>
<head>
	<title>Páginas dinâmicas</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<a href="15-html_dinamico_com_arrays.php">Inicio</a>
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


function sort_my_array($arr, $order, $field)
{
	if($order === "ASC" )
		array_multisort($field, SORT_ASC, $arr);
	elseif($order === "DESC")
		array_multisort($field, SORT_DESC, $arr);
	return $arr;

}

// print_r($_GET['ordena']);
if(isset($_GET['ordena']))
{
	switch ($_GET['ordena']) {
		case 'nome-down':
			$dados_alunos = sort_my_array($dados_alunos,"ASC",$nome);
			break;
		case 'nome-up':
			$dados_alunos = sort_my_array($dados_alunos,"DESC",$nome);
			break;
		case 'nota-down':
			$dados_alunos = sort_my_array($dados_alunos,"ASC",$nota);
			break;
		case 'nota-up':
			$dados_alunos = sort_my_array($dados_alunos,"DESC",$nota);
			break;
		case 'faltas-down':
			$dados_alunos = sort_my_array($dados_alunos,"ASC",$faltas);
			break;
		case 'faltas-up':
			$dados_alunos = sort_my_array($dados_alunos,"DESC",$faltas);
			break;
		
		default:
			# code...
			break;
	}
} 

echo "<br />";
echo "<table width='400' border='1'>";
echo "<tr>";

echo "<td><a href='15-html_dinamico_com_arrays.php?";
if(!isset($_REQUEST['ordena']) || ($_REQUEST['ordena'] != 'nome-up' && $_REQUEST['ordena'] != 'nome-down'   ))
{
	echo "ordena=nome-down'><span class='table-links'>Nome</span><span class='no-icon'>";
} else {
	if(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='nome-up')
	{
	echo "ordena=nome-down'><span class='table-links'>Nome</span><span class='down-icon'>";
	} elseif(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='nome-down') {
	echo "ordena=nome-up'><span class='table-links'>Nome</span><span class='up-icon'>";
	}
}
echo "</span></a></td>";

echo "<td><a href='15-html_dinamico_com_arrays.php?";
if(!isset($_REQUEST['ordena']) || ($_REQUEST['ordena'] != 'nota-up' && $_REQUEST['ordena'] != 'nota-down'   ))
{
	echo "ordena=nota-down'><span class='table-links'>Nota</span><span class='no-icon'>";
} else {
	if(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='nota-up')
	{
	echo "ordena=nota-down'><span class='table-links'>Nota</span><span class='down-icon'>";
	} elseif(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='nota-down') {
	echo "ordena=nota-up'><span class='table-links'>Nota</span><span class='up-icon'>";
	}
}
echo "</span></a></td>";

echo "<td><a href='15-html_dinamico_com_arrays.php?";
if(!isset($_REQUEST['ordena']) || ($_REQUEST['ordena'] != 'faltas-up' && $_REQUEST['ordena'] != 'faltas-down'   ))
{
	echo "ordena=faltas-down'><span class='table-links'>Faltas</span><span class='no-icon'>";
} else {
	if(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='faltas-up')
	{
	echo "ordena=faltas-down'><span class='table-links'>Faltas</span><span class='down-icon'>";
	} elseif(isset($_REQUEST['ordena']) && $_REQUEST['ordena'] =='faltas-down') {
	echo "ordena=faltas-up'><span class='table-links'>Faltas</span><span class='up-icon'>";
	}
}
echo "</span></a></td>";
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
</body>
</html>