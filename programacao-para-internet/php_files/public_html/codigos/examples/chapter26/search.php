<?php

include('include_fns.php');
include('header.php');

$conn = db_connect();

if ($HTTP_POST_VARS['keyword']) {
  $k = split(' ', $HTTP_POST_VARS['keyword']);
  $num_keywords = count($k);
  for ($i=0; $i<$num_keywords; $i++) {
    if ($i)
      $k_string .= "or k.keyword = '".$k[$i]."' ";
    else
      $k_string .= "k.keyword = '".$k[$i]."' ";
  }
  $and .= "and ($k_string) ";


$sql = "select s.id,
               s.headline,
               10 * sum(k.weight) / $num_keywords as score
        from stories s, keywords k
        where s.id = k.story
        $and
        group by s.id, s.headline
        order by score desc, s.id desc";


$result = mysql_query($sql, $conn);
}
print '<h2>Search results</h2>';

if ($result  && mysql_num_rows($result)) {
  print '<table>';
  while ($qry = mysql_fetch_array($result)) {
    print '<tr><td>';
    print $qry['headline'];
    print '</td><td>';
    print floor($qry['score']).'%';
    print '</td></tr>';
  }
  print '</table>';
}
else {
  print 'No matching stories found';
}
include('footer.php');
?>