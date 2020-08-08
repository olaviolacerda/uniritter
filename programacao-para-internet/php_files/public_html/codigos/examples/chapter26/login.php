<?php

include('include_fns.php');

if ( (!isset($HTTP_POST_VARS['username'])) || (!isset($HTTP_POST_VARS['password'])) ) {
  print 'You must enter your username and password to proceed';
  exit;
}

$username = $HTTP_POST_VARS['username'];
$password = $HTTP_POST_VARS['password'];

if (login($username, $password)) {
  $HTTP_SESSION_VARS['auth_user'] = $username;
  header('Location: '.$HTTP_SERVER_VARS['HTTP_REFERER']);
}
else {
  print 'The password you entered is incorrect';
  exit;
}


?>
