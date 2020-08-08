<?php

// include function files for this application
require_once('book_sc_fns.php'); 
session_start();


if ($HTTP_POST_VARS['username'] && $HTTP_POST_VARS['passwd'])
// they have just tried logging in
{

    $username = $HTTP_POST_VARS['username'];
    $passwd = $HTTP_POST_VARS['passwd'];

    if (login($username, $passwd))
    {
      // if they are in the database register the user id
      $HTTP_SESSION_VARS['admin_user'] = $username;
    }  
    else
    {
      // unsuccessful login
      do_html_header('Problem:');
      echo 'You could not be logged in. 
            You must be logged in to view this page.<br />';
      do_html_url('login.php', 'Login');
      do_html_footer();
      exit;
    }      
}

do_html_header('Administration');
if (check_admin_user())
  display_admin_menu();
else
  echo 'You are not authorized to enter the administration area.';

do_html_footer();

?>