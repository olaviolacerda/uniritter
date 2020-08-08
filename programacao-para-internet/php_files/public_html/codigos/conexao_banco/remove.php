<html>
<head>
  <title>Book-O-Rama</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>Remoção</h1>
<?php 
include_once "common.inc.php";

$id = (isset($_GET['id']) ? $_GET['id'] : '');
if(!empty($id)){
  $mysqli = new mysqli('localhost', 'root', '', 'books');
  $result = $mysqli->query("delete from book where id=".$id);
  $num_rows = $mysqli->affected_rows;
  echo "<br><br>O registro ".$id." foi removido com sucesso da base.";
}