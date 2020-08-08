<html>
<head>
  <title>Uploading...</title>
</head>
<body>
<h1>Uploading file...</h1>
<?php

  // $userfile is where file went on webserver
  $userfile = $HTTP_POST_FILES['userfile']['tmp_name'];

  // $userfile_name is original file name
  $userfile_name = $HTTP_POST_FILES['userfile']['name'];

  // $userfile_size is size in bytes
  $userfile_size = $HTTP_POST_FILES['userfile']['size'];

  // $userfile_type is mime type e.g. image/gif
  $userfile_type = $HTTP_POST_FILES['userfile']['type'];

  // $userfile_error is any error encountered
  $userfile_error = $HTTP_POST_FILES['userfile']['error'];
// userfile_error was introduced at PHP 4.2.0
// use this code with newer versions
  if ($userfile_error > 0)
  {
    echo 'Problem: ';
    switch ($userfile_error)
    {
      case 1:  echo 'File exceeded upload_max_filesize';  break;
      case 2:  echo 'File exceeded max_file_size';  break;
      case 3:  echo 'File only partially uploaded';  break;
      case 4:  echo 'No file uploaded';  break;
    }
    exit;
  }
// end of code for 4.2.0

// prior to 4.2.0 use manual error checking as below
/*
  if ($userfile=='none')
  {
    echo 'Problem: no file uploaded';
    exit;
  }
  
  if ($userfile_size==0)
  {
    echo 'Problem: uploaded file is zero length';
    exit;
  }
*/
// end older version error checking

// one more check: does the file have the right MIME type?

  if ($userfile_type != 'text/plain')
  {
    echo 'Problem: file is not plain text';
    exit;
  }

// put the file where we'd like it
  $upfile = '/uploads/'.$userfile_name;

// is_uploaded_file and move_uploaded_file added at version 4.0.3
  if (is_uploaded_file($userfile)) 
  {
     if (!move_uploaded_file($userfile, $upfile))
     {
        echo 'Problem: Could not move file to destination directory';
        exit;
     }
  } 
  else 
  {
    echo 'Problem: Possible file upload attack. Filename: '.$userfile_name;
    exit;
  }

// older versions code as recommended in PHP manual
/*
  function is_uploaded_file($filename) {
    if (!$tmp_file = get_cfg_var('upload_tmp_dir')) {
        $tmp_file = dirname(tempnam('', ''));
    }
    $tmp_file .= '/' . basename($filename);
    // User might have trailing slash in php.ini... 
    return (ereg_replace('/+', '/', $tmp_file) == $filename);
  }

  if (is_uploaded_file($userfile)) 
  {
    copy($userfile, $upfile);
  } else 
  {
    echo 'Problem: Possible file upload attack. Filename: '.$userfile_name';
  }
*/
// end older version

  echo 'File uploaded successfully<br /><br />'; 

// reformat the file contents
  $fp = fopen($upfile, 'r');
  $contents = fread ($fp, filesize ($upfile));
  fclose ($fp);
 
  $contents = strip_tags($contents);
  $fp = fopen($upfile, 'w');
  fwrite($fp, $contents);
  fclose($fp);
// show what was uploaded
  echo 'Preview of uploaded file contents:<br /><hr />';
  echo $contents;
  echo '<br /><hr />';

?>
</body>
</html>