<?php
/*******************************************
  Database query to get poll info 
*******************************************/

// get vote from form
$vote=$HTTP_POST_VARS['vote'];

// log in to database 
if (!$db_conn = @mysql_connect('localhost', 'poll', 'poll'))
{
  echo 'Could not connect to db<br />';
  exit;
};
@mysql_select_db('poll');

if (!empty($vote))  // if they filled the form out, add their vote
{
  $vote = addslashes($vote); 
  $query = "update poll_results
            set num_votes = num_votes + 1
            where candidate = '$vote'";
  if(!($result = @mysql_query($query, $db_conn)))
  {
    echo 'Could not connect to db<br />';
    exit;
  }
};

// get current results of poll, regardless of whether they voted 
$query = 'select * from poll_results';
if(!($result = @mysql_query($query, $db_conn)))
{
  echo 'Could not connect to db<br />';
  exit;
}
$num_candidates = mysql_num_rows($result); 

// calculate total number of votes so far
$total_votes=0;
while ($row = mysql_fetch_object ($result)) 
{
    $total_votes +=  $row->num_votes;
}
mysql_data_seek($result, 0);  // reset result pointer


/*******************************************
  Initial calculations for graph 
*******************************************/
// set up constants
putenv('GDFONTPATH=C:\WINNT\Fonts');
$width=500;        // width of image in pixels - this will fit in 640x480
$left_margin = 50; // space to leave on left of image
$right_margin= 50; // ditto right   
$bar_height = 40;  
$bar_spacing = $bar_height/2; 
$font = 'arial';
$title_size= 16; // point
$main_size= 12; // point
$small_size= 12; // point
$text_indent = 10; // position for text labels on left

// set up initial point to draw from
$x = $left_margin + 60;  // place to draw baseline of the graph
$y = 50;		  // ditto 
$bar_unit = ($width-($x+$right_margin)) / 100;   // one "point" on the graph

// calculate height of graph - bars plus gaps plus some margin
$height = $num_candidates * ($bar_height + $bar_spacing) + 50;   

/*******************************************
  Set up base image 
*******************************************/
// create a blank canvas
$im = imagecreate($width,$height);   
     
// Allocate colors   
$white=ImageColorAllocate($im,255,255,255);   
$blue=ImageColorAllocate($im,0,64,128);   
$black=ImageColorAllocate($im,0,0,0);   
$pink = ImageColorAllocate($im,255,78,243); 

$text_color = $black;
$percent_color = $black;
$bg_color = $white;
$line_color = $black;
$bar_color = $blue;
$number_color = $pink;

// Create "canvas" to draw on 
ImageFilledRectangle($im,0,0,$width,$height,$bg_color);   

// Draw outline around canvas 
ImageRectangle($im,0,0,$width-1,$height-1,$line_color);   

// Add title
$title = 'Poll Results';
$title_dimensions = ImageTTFBBox($title_size, 0, $font, $title);
$title_length = $title_dimensions[2] - $title_dimensions[0];
$title_height = abs($title_dimensions[7] - $title_dimensions[1]);
$title_above_line = abs($title_dimensions[7]);
$title_x = ($width-$title_length)/2;  // center it in x 
$title_y = ($y - $title_height)/2 + $title_above_line; // center in y gap
ImageTTFText($im, $title_size, 0, $title_x, $title_y, 
             $text_color, $font, $title);  

// Draw a base line from a little above first bar location 
// to a little below last  
ImageLine($im, $x, $y-5, $x, $height-15, $line_color);   

/*******************************************
  Draw data into graph 
*******************************************/
// Get each line of db data and draw corresponding bars   
while ($row = mysql_fetch_object ($result)) 
{
  if ($total_votes > 0)
    $percent = intval(round(($row->num_votes/$total_votes)*100));
  else 
    $percent = 0;

  // display percent for this value  
  ImageTTFText($im, $main_size, 0, $width-30, $y+($bar_height/2),
               $percent_color, $font, $percent.'%');  
  if ($total_votes > 0)
    $right_value = intval(round(($row->num_votes/$total_votes)*100));
  else
    $right_value = 0;

  // length of bar for this value   
  $bar_length = $x + ($right_value * $bar_unit);   

  // draw bar for this value   
  ImageFilledRectangle($im, $x, $y-2, $bar_length, $y+$bar_height, $bar_color);   

  // draw title for this value   
  ImageTTFText($im, $main_size, 0, $text_indent, $y+($bar_height/2), 
               $text_color, $font, "$row->candidate");  

  // draw outline showing 100% 
  ImageRectangle($im, $bar_length+1, $y-2, 
                ($x+(100*$bar_unit)), $y+$bar_height, $line_color);   

  // display numbers   
  ImageTTFText($im, $small_size, 0, $x+(100*$bar_unit)-50, $y+($bar_height/2),
               $number_color, $font, $row->num_votes.'/'.$total_votes);

  // move down to next bar
  $y=$y+($bar_height+$bar_spacing);   
}   

/*******************************************
  Display image 
*******************************************/
Header('Content-type:  image/png');
ImagePng($im);   


/*******************************************
  Clean up 
*******************************************/
ImageDestroy($im);   
?>   

