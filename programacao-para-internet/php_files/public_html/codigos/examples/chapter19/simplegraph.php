<?php
// set up image 
  $height = 200;
  $width = 200;
  $im = ImageCreate($width, $height);
  $white = ImageColorAllocate ($im, 255, 255, 255);
  $black = ImageColorAllocate ($im, 0, 0, 0);

// draw on image  
  ImageFill($im, 0, 0, $black);
  ImageLine($im, 0, 0, $width, $height, $white);
  ImageString($im, 4, 50, 150, 'Sales', $white);

// output image
  Header ('Content-type: image/png');
  ImagePng ($im);
  
// clean up 
  ImageDestroy($im);
?>