<?php
function login($email, $password)
// check username and password with db
// if yes, return login type 
// else return false
{
  // connect to db
  $conn = db_connect();
  if (!$conn)
    return 0;

  $query = "select admin from subscribers 
                         where email='$email'
                         and password = password('$password')";
  //echo $query;
  $result = mysql_query($query);
  if (!$result)
    return false;
  
  if (mysql_num_rows($result)<1)
    return false;
  
  if(mysql_result($result, 0, 0) == 1)
    return 'admin';
  else
    return 'normal';
}

function check_logged_in()
{
  return ( check_normal_user() || check_admin_user() );
}

function get_email()
{
  global $HTTP_SESSION_VARS;
  
  if (isset($HTTP_SESSION_VARS['normal_user']))
    return $HTTP_SESSION_VARS['normal_user'];    
  if (isset($HTTP_SESSION_VARS['admin_user']))
   return $HTTP_SESSION_VARS['admin_user'];    

  return false;
}

function change_password($email, $old_password, $new_password,
                         $new_password_conf)
// change password for email/old_password to new_password
// return true or false
{

  // if the old password is right 
  // change their password to new_password and return true
  // else return false
  if (login($email, $old_password))
  {
    if($new_password==$new_password_conf)
    { 
      if (!($conn = db_connect()))
        return false;
      $query = "update subscribers
               set password = password('$new_password')
               where email = '$email'";
      $result = mysql_query($query);
      return $result;
    }
    else
      echo '<p> Your passwords do not match.';
  }
  else
    echo '<p> Your old password is incorrect.';
  
  return false; // old password was wrong
}



function check_normal_user()
// see if somebody is logged in and notify them if not
{
  global $HTTP_SESSION_VARS;
  
  if (isset($HTTP_SESSION_VARS['normal_user']))
    return true;
  else
    return false;
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


?>
