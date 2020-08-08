<?php

function db_connect()
{
   $result = mysql_pconnect('localhost', 'bm_user', 'password'); 
   if (!$result)
      return false;
   if (!mysql_select_db('bookmarks'))
      return false;

   return $result;
}

?>
