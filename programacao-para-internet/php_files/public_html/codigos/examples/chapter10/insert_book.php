<html>
<head>
  <title>Book-O-Rama Book Entry Results</title>
</head>
<body>
<h1>Book-O-Rama Book Entry Results</h1>
<?php
  // create short variable names
  $isbn=$HTTP_POST_VARS['isbn'];
  $author=$HTTP_POST_VARS['author'];
  $title=$HTTP_POST_VARS['title'];
  $price=$HTTP_POST_VARS['price'];

  if (!$isbn || !$author || !$title || !$price)
  {
     echo 'You have not entered all the required details.<br />'
          .'Please go back and try again.';
     exit;
  }
  
  $isbn = addslashes($isbn);
  $author = addslashes($author);
  $title = addslashes($title);
  $price = doubleval($price);

  @ $db = mysql_pconnect('localhost', 'bookorama', 'bookorama123');

  if (!$db)
  {
     echo 'Error: Could not connect to database.  Please try again later.';
     exit;
  }

  mysql_select_db('books');
  $query = "insert into books values 
            ('".$isbn."', '".$author."', '".$title."', '".$price."')"; 
  $result = mysql_query($query);
  if ($result)
      echo  mysql_affected_rows().' book inserted into database.'; 
?>

</body>
</html>
