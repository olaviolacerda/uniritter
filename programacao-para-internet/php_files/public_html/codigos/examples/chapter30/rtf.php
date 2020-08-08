<?php
  //create short variable names
  $name = $HTTP_POST_VARS['name'];
  $score = $HTTP_POST_VARS['score'];
  // check we have the parameters we need
  if( !$name || !$score )
  {
    echo '<h1>Error:</h1>This page was called incorrectly';
  }
  else
  {
    //generate the headers to help a browser choose the correct application
    header( 'Content-type: application/msword' );
    header( 'Content-Disposition: inline, filename=cert.rtf');

    $date = date( 'F d, Y' );
  
    // open our template file
    $filename = 'PHPCertification.rtf';
    $fp = fopen ( $filename, 'r' );

    //read our template into a variable
    $output = fread( $fp, filesize( $filename ) );
  
    fclose ( $fp );
  
    // replace the place holders in the template with our data
    $output = str_replace( '<<NAME>>', strtoupper( $name ), $output );
    $output = str_replace( '<<Name>>', $name, $output );
    $output = str_replace( '<<score>>', $score, $output );
    $output = str_replace( '<<mm/dd/yyyy>>', $date, $output );
   
    // send the generated document to the browser
    echo $output;
  }
?>