<?php

function expand_all(&$expanded)
{
  // mark all threads with children as to be shown expanded
  $conn = db_connect();
  $query = 'select postid from header where children = 1';
  $result = mysql_query($query);
  $num = mysql_numrows($result);
  for($i = 0; $i<$num; $i++)
  {
    $expanded[mysql_result($result, $i, 0)]=true;
  } 
}

function get_post($postid)
{
  // extract one post from the database and return as an array

  if(!$postid) return false;

  $conn = db_connect();
  
  //get all header information from 'header'
  $query = "select * from header where postid = $postid";
  $result = mysql_query($query);
  if(mysql_numrows($result)!=1)
    return false;
  $post = mysql_fetch_array($result);

  // get message from body and add it to the previous result
  $query = "select * from body where postid = $postid";
  $result2 = mysql_query($query);
  if(mysql_numrows($result2)>0) 
  {
    $body = mysql_fetch_array($result2);
    if($body)
    {
      $post['message'] = $body['message'];
    }
  }
  return $post; 
}

function get_post_title($postid)
{
  // extract one post's name from the database

  if(!$postid) return '';

  $conn = db_connect();

  //get all header information from 'header'
  $query = "select title from header where postid = $postid";
  $result = mysql_query($query);
  if(mysql_numrows($result)!=1)
    return '';
  return  mysql_result($result, 0, 0);

}

function get_post_message($postid)
{
  // extract one post's message from the database

  if(!$postid) return '';

  $conn = db_connect();

  $query = "select message from body where postid = $postid";
  $result = mysql_query($query);
  if(mysql_numrows($result)>0)
  {
    return mysql_result($result,0,0);
  }
}


function add_quoting($string, $pattern = '> ')
{
  // add a quoting pattern to mark text quoted in your reply
  return $pattern.str_replace("\n", "\n$pattern", $string);
}


function store_new_post($post)
{
  // validate clean and store a new post
 
  $conn = db_connect();
  // check no fields are blank
  if(!filled_out($post))
  {
    return false;
  }
  $post = clean_all($post);

  //check parent exists
  if($post['parent']!=0)
  {
    $query = "select postid from header where postid = '".$post['parent']."'";
    $result = mysql_query($query);
    if(mysql_numrows($result)!=1)
    {
      return false; 
    }
  }

  // check not a duplicate
  $query = "select header.postid from header, body where
            header.postid = body.postid and 
            header.parent = ".$post['parent']." and
            header.poster = '".$post['poster']."' and
            header.title = '".$post['title']."' and
            header.area = ".$post['area']." and 
            body.message = '".$post['message']."'";
  $result = mysql_query($query);
  if (!$result)
  {
     return false;
  }
  if(mysql_numrows($result)>0)
     return mysql_result($result, 0, 0);

  $query = "insert into header values
            ('".$post['parent']."', 
             '".$post['poster']."', 
             '".$post['title']."', 
             0,
             '".$post['area']."',
             now(),
             NULL 
            )";
  $result = mysql_query($query);
  if (!$result)
  {
     return false;
  }

  // note that our parent now has a child
  $query = 'update header set children = 1 where postid = '.$post['parent'];
  $result = mysql_query($query);
  if (!$result)
  {
     return false;
  }

  // find our post id, note that there could be multiple headers 
  // that are the same except for id and probably posted time
  $query = "select header.postid from header left join body on header.postid = body.postid  
                   where parent = '".$post['parent']."' 
                   and poster = '".$post['poster']."'
                   and title = '".$post['title']."'
                   and body.postid is NULL"; 
  $result = mysql_query($query);
  if (!$result)
  {
     return false;
  }
  if(mysql_numrows($result)>0)
    $id = mysql_result($result, 0, 0);

  if($id)
  {
     $query = "insert into body values ($id, '".$post['message']."')";
     $result = mysql_query($query);
     if (!$result)
     {
       return false;
     }

    return $id;
  }
  
}

?>
