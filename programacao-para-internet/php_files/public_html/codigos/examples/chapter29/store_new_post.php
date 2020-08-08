<?php
  include ('include_fns.php');
  if($id = store_new_post($HTTP_POST_VARS))
  {
    include ('index.php');
  }
  else
  {
    $error = true;
    include ('new_post.php');
  }

?>