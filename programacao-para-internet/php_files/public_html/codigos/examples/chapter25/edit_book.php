<?php

// include function files for this application
require_once('book_sc_fns.php'); 
session_start();

do_html_header('Updating book');
if (check_admin_user())
{ 
  if (filled_out($HTTP_POST_VARS)) 
  {
    $oldisbn = $HTTP_POST_VARS['oldisbn'];
    $isbn = $HTTP_POST_VARS['isbn'];
    $title = $HTTP_POST_VARS['title'];
    $author = $HTTP_POST_VARS['author'];
    $catid = $HTTP_POST_VARS['catid'];
    $price = $HTTP_POST_VARS['price'];
    $description = $HTTP_POST_VARS['description'];

    if(update_book($oldisbn, $isbn, $title, $author, $catid,
                      $price, $description))
      echo 'Book was updated.<br />';
    else
      echo 'Book could not be updated.<br />';
  } 
  else 
    echo 'You have not filled out the form.  Please try again.';
  do_html_url('admin.php', 'Back to administration menu');
}
else 
  echo 'You are not authorised to view this page.'; 

do_html_footer();

?>
