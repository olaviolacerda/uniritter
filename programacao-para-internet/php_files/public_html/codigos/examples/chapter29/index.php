<?php
  include ('include_fns.php');
  session_start();

  // check if we have created our session variable
  if(!isset($HTTP_SESSION_VARS['expanded']))
  {
    $HTTP_SESSION_VARS['expanded'] = array();
  }

  // check if an expand button was pressed  
  // expand might equal 'all' or a postid or not be set
  if(isset($HTTP_GET_VARS['expand']))
  {
    if($HTTP_GET_VARS['expand'] == 'all')
      expand_all($HTTP_SESSION_VARS['expanded']);
    else
      $HTTP_SESSION_VARS['expanded'][$HTTP_GET_VARS['expand']] = true;
  }
 
  // check if a collapse button was pressed  
  // collapse might equal all or a postid or not be set
  if(isset($HTTP_GET_VARS['collapse']))
  {
    if($HTTP_GET_VARS['collapse']=='all')
      $HTTP_SESSION_VARS['expanded'] = array();
    else
      unset($HTTP_SESSION_VARS['expanded'][$HTTP_GET_VARS['collapse']]);
  } 

  do_html_header('Discussion Posts');

  display_index_toolbar();

  // display the tree view of conversations
  display_tree($HTTP_SESSION_VARS['expanded']);  

  do_html_footer();
?> 
