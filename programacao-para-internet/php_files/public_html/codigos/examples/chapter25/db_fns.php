<?php

function db_connect()
{
   $result = @mysql_pconnect('localhost', 'book_sc', 'password'); 
   if (!$result)
      return false;
   if (!@mysql_select_db('book_sc'))
      return false;
   return $result;
}

function db_result_to_array($result)
{
   $res_array = array();

   for ($count=0; $row = @mysql_fetch_array($result); $count++)
     $res_array[$count] = $row;

   return $res_array;
}

?>
