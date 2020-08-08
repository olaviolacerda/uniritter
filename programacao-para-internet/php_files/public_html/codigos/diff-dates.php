<?php 

function diffDate($d1, $d2, $type='', $sep='-')
{
 $d1 = explode($sep, $d1);
 $d2 = explode($sep, $d2);
 switch ($type)
 {
 case 'A':
 $X = 31536000;
 break;
 case 'M':
 $X = 2592000;
 break;
 case 'D':
 $X = 86400;
 break;
 case 'H':
 $X = 3600;
 break;
 case 'MI':
 $X = 60;
 break;
 default:
 $X = 1;
 }
 echo $d2[1];
echo $d2[2];
echo $d2[0];
 return floor( ( ( mktime(0, 0, 0, $d2[1], $d2[2], $d2[0]) - mktime(0, 0, 0, $d1[1], $d1[2], $d1[0] ) ) / $X ) );
}

$d1 = "2011-01-01";
$d2 = "2011-01-10";


echo diffDate($d1,$d2,'D');

?>