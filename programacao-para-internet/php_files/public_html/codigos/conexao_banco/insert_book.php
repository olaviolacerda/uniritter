<html>
<head>
  <title>Book-O-Rama</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>Inclusão</h1>
<?php
  include_once "common.inc.php";
  // create short variable names
  $isbn=$_POST['isbn'];
  $author=$_POST['author'];
  $title=$_POST['title'];
  $price=$_POST['price'];

  if (!$isbn || !$author || !$title || !$price)
  {
     echo 'Faltam campos.<br />'
          .'Preencha todos os campos.';
     exit;
  }
  
  $isbn = addslashes($isbn);
  $author = addslashes($author);
  $title = addslashes($title);
  $price = doubleval($price);

  $mysqli = new mysqli('localhost', 'root', '', 'books');

  if ($mysqli->connect_error) {
     echo 'Erro: Nao foi possivel conectar. '.$mysqli->connect_errno .
            $mysqli->connect_error;
     exit;
  }

  $result = $mysqli->query("insert into book (isbn, author, title, price) values 
            ('".$isbn."', '".$author."', '".$title."', '".$price."')"); 
  if ($result){
    echo "<br><br>Registros alterados: ". $mysqli->affected_rows;
  } else {
    die('Query inválida: ' . $mysqli->error);
  }
?>

</body>
</html>
