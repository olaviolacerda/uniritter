<?php
  include ('include_fns.php');

  $title = $HTTP_POST_VARS['title'];  
  $poster = $HTTP_POST_VARS['poster'];  
  $message = $HTTP_POST_VARS['message'];  

  if(isset($HTTP_GET_VARS['parent']))
     $parent = $HTTP_GET_VARS['parent'];
  else
    $parent = $HTTP_POST_VARS['parent'];
    
  
  if(!$area)
    $area = 1;
  
  if(!$error)
  { 
    if(!$parent)
    {
      $parent = 0;
      if(!$title) 
        $title = 'New Post';
    }
    else
    {
      // get post name
      $title = get_post_title($parent);
   
      // append Re:
      if(strstr($title, 'Re: ') == false )
        $title = 'Re: '.$title;
 
      //make sure title will still fit in db
      $title = substr($title, 0, 20);

      //prepend a quoting pattern to the post you are replying to 
      $message = add_quoting(get_post_message($parent));
    }
  }
  do_html_header($title);
  
  display_new_post_form($parent, $area, $title, $message, $poster);  
  
  if($error)
  {
     echo 'Your message was not stored.  
           Make sure you have filled in all fields and try again.';
  }
  
  do_html_footer();
?> 