<?php
   // include function files for this application
   require_once('bookmark_fns.php');

  //create short variable names
  $email=$HTTP_POST_VARS['email'];
  $username=$HTTP_POST_VARS['username'];
  $passwd=$HTTP_POST_VARS['passwd'];
  $passwd2=$HTTP_POST_VARS['passwd2'];
   // start session which may be needed later
   // start it now because it must go before headers
   session_start();

 
   // check forms filled in
   if (!filled_out($HTTP_POST_VARS))
   {
      do_html_header('Problem:');
      echo 'You have not filled the form out correctly - please go back'
          .' and try again.';
      do_html_footer();
      exit; 
   }    

   // email address not valid
   if (!valid_email($email))
   {
      do_html_header('Problem:');
      echo 'That is not a valid email address.  Please go back '
           .' and try again.';
      do_html_footer();
      exit;
   } 

   // passwords not the same 
   if ($passwd != $passwd2)
   {
      do_html_heading('Problem:');
      echo 'The passwords you entered do not match - please go back'
           .' and try again.';
      do_html_footer();
      exit;
   }

   // check password length is ok
   // ok if username truncates, but passwords will get
   // munged if they are too long.
   if (strlen($passwd)<6 || strlen($passwd) >16)
   {
      do_html_header('Problem:');
      echo 'Your password must be between 6 and 16 characters.'
           .'Please go back and try again.';
      do_html_footer();
      exit;
   }
   // attempt to register
   $reg_result = register($username, $email, $passwd);
   if ($reg_result === true)
   {
     // register session variable 
     $HTTP_SESSION_VARS['valid_user'] = $username;
     

     // provide link to members page
     do_html_header('Registration successful');
     echo 'Your registration was successful.  Go to the members page '
          .'to start setting up your bookmarks!';
     do_html_url('member.php', 'Go to members page');
   }
   else
   {
     // otherwise provide link back, tell them to try again
     do_html_header('Problem:');
     echo $reg_result; 
     do_html_footer();
     exit;
   }

   // end page
   do_html_footer();
 
?>