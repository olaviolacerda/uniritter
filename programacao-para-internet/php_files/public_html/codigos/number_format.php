<?php
$number = "1234.45";
$number = "1234,45";

$number = str_replace(",",".", $number);
$number = number_format($number, 2, ',','');
echo $number;
?>
