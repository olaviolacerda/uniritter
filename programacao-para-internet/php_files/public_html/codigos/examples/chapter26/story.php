<?php

include ('include_fns.php');

if (isset($HTTP_GET_VARS['story']))
  $s = get_story_record($HTTP_GET_VARS['story']);

?>

<form action="story_submit.php" method="post" enctype="multipart/form-data">
<input type="hidden" name="story" value="<?php print $HTTP_GET_VARS['story'];?>">
<input type="hidden" name="destination" 
value="<?php print $HTTP_SERVER_VARS['HTTP_REFERER'];?>">
<table>

<tr>
  <td align="center">Headline<td>
</tr>
<tr>
  <td><input size="80" name="headline"
              value="<?php print $s['headline'];?>"></td>
</tr>

<tr>
  <td align="center">Page</td>
</tr>
<tr>
  <td align="center"><?php print query_select('page', 
             "select p.code, p.description 
              from pages p, writer_permissions wp, stories s
              where p.code = wp.page
              and wp.writer = s.writer
              and s.id =".$HTTP_GET_VARS['story'], $s['page']);?></td>
</tr>

<tr>
  <td align="center">Story text (can contain HTML tags)</td>
</tr>
<tr>
  <td><textarea cols="80" rows="7" name="story_text"
           wrap="virtual"><?php print $s['story_text'];?></textarea>
  </td>
</tr>

<tr>
  <td align="center">Or upload HTML file</td>
</tr>
<tr>
  <td align="center"><input type="file" name="html" size="40"></td>
</tr>

<tr>
  <td align="center">Picture</td>
</tr>
<tr>
  <td align="center"><input type="file" name="picture" size="40"></td>
</tr>

<?php 
if ($s[picture]) {
  $size   = getImageSize($s['picture']);
  $width  = $size[0];
  $height = $size[1];
?>
<tr>
  <td align="center">
    <img src="<?php print $s['picture'];?>" 
          width="<?php print $width;?>" height="<?php print $height;?>">
  </td>
</tr>
<?php } ?>


<tr>
  <td align="center"><input type="submit" value="Submit"></td>
</tr>

</table>
</form>