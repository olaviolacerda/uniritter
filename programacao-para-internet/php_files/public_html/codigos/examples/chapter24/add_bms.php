<?php
 require_once('bookmark_fns.php');
 session_start();
 
  //create short variable name
  $new_url = $HTTP_POST_VARS['new_url'];
 
  do_html_header('Adding bookmarks');
  check_valid_user();
  if (!filled_out($HTTP_POST_VARS))
  {
    echo 'You have not filled out the form completely.
          Please try again.';
    display_user_menu();
    do_html_footer();  
    exit;
  }
  else 
  {
    // check URL format
    if (strstr($new_url, 'http://')===false)
       $new_url = 'http://'.$new_url;

    // check URL is valid
    if (@fopen($new_url, 'r'))
    {  
      // try to add bm
      if (add_bm($new_url))
        echo 'Bookmark added.';
      else
        echo 'Could not add bookmark.';
    }
    else
      echo 'Not a valid URL.';
  }

   // get the bookmarks this user has saved
  if ($url_array = get_user_urls($HTTP_SESSION_VARS['valid_user']));
     display_user_urls($url_array);

  display_user_menu(); 
  do_html_footer();
?>