<?php
$subject = "abcdef";
$pattern = '/def/';
preg_match($pattern, $subject, $matches, PREG_OFFSET_CAPTURE);
echo "<pre>";
print_r($matches);


$subject = "scjaviel@gmail.com";
$pattern = '/[a-z]+/';
preg_match($pattern, $subject, $matches, PREG_OFFSET_CAPTURE);
print_r($matches);
echo "</re>";


?>