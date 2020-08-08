<?php

include('include_fns.php');

$conn = db_connect();

$sql = 'select * from stories order by modified desc';
$result = mysql_query($sql, $conn);

print '<h2>Editor admin</h2>';
print '<table>';
print '<tr><th>Headline</th><th>Last modified</th></tr>';
while ($story = mysql_fetch_array($result)) {
  print '<tr><td>';
  print $story['headline'];
  print '</td><td>';
  print date('M d, H:i', $story['modified']);
  print '</td><td>';
  if ($story[published]) {
    print '[<a href="unpublish_story.php?story='.$story['id'].'">unpublish</a>] ';
  }
  else {
    print '[<a href="publish_story.php?story='.$story['id'].'">publish</a>] ';
    print '[<a href="delete_story.php?story='.$story['id'].'">delete</a>] ';
  }
  print '[<a href="story.php?story='.$story['id'].'">edit</a>] ';

  print '</td></tr>';
}
print '</table>';
?>