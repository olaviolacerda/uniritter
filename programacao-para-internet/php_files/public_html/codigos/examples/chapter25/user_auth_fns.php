<?php

require_once('db_fns.php');

function login($username, $password)
// check username and password with db
// if yes, return true
// else return false
{
  // connect to db
  $conn = db_connect();
  if (!$conn)
    return 0;

  // check if username is unique
  $result = mysql_query("select * from admin 
                         where username='$username'
                         and password = password('$password')");
  if (!$result)
     return 0;
  
  if (mysql_num_rows($result)>0)
     return 1;
  else 
     return 0;
}

function check_admin_user()
// see if somebody is logged in and notify them if not
{
  global $HTTP_SESSION_VARS;
  if (isset($HTTP_SESSION_VARS['admin_user']))
    return true;
  else
    return false;
}

function change_password($username, $old_password, $new_password)
// change password for username/old_password to new_password
// return true or false
{
  // if the old password is right 
  // change their password to new_password and return true
  // else return false
  if (login($username, $old_password))
  {
    if (!($conn = db_connect()))
      return false;
    $result = mysql_query( "update admin 
                            set password = password('$new_password')
                            where username = '$username'");
    if (!$result)
      return false;  // not changed
    else
      return true;  // changed successfully
  }
  else
    return false; // old password was wrong
}


?>
