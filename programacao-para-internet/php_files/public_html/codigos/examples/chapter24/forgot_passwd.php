<?php
  require_once("bookmark_fns.php");
  do_html_header("Resetting password");

  //creating short variable name
  $username = $HTTP_POST_VARS['username'];

  if ($password=reset_password($username))
  { 
    if (notify_password($username, $password))
      echo 'Your new password has been sent to your email address.';
    else
      echo 'Your password could not be mailed to you.'
           .' Try pressing refresh.';
  }
  else
    echo 'Your password could not be reset - please try again later.';

   do_html_url('login.php', 'Login');

  do_html_footer();
?>