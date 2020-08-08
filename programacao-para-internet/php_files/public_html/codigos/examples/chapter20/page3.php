<?php
 
  session_start();

  echo 'The content of $HTTP_SESSION_VARS[\'sess_var\'] is '
        .$HTTP_SESSION_VARS['sess_var'].'<br />';

  session_destroy();
?> 