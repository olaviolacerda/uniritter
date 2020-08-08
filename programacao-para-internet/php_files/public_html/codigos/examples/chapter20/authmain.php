<?php
session_start();

if (isset($HTTP_POST_VARS['userid']) && isset($HTTP_POST_VARS['password']))
{
  // if the user has just tried to log in
  $userid = $HTTP_POST_VARS['userid'];
  $password = $HTTP_POST_VARS['password'];

  $db_conn = mysql_connect('localhost', 'webauth', 'webauth');
  mysql_select_db('auth', $db_conn);
  $query = 'select * from auth '
           ."where name='$userid' "
           ." and pass=password('$password')";
  $result = mysql_query($query, $db_conn);
  if (mysql_num_rows($result) >0 )
  {
    // if they are in the database register the user id
    $HTTP_SESSION_VARS['valid_user'] = $userid;    
  }
}
?>
<html>
<body>
<h1>Home page</h1>
<? 
  if (isset($HTTP_SESSION_VARS['valid_user']))
  {
    echo 'You are logged in as: '.$HTTP_SESSION_VARS['valid_user'].' <br />';
    echo '<a href="logout.php">Log out</a><br />';
  }
  else
  {
    if (isset($userid))
    {
      // if they've tried and failed to log in
      echo 'Could not log you in';
    }
    else 
    {
      // they have not tried to log in yet or have logged out
      echo 'You are not logged in.<br />';
    }

    // provide form to log in 
    echo '<form method="post" action="authmain.php">';
    echo '<table>';
    echo '<tr><td>Userid:</td>';
    echo '<td><input type="text" name="userid"></td></tr>';
    echo '<tr><td>Password:</td>';
    echo '<td><input type="password" name="password"></td></tr>';
    echo '<tr><td colspan="2" align="center">';
    echo '<input type="submit" value="Log in"></td></tr>';
    echo '</table></form>';
  }
?>
<br>
<a href="members_only.php">Members section</a>
</body>
</html>