<?php
  //create short variable names
  $tireqty = $HTTP_POST_VARS['tireqty'];
  $oilqty = $HTTP_POST_VARS['oilqty'];
  $sparkqty = $HTTP_POST_VARS['sparkqty'];
  $address = $HTTP_POST_VARS['address'];
  
  $DOCUMENT_ROOT = $HTTP_SERVER_VARS['DOCUMENT_ROOT'];
?>
<html>
<head>
  <title>Bob's Auto Parts - Order Results</title>
</head>
<body>
<h1>Bob's Auto Parts</h1>
<h2>Order Results</h2>
<?php 
  $totalqty = 0;
  $totalqty += $tireqty;
  $totalqty += $oilqty;
  $totalqty += $sparkqty;
  
  $totalamount = 0.00;
 
  define('TIREPRICE', 100);
  define('OILPRICE', 10);
  define('SPARKPRICE', 4);

  $date = date('H:i, jS F');
 
  echo '<p>Order processed at ';
  echo $date;
  echo '<br />';
  echo '<p>Your order is as follows:';
  echo '<br />';

  if( $totalqty == 0 )
  {
    echo 'You did not order anything on the previous page!<br />';
  }
  else
  {
    if ( $tireqty>0 )
      echo $tireqty.' tires<br />';
    if ( $oilqty>0 )
      echo $oilqty.' bottles of oil<br />';
    if ( $sparkqty>0 )
      echo $sparkqty.' spark plugs<br />';
  }

  $total = $tireqty * TIREPRICE + $oilqty * OILPRICE + $sparkqty * SPARKPRICE; 
  $total=number_format($total, 2, '.', ' ');
 
  echo '<P>Total of order is '.$total.'</p>';
  
  echo '<P>Address to ship to is '.$address.'<br />';

  $outputstring = $date."\t".$tireqty." tires \t".$oilqty." oil\t"
                  .$sparkqty." spark plugs\t\$".$total
                  ."\t". $address."\n";

  // open file for appending
  $fp = fopen("$DOCUMENT_ROOT/../orders/orders.txt", 'a');

  flock($fp, LOCK_EX); 
 
  if (!$fp)
  {
    echo '<p><strong> Your order could not be processed at this time.  '
         .'Please try again later.</strong></p></body></html>';
    exit;
  } 

  fwrite($fp, $outputstring);
  flock($fp, LOCK_UN); 
  fclose($fp);

  echo '<p>Order written.</p>'; 

?>
</body>
</html>
