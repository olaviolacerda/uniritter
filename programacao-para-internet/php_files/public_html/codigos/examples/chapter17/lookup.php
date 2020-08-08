<html>
<head>
  <title>Stock Quote from NASDAQ</title>
</head>
<body>
<?php
  // choose stock to look at
  $symbol='AMZN';
  echo "<h1>Stock Quote for $symbol</h1>";

  $theurl='http://www.amex.com/equities/listCmp/EqLCDetQuote.jsp?Product_Symbol=AMZN';


  if (!($fp = fopen($theurl, 'r')))
  {
    echo 'Could not open URL';
    exit;
  }
  $contents = fread($fp, 1000000);
  fclose($fp);

  //echo $contents;

  // find the part of the page we want and output it
  $pattern = "(\\\$[0-9 ]+\\.[0-9]+)";
  if (eregi($pattern, $contents, $quote))
  { 
    echo "$symbol was last sold at: ";
    echo $quote[1];
  } else 
  {
    echo 'No quote available';
  };

  // acknowledge source
  echo '<br />'
       .'This information retrieved from <br />'
       ."<a href=\"$theurl\">$theurl</a><br />"
       .'on '.(date('l jS F Y g:i a T'));
?>
</body>
</html>