<?php
  require_once('bookmark_fns.php');
  session_start();
  do_html_header('Recommending URLs');
  check_valid_user();
  $urls = recommend_urls($HTTP_SESSION_VARS['valid_user']);
  display_recommended_urls($urls); 
   display_user_menu(); 
  do_html_footer();
?>