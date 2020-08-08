<?php

if (!isset($HTTP_GET_VARS['page']))
{
  header('Location: headlines.php');
  exit;
}

$page = $HTTP_GET_VARS['page'];

include('include_fns.php');
include('header.php');

$conn = db_connect();


$sql = "select * from stories 
        where page = '$page'
        and published is not null
        order by published desc";
$result = mysql_query($sql, $conn);

while ($story = mysql_fetch_array($result)) 
{
  print '<h2>'.$story['headline'].'</h2>';
  if ($story['picture']) {
    $size = getImageSize($story['picture']);
    $width  = $size[0];
    $height = $size[1];
    print "<img src=\"".$story['picture']."\" height=\"$height\" width=\"$width\" align=\"left\" />";
  
  }
  print $story['story_text'];
  $w = get_writer_record($story['writer']);
  print '<br /><font size="1">';
  print $w[full_name].', ';
  print date('M d, H:i', $story['modified']);
  print '</font>';
}


include('footer.php');
?>