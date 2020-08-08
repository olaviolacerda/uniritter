<?php
 // set date for calculation
 $day = 18;
 $month = 9;
 $year = 1972;

 // remember you need bday as day month and year
 $bdayunix = mktime ('', '', '', $month, $day, $year); 
 // get unix ts for bday 
 $nowunix = time(); // get unix ts for today
 $ageunix = $nowunix - $bdayunix; // work out the difference
 $age = floor($ageunix / (365 * 24 * 60 * 60)); // convert from seconds to years

 echo "Age is $age";
?>