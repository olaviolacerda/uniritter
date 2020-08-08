<?php

include('include_fns.php');
include('header.php');

$conn = db_connect();


$pages_sql = 'select * from pages order by code';
$pages_result = mysql_query($pages_sql, $conn);

while ($pages = mysql_fetch_array($pages_result)) {

  $story_sql = "select * from stories
                where page = '".$pages['code']."'
                and published is not null
                order by published desc";
  $story_result = mysql_query($story_sql, $conn);
  if (mysql_num_rows($story_result)) {
    $story = mysql_fetch_array($story_result);
    print '<table border="0" width="400">';
    print '<tr>';
    print '<td rowspan="2" width="100">';
    if ($story[picture])
      print "<img src=\"resize_image.php?image=$story[picture]\" />";
    print '</td>';
    print '<td>';
    print '<h3>'.$pages['description'].'</h3>';
    print $story['headline'];
    print '</td>';
    print '</tr>';
    print '<tr><td align="right">';
    print '<a href="page.php?page='.$pages['code'].'">';
    print '<font size="1">Read more '.$pages['code'].' ...</font>';
    print '</a>';
    print '</table>';
  }
}

include('footer.php');
?>