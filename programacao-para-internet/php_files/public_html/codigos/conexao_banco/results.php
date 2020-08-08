<html>
<head>
  <title>Book-O-Rama</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  
</head>
<body>
<h1>Listagem</h1>
<?php
  include_once "common.inc.php";
  $searchtype=(isset($_POST['searchtype']) ? $_POST['searchtype'] : '');
  $searchterm=(isset($_POST['searchterm']) ? $_POST['searchterm'] : '');
  $searchterm= trim($searchterm);
  $searchtype = addslashes($searchtype);
  $searchterm = addslashes($searchterm);
  $mysqli = new mysqli('localhost', 'root', '', 'books');

  if ($mysqli->connect_error) {
     echo 'Erro: Nao foi possivel conectar. '.$mysqli->connect_errno .
            $mysqli->connect_error;
     exit;
  }
  if(!empty($searchterm)){
    echo "<br>Busca<br>";
    $result = $mysqli->query("select * from book where ".$searchtype." like '%".$searchterm."%'");
    $num_rows = $mysqli->affected_rows;
  } else {
    $result = $mysqli->query("select * from book");
    $num_rows = $mysqli->affected_rows;
  }
  if($result){
    echo '<p>Numero de livros: '.$num_rows.'</p>';

    for ($i=0; $i <$num_rows; $i++)
    {
       $row = $result->fetch_array(MYSQLI_ASSOC);
       echo '<p><strong><a href="remove.php?id='.$row['id'].'"'.($i+1).'. Title: ';
       echo "<span class='glyphicon glyphicon-trash' aria-hidden='true'></span></a><br>";
       echo htmlspecialchars(stripslashes($row['title']));
       echo '</strong><br />Author: ';
       echo stripslashes($row['author']);
       echo '<br />ISBN: ';
       echo stripslashes($row['isbn']);
       echo '<br />Price: ';
       echo stripslashes($row['price']);
       echo '</p>';
    }
    $mysqli->close();

  } else {
    echo '<p>Sem livros na base</p>';
  }
  
?>

</body>
</html>