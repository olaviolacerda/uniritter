<?php
  if(!isset($HTTP_POST_VARS['name'])&&!isset($HTTP_POST_VARS['password']))
  {
    //Visitor needs to enter a name and password
?>
    <h1>Please Log In</h1>
    This page is secret.
    <form method="post" action="secretdb.php">
    <table border="1">
    <tr>
      <th> Username </th>
      <td> <input type="text" name="name"> </td>
    </tr>
    <tr>
      <th> Password </th>
      <td> <input type="password" name="password"> </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Log In">
      </td>
    </tr>
    </table>
    </form>
<?php
  }
  else
  {
    // connect to mysql
    $mysql = mysql_connect( 'localhost', 'webauth', 'webauth' );
    if(!$mysql)
    {
      echo 'Cannot connect to database.';
      exit;
    }
    // select the appropriate database
    $mysql = mysql_select_db( 'auth' );
    if(!$mysql)
    {
      echo 'Cannot select database.';
      exit;
    }

    // query the database to see if there is a record which matches
    $query = "select count(*) from auth where
              name = '$name' and
              pass = '$password'";

    $result = mysql_query( $query );
    if(!$result)
    {
      echo 'Cannot run query.';
      exit;
    }

    $count = mysql_result( $result, 0, 0 );

    if ( $count > 0 )
    {
      // visitor's name and password combination are correct
      echo '<h1>Here it is!</h1>';
      echo 'I bet you are glad you can see this secret page.';
    }
    else
    {
      // visitor's name and password combination are not correct
      echo '<h1>Go Away!</h1>';
      echo 'You are not authorized to view this resource.';
    }
  }
?>