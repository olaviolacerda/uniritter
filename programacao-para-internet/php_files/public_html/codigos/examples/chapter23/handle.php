<?php
  // The error handler function
  function myErrorHandler ($errno, $errstr, $errfile, $errline)
  {
    echo "<br /><table bgcolor='#cccccc'><tr><td>
          <p><b>ERROR:</b> $errstr</p>
          <p>Please try again, or contact us and tell us that
          the error occurred in line $errline of file '$errfile'</p>";
    if ($errno == E_USER_ERROR||$errno == E_ERROR)
    {
      echo '<p>This error was fatal, program ending</p>';
      echo '</td></tr></table>';
      //close open resources, include page footer, etc
      exit;
    }
    echo '</td></tr></table>';
  }
  // Set the error handler
  set_error_handler('myErrorHandler');

  //trigger different levels of error
  trigger_error('Trigger function called', E_USER_NOTICE);
  fopen('nofile', 'r');
  trigger_error('This computer is beige', E_USER_WARNING); 
  include ('nofile');
  trigger_error('This computer will self destruct in 15 seconds', E_USER_ERROR);
?>