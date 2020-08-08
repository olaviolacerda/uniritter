<?php

function query_select($name, $query, $default='')
{

  $conn = db_connect();

  $result = mysql_query($query, $conn);

  if (!$result)
    return(0);

  $select  = "<SELECT NAME=\"$name\">";
  $select .= "<OPTION VALUE=\"\">-- Choose --</OPTION>";

  for ($i=0; $i < mysql_numrows($result); $i++) {
    $opt_code = mysql_result($result, $i, 0);
    $opt_desc = mysql_result($result, $i, 1);
    $select .= "<OPTION VALUE=\"$opt_code\"";
    if ($opt_code == $default) {
      $select .= ' SELECTED';
    }
    $select .=  ">[$opt_code] $opt_desc</OPTION>";
  }
  $select .= "</SELECT>\n";

  return($select);

}
