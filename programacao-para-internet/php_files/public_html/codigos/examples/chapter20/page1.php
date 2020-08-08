<?php
  session_start();
  
  $HTTP_SESSION_VARS['sess_var'] = "Hello world!";

  echo 'The content of $HTTP_SESSION_VARS[\'sess_var\'] is '
        .$HTTP_SESSION_VARS['sess_var'].'<br />';
?>
<a href="page2.php">Next page</a> 