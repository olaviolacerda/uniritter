<?php

// include function files for this application
require_once('book_sc_fns.php'); 
session_start();

do_html_header('Updating category');
if (check_admin_user())
{ 
  if (filled_out($HTTP_POST_VARS)) 
  {
    if(update_category($HTTP_POST_VARS['catid'], $HTTP_POST_VARS['catname']))
      echo 'Category was updated.<br />';
    else
      echo 'Category could not be updated.<br />';
  } 
  else 
    echo 'You have not filled out the form.  Please try again.';
  do_html_url('admin.php', 'Back to administration menu');
}
else 
  echo 'You are not authorised to view this page.'; 

do_html_footer();

?>
