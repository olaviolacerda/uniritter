<?php

function db_connect()
{
   $result = @mysql_pconnect('localhost', 'discussion', 'password'); 
   if (!$result)
      return false;
   if (!@mysql_select_db('discussion'))
      return false;

   return $result;
}

?>
