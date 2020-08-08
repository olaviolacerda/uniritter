<?php

require_once('db_fns.php');

function register($username, $email, $password)
// register new person with db
// return true or error message
{
 // connect to db
  $conn = db_connect();
  if (!$conn)
    return 'Could not connect to database server - please try later.';

  // check if username is unique 
  $result = mysql_query("select * from user where username='$username'"); 
  if (!$result)
     return 'Could not execute query';
  if (mysql_num_rows($result)>0) 
     return 'That username is taken - go back and choose another one.';

  // if ok, put in db
  $result = mysql_query("insert into user values 
                         ('$username', password('$password'), '$email')");
  if (!$result)
    return 'Could not register you  in database - please try again later.';

  return true;
}
 
function login($username, $password)
// check username and password with db
// if yes, return true
// else return false
{
  // connect to db
  $conn = db_connect();
  if (!$conn)
    return false;

  // check if username is unique
  $result = mysql_query("select * from user 
                         where username='$username'
                         and passwd = password('$password')");
  if (!$result)
     return false;
  
  if (mysql_num_rows($result)>0)
     return true;
  else 
     return false;
}

function check_valid_user()
// see if somebody is logged in and notify them if not
{
  global $HTTP_SESSION_VARS;
  if (isset($HTTP_SESSION_VARS['valid_user']))
  {
      echo 'Logged in as '.$HTTP_SESSION_VARS['valid_user'].'.';
      echo '<br />';
  }
  else
  {
     // they are not logged in 
     do_html_heading('Problem:');
     echo 'You are not logged in.<br />';
     do_html_url('login.php', 'Login');
     do_html_footer();
     exit;
  }  
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
    $result = mysql_query( "update user
                            set passwd = password('$new_password')
                            where username = '$username'");
    if (!$result)
      return false;  // not changed
    else
      return true;  // changed successfully
  }
  else
    return false; // old password was wrong
}

function get_random_word($min_length, $max_length)
// grab a random word from dictionary between the two lengths
// and return it
{
   // generate a random word
  $word = '';
  //remember to change this path to suit your system
  $dictionary = '/usr/dict/words';  // the ispell dictionary
  $fp = fopen($dictionary, 'r');
  if(!$fp)
    return false; 
  $size = filesize($dictionary);

  // go to a random location in dictionary
  srand ((double) microtime() * 1000000);
  $rand_location = rand(0, $size);
  fseek($fp, $rand_location);

  // get the next whole word of the right length in the file
  while (strlen($word)< $min_length || strlen($word)>$max_length || strstr($word, "'"))
  {  
     if (feof($fp))   
        fseek($fp, 0);        // if at end, go to start
     $word = fgets($fp, 80);  // skip first word as it could be partial
     $word = fgets($fp, 80);  // the potential password
  };
  $word=trim($word); // trim the trailing \n from fgets
  return $word;  
}

function reset_password($username)
// set password for username to a random value
// return the new password or false on failure
{ 
  // get a random dictionary word b/w 6 and 13 chars in length
  $new_password = get_random_word(6, 13);
  
  if($new_password==false)
    return false;
  // add a number  between 0 and 999 to it
  // to make it a slightly better password
  srand ((double) microtime() * 1000000);
  $rand_number = rand(0, 999); 
  $new_password .= $rand_number;
 
  // set user's password to this in database or return false
  if (!($conn = db_connect()))
      return false;
  $result = mysql_query( "update user
                          set passwd = password('$new_password')
                          where username = '$username'");
  if (!$result)
    return false;  // not changed
  else
    return $new_password;  // changed successfully  
}

function notify_password($username, $password)
// notify the user that their password has been changed
{
    if (!($conn = db_connect()))
      return false;
    $result = mysql_query("select email from user
                            where username='$username'");
    if (!$result)
    {
      return false;  // not changed
    }
    else if (mysql_num_rows($result)==0)
    {
      return false; // username not in db
    }
    else
    {
      $email = mysql_result($result, 0, 'email');
      $from = "From: support@phpbookmark \r\n";
      $mesg = "Your PHPBookmark password has been changed to $password \r\n"
              ."Please change it next time you log in. \r\n";
      
      
      if (mail($email, 'PHPBookmark login information', $mesg, $from))
        return true;      
      else
        return false;     
    }
} 

?>
