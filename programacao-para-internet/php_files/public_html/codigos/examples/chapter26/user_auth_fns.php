<?php
function login($username, $password)
// check username and password with db
// if yes, return true
// else return false
{
  // connect to db
  $conn = db_connect();
  if (!$conn)
    return 0;

  $result = mysql_query("select * from writers
                         where username='$username'
                         and password = password('$password')");
  if (!$result)
     return 0;
  
  if (mysql_num_rows($result)>0)
     return 1;
  else 
     return 0;
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
