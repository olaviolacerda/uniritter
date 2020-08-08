<?php
// Listing 26.5
// stories.php Is the Interface for Writers to Manage Their Stories

include('include_fns.php');
session_start();

if (!check_auth_user()) {
?>
<form action="login.php" method="post">
<table border="0">
<tr>
  <td>Username</td>
  <td><input size="16" name="username"></td>
</tr>
<tr>
  <td>Password</td>
  <td><input size="16" type="password" name="password"></td>
</tr>
</table>
<input type="submit" value="Log in">
</form>
<?php
}
else {
  $conn = db_connect();

  $w = get_writer_record($HTTP_SESSION_VARS['auth_user']);

  print 'Welcome, '.$w['full_name'];
  print ' (<a href="logout.php">Logout</a>)';
  print '<p>';

  $sql = 'select * from stories where writer = \''.
         $HTTP_SESSION_VARS['auth_user'].'\' order by created desc';
  $result = mysql_query($sql, $conn);

  print 'Your stories: ';
  print mysql_num_rows($result);
  print ' (<a href="story.php">Add new</a>)';
  print '</p><br /><br />';
  
  if (mysql_num_rows($result)) {
    print '<table>';
    print '<tr><th>Headline</th><th>Page</th>';
    print '<th>Created</th><th>Last modified</th></tr>';
    while ($qry = mysql_fetch_array($result)) {
      print '<tr>';
      print '<td>';
      print $qry['headline'];
      print '</td>';
      print '<td>';
      print $qry['page'];
      print '</td>';
      print '<td>';
      print date('M d, H:i', $qry['created']);
      print '</td>';
      print '<td>';
      print date('M d, H:i', $qry['modified']);
      print '</td>';
      print '<td>';
      if ($qry['published'])
        print '[Published '.date('M d, H:i', $qry['published']).']';
      else {
        print '[<a href="story.php?story='.$qry['id'].'">edit</a>] ';
        print '[<a href="delete_story.php?story='.$qry['id'].'">delete</a>] ';
        print '[<a href="keywords.php?story='.$qry['id'].'">keywords</a>]';
      }
      print '</td>';
      print '</tr>';
    }
    print '</table>';
  }

}
?>
