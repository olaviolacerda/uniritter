<?php

function db_connect()
{
   $result = @mysql_pconnect('localhost', 'mail', 'password'); 
   if (!$result)
      return false;
   if (!@mysql_select_db('mail'))
      return false;

   return $result;
}

?>
