<?php

// connect to the mlm database
function db_connect()
{
   $result = mysql_pconnect('localhost', 'mlm', 'password'); 
   if (!$result)
      return false;
   if (!@mysql_select_db('mlm'))
      return false;

   return $result;
}

?>
