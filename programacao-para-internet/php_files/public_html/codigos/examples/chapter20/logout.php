<?php
  session_start();

  $old_user = $HTTP_SESSION_VARS['valid_user'];  // store  to test if they *were* 
   logged in
  unset($HTTP_SESSION_VARS['valid_user']);
  session_destroy();
?>
<html>
<body>
<h1>Log out</h1>
<?php 
  if (!empty($old_user))
  {
    echo 'Logged out.<br />';
  }
  else
  {
    // if they weren't logged in but came to this page somehow
    echo 'You were not logged in, and so have not been logged out.<br />'; 
  }
?> 
<a href="authmain.php">Back to main page</a>
</body>
</html>