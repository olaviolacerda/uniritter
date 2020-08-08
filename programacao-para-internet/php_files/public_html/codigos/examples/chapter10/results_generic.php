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

  // set up for using PEAR DB
  require('DB.php');
  $user = 'bookorama';
  $pass = 'bookorama123';
  $host = 'localhost';
    $db_name = 'books';

  // set up universal connection string or DSN
  $dsn = "mysql://$user:$pass@$host/$db_name";

  // connect to database
  $db = DB::connect($dsn, true);

  // check if connection worked
  if (DB::isError($db)) 
  {    
    echo $db->getMessage();
    exit;
  }

  // perform query
  $query = "select * from books where ".$searchtype." like '%".$searchterm."%'";
  $result = $db->query($query);
  // check that result was ok
  if (DB::isError($result)) 
  { 
    echo $db->getMessage();
    exit;
  }

  // get number of returned rows
  $num_results = $result->numRows();

  // display each returned row
  for ($i=0; $i <$num_results; $i++)
  {
     $row = $result->fetchRow(DB_FETCHMODE_ASSOC);
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

  // disconnect from database
  $db->disconnect();
  ?>

</body>
</html>