<html>
<head>
  <title>Browse Directories</title>
</head>
<body>
<h1>Browsing</h1>
<?php
  $current_dir = '/uploads/';
  $dir = opendir($current_dir);

  echo "Upload directory is $current_dir<br />";
  echo 'Directory Listing:<br /><hr /><br />';
  while ($file = readdir($dir))
  {
      echo "$file<br />";
  }
  echo '<hr /><br />';
  closedir($dir);
?>
</body>
</html>