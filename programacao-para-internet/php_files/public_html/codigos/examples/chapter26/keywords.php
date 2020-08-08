<?php

include('include_fns.php');
session_start();

if (!check_auth_user()) {
?>
<FORM ACTION="login.php" METHOD=POST>
<TABLE BORDER=0>
<TR>
  <TD>Username</TD>
  <TD><INPUT SIZE=16 NAME="username"></TD>
</TR>
<TR>
  <TD>Password</TD>
  <TD><INPUT SIZE=16 TYPE="PASSWORD" NAME="password"></TD>
</TR>
</TABLE>
<INPUT TYPE=SUBMIT VALUE="Log in">
</FORM>
<?php
}
else {
  $conn = db_connect();
  $story = $HTTP_GET_VARS['story'];
  $s = get_story_record($story);
  print '<H2>Keywords for <i>'.$s['headline'].'</i></H2>';
?>
<FORM ACTION="keyword_add.php" METHOD=POST>
<INPUT TYPE=HIDDEN NAME="story" VALUE="<?php print $story;?>">
<INPUT SIZE=20 NAME="keyword">
<SELECT NAME="weight">
  <OPTION>10
  <OPTION>9
  <OPTION>8
  <OPTION>7
  <OPTION>6
  <OPTION>5
  <OPTION>4
  <OPTION>3
  <OPTION>2
  <OPTION>1
</SELECT>
<INPUT TYPE=SUBMIT VALUE="Add">
</FORM>

<?php

$sql = "select * from keywords where story = $story 
        order by weight desc, keyword";
$result = mysql_query($sql, $conn);
if (mysql_num_rows($result)) {
  print '<TABLE>';
  print '<TR><TH>Keyword</TH><TH>Weight</TH></TR>';
  while ($kwd = mysql_fetch_array($result)) {
    print '<TR><TD>';
    print $kwd['keyword'];
    print '</TD><TD>';
    print $kwd['weight'];
    print '</TD><TD>';
    print "[<A HREF=\"keyword_delete.php?story=$story&keyword=";
    print urlencode($kwd['keyword']);
    print '">del</A>]';
    print '</TD></TR>';
  }
  print '</TABLE>';
}

}
?>
