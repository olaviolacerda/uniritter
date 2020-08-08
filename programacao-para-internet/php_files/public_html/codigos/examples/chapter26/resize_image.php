<?php

$image = $HTTP_GET_VARS['image'];

if (!$max_width)
  $max_width = 80;
if (!$max_height)
  $max_height = 60;

$size = GetImageSize($image);
$width = $size[0];
$height = $size[1];

$x_ratio = $max_width / $width;
$y_ratio = $max_height / $height;

if ( ($width <= $max_width) && ($height <= $max_height) ) {
  $tn_width = $width;
  $tn_height = $height;
}
else if (($x_ratio * $height) < $max_height) {
  $tn_height = ceil($x_ratio * $height);
  $tn_width = $max_width;
}
else {
  $tn_width = ceil($y_ratio * $width);
  $tn_height = $max_height;
}

$src = ImageCreateFromJpeg($image);
$dst = ImageCreate($tn_width,$tn_height);
ImageCopyResized($dst, $src, 0, 0, 0, 0,
    $tn_width,$tn_height,$width,$height);
header('Content-type: image/jpeg');
ImageJpeg($dst, null, -1);
ImageDestroy($src);
ImageDestroy($dst);

?>