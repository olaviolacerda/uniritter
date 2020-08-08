<?php
session_start();
require_once('constants.php');
require('topbar.php');
require ('categoryfunctions.php');
showCategories('books');
?>
<h1>About Tahuayo.com</h1>

<p>The Tahuayo River is a tributary of the Amazon River.  <a href = 'index.com'>Tahuayo.com</a> is an interface to
<a href='http://www.amazon.com/'>Amazon.com</a>.

<p>You can purchase any books stocked by Amazon.com at Tahuayo.com, but it is not really intended to be a profit generating site.
It exists to demonstrate using Amazon's <a href = 'http://associates.amazon.com/exec/panama/associates/ntg/browse/-/1067662/ref=gw_hp_ls_1_3/104-9837819-3411136'>Web Services</a> interface.
The site is built using <a href='http://www.php.net/'>PHP</a> and connects to Amazon using XML/HTTP and SOAP.

<p>You can find out more about this site, and obtain the complete source code in Chapter 31 of <a href = 'index.php?action=detail&ASIN=067232525X'><i>PHP and MySQL Web Development 2nd Edition</i></a> by Luke Welling and Laura Thomson.

<hr>
<?php require('bottom.php'); ?>


