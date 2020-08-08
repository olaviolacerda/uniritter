<?php
  // this functionality is in a separate file to allow us to be
  // more paranoid with it
  
  // if anything goes wrong, we will exit 

  $max_size = 50000;
  
  include ('include_fns.php');
  session_start();

  // only admin users can upload files
  if(!check_admin_user())
  {
    echo 'You do not seem to be authorized to use this page.';
    exit;
  }
  
  // set up the admin toolbar buttons
  $buttons = array();
  $buttons[0] = 'change-password';
  $buttons[1] = 'create-list';
  $buttons[2] = 'create-mail';
  $buttons[3] = 'view-mail';
  $buttons[4] = 'log-out';
  $buttons[5] = 'show-all-lists';
  $buttons[6] = 'show-my-lists';
  $buttons[7] = 'show-other-lists';
  
  do_html_header('Pyramid-MLM - Upload Files');
  
  display_toolbar($buttons);

  // check that the page is being called with the required data
  if(!$HTTP_POST_FILES['userfile']['name'][0] 
     ||!$HTTP_POST_FILES['userfile']['name'][1]
     ||!$HTTP_POST_VARS['subject']||!$HTTP_POST_VARS['list'])
  {
      echo 'Problem: You did not fill out the form fully. The images are the 
            only optional fields.  Each message needs a subject, text version 
            and an HTML version.';
      do_html_footer();
      exit;
  }
  $list = $HTTP_POST_VARS['list'];
  $subject = $HTTP_POST_VARS['subject'];

  if(!db_connect())
  {
     echo '<p>Could not connect to db</p>'; 
     do_html_footer();
     exit;
  }
  
  // add mail details to the DB  
  $query = "insert into mail values (NULL, 
                                     '".$HTTP_SESSION_VARS['admin_user']."',
                                     '".$subject."',
                                     '".$list."',
                                     'STORED', NULL, NULL)";
  $result = mysql_query($query);
  if(!$result)   
  {   
    do_html_footer();  
    exit; 
  }
  
  //get the id MySQL assigned to this mail
  $mailid = mysql_insert_id();
        
  if(!$mailid)   
  {   
    do_html_footer();  
    exit; 
  }
  
  
  // creating directory will fail if this is not the first message archived  
  // that's ok
  @ mkdir('archive/'.$list, 0700);

  // it is a problem if creating the specific directory for this mail fails 
  if(!mkdir('archive/'.$list."/$mailid", 0700))
  {   
    do_html_footer();  
    exit; 
  }
  
  // iterate through the array of uploaded files
  $i = 0;
  while ($HTTP_POST_FILES['userfile']['name'][$i]&&
         $$HTTP_POST_FILES['userfile']['name'][$i]!='none')
  {
    echo '<p>Uploading '.$HTTP_POST_FILES['userfile']['name'][$i].' - ';
    echo $HTTP_POST_FILES['userfile']['size'][$i].' bytes.</p>';
    if ($HTTP_POST_FILES['userfile']['size'][$i]==0)
    {
      echo 'Problem: '.$HTTP_POST_FILES['userfile']['name'][$i].
           ' is zero length';
      $i++;
      continue;  
    }
  
    if ($HTTP_POST_FILES['userfile']['size'][$i]>$max_size)
    {
      echo 'Problem: '.$HTTP_POST_FILES['userfile']['name'][$i].' is over '
            .$max_size.' bytes';
      $i++;
      continue;  
    }

    // we would like to check that the uploaded image is an image
    // if getimagesize() can work out its size, it probably is.
    if($i>1&&!getimagesize($HTTP_POST_FILES['userfile']['tmp_name'][$i]))
    {
      echo 'Problem: '.$HTTP_POST_FILES['userfile']['name'][$i].
           ' is corrupt, or not a gif, jpeg or png';
      $i++;
      continue;  
    }
  
    // file 0 (the text message) and file 1 (the html message) are special cases
    if($i==0) 
      $destination = "archive/$list/$mailid/text.txt";
    else if($i == 1)
      $destination = "archive/$list/$mailid/index.html";
    else
    {
      $destination = "archive/$list/$mailid/"
                     .$HTTP_POST_FILES['userfile']['name'][$i];
      $query = "insert into images values ($mailid, 
                             '".$HTTP_POST_FILES['userfile']['name'][$i]."',
                             '".$HTTP_POST_FILES['userfile']['type'][$i]."')";
      $result = mysql_query($query);
    }
    //if we are using PHP version >= 4.03

    if (!is_uploaded_file($HTTP_POST_FILES['userfile']['tmp_name'][$i]))
    { 
      // possible file upload attack detected
      echo 'Something funny happening with '
           .$HTTP_POST_FILES['userfile']['name'].', not uploading.';
      do_html_footer();
      exit;
    }
    
    move_uploaded_file($HTTP_POST_FILES['userfile']['tmp_name'][$i], 
                       $destination);
/*
    // if version <= 4.02
    copy ($userfile[$i], $destination);
    
    unlink($userfile[$i]);
*/
    
    $i++;
  }
  
  display_preview_button($list, $mailid, 'preview-html');
  display_preview_button($list, $mailid, 'preview-text');
  display_button('send', "&id=$mailid");
  
  echo '<br /><br /><br /><br /><br />';
  do_html_footer();
?>  