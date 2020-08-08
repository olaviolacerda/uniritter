<?php

// include function files for this application
require_once('bookmark_fns.php'); 
session_start();

//create short variable names
$username = $HTTP_POST_VARS['username'];
$passwd = $HTTP_POST_VARS['passwd'];

if ($username && $passwd)
// they have just tried logging in
{
    if (login($username, $passwd))
    {
      // if they are in the database register the user id
      $HTTP_SESSION_VARS['valid_user'] = $username;
    }  
    else
    {
      // unsuccessful login
      do_html_header('Problem:');
      echo 'You could not be logged in. 
            You must be logged in to view this page.';
      do_html_url('login.php', 'Login');
      do_html_footer();
      exit;
    }      
}

do_html_header('Home');
check_valid_user();
// get the bookmarks this user has saved
if ($url_array = get_user_urls($HTTP_SESSION_VARS['valid_user']));
  display_user_urls($url_array);

// give menu of options
display_user_menu();

do_html_footer();
?>
