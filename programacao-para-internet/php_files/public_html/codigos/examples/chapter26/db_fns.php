<?php

function db_connect()
{
   $result = @mysql_pconnect('localhost', 'content', 'password'); 
   if (!$result)
      return false;
   if (!@mysql_select_db('content'))
      return false;

   return $result;
}

function get_writer_record($username)
{
  $conn = db_connect();
  $sql = "select * from writers where username = '$username'";
  $result = mysql_query($sql, $conn);
  return(mysql_fetch_array($result));
}

function get_story_record($story)
{
  $conn = db_connect();
  $sql = "select * from stories where id = '$story'";
  $result = mysql_query($sql, $conn);
  return(mysql_fetch_array($result));
}

?>
