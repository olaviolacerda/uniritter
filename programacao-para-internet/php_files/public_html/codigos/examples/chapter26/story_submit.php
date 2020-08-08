<?php

// story_submit.php
// add / modify story record

include('include_fns.php');

$conn = db_connect();

$headline = $HTTP_POST_VARS['headline'];
$page = $HTTP_POST_VARS['page'];
$time = time();

if ( (isset($HTTP_POST_FILES['html']['name']) && 
 (dirname($HTTP_POST_FILES['html']['type']) == 'text') 
      && is_uploaded_file($HTTP_POST_FILES['html']['tmp_name']))) 
{
  $fp = fopen($HTTP_POST_FILES['html']['tmp_name'], 'r');
  $story_text = addslashes(fread($fp, filesize($HTTP_POST_FILES['html']['tmp_name'])));
  fclose($fp);
}
else
  $story_text = $HTTP_POST_VARS['story_text'];



if (isset($HTTP_POST_VARS['story']) && $HTTP_POST_VARS['story']!='') 
{   // It's an update
  $story = $HTTP_POST_VARS['story'];

  $sql = "update stories
          set headline = '$headline', 
              story_text = '$story_text',
              page = '$page',
              modified = $time
          where id = $story";
}
else {         // It's a new story
  $sql = "insert into stories 
            (headline, story_text, page, writer, created, modified)
          values 
            ('$headline', '$story_text', '$page', '"
             .$HTTP_SESSION_VARS['auth_user']."', $time, $time)";
}

$result = mysql_query($sql, $conn);

if (!$result) {
  print "There was a database error when executing <pre>$sql</pre>";
  print mysql_error();
  exit;
}


if ( (isset($HTTP_POST_FILES['picture']['name']) && 
      is_uploaded_file($HTTP_POST_FILES['picture']['tmp_name']))) 
{

  if (!isset($story))
    $story = mysql_insert_id();

  $type = basename($HTTP_POST_FILES['picture']['type']);

  switch ($type) {
    case 'jpeg':
    case 'pjpeg':   $filename = "pictures/$story.jpg";
                    move_uploaded_file($HTTP_POST_FILES['picture']['tmp_name'], 
                     $filename);
                    $sql = "update stories
                            set picture = '$filename'
                            where id = $story";
                    $result = mysql_query($sql, $conn);
                    break;
    default:        print 'Invalid picture format: '.
                          $HTTP_POST_FILES['picture']['type'];
  }
}

header('Location: '.$HTTP_POST_VARS['destination']);

?>
