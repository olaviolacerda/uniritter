<?php
// this application can connect via XML/HTTP or SOAP
// define one version of METHOD to choose.
define('METHOD', 'SOAP');
//define('METHOD', 'XML/HTTP');

// make sure to create a cache directory an make it writable
define('CACHE', 'cache'); // path to cached files
define('ASSOCIATEID', 'webservices-20'); //put your associate id here
define('DEVTAG', 'XXXXXXXXXXXXXX'); // put your developer tag here

//give an error if software is run with the dummy devtag
if(DEVTAG=='XXXXXXXXXXXXXX')
  die ('You need to sign up for an Amazon.com developer tag at<a href =
       "http://associates.amazon.com/exec/panama/associates/join/
       developer/kit.html">Amazon</a>
       when you install this software.  You should probably sign up 
       for an associate ID at the same time. Edit the file constants.php.');
?>
