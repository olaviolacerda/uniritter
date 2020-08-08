<?php
function login($username, $password)
// check username and password with db
// if yes, return true
// else return false
{
  // connect to db
  $conn = db_connect();
  if (!$conn)
    return false;

  $result = mysql_query("select * from users 
                         where username='$username'
                         and password = password('$password')");
  if (!$result)
     return false;
  
  if (mysql_num_rows($result)>0)
     return true;
  else 
     return false;
}

function check_auth_user()
// see if somebody is logged in and notify them if not
{
  global $HTTP_SESSION_VARS;
  if (isset($HTTP_SESSION_VARS['auth_user']))
    return true;
  else
    return false;
}

?>
