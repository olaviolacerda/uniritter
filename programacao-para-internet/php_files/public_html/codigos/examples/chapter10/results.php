<html>
<head>
  <title>Book-O-Rama Search Results</title>
</head>
<body>
<h1>Book-O-Rama Search Results</h1>
<?php
  // create short variable names
  $searchtype=$HTTP_POST_VARS['searchtype'];
  $searchterm=$HTTP_POST_VARS['searchterm'];

  $searchterm= trim($searchterm);

  if (!$searchtype || !$searchterm)
  {
     echo 'You have not entered search details.  Please go back and try again.';
     exit;
  }
  
  $searchtype = addslashes($searchtype);
  $searchterm = addslashes($searchterm);

  @ $db = mysql_pconnect('localhost', 'bookorama', 'bookorama123');

  if (!$db)
  {
     echo 'Error: Could not connect to database.  Please try again later.';
     exit;
  }

  mysql_select_db('books');
  $query = "select * from books where ".$searchtype." like '%".$searchterm."%'";
  $result = mysql_query($query);

  $num_results = mysql_num_rows($result);

  echo '<p>Number of books found: '.$num_results.'</p>';

  for ($i=0; $i <$num_results; $i++)
  {
     $row = mysql_fetch_array($result);
     echo '<p><strong>'.($i+1).'. Title: ';
     echo htmlspecialchars(stripslashes($row['title']));
     echo '</strong><br />Author: ';
     echo stripslashes($row['author']);
     echo '<br />ISBN: ';
     echo stripslashes($row['isbn']);
     echo '<br />Price: ';
     echo stripslashes($row['price']);
     echo '</p>';
  }
?>

</body>
</html>