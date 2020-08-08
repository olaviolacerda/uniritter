<?php
$subject = "abcdef";
$pattern = '/def/';
preg_match($pattern, $subject, $matches, PREG_OFFSET_CAPTURE, 3);
print_r($matches);


$subject = "scjaviel@gmail.com";
$pattern = '/[a-b]/';
preg_match($pattern, $subject, $matches, PREG_OFFSET_CAPTURE, 3);
print_r($matches);


?>