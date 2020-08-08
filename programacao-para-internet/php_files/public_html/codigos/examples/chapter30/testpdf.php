<?php
  //create file
  $fp = fopen('hello.pdf', 'w');
  if(!$fp)
  {
    echo "Error: could not create the PDF file";
    exit;
  }

  // start the pdf document
  $pdf = pdf_open($fp);
  pdf_set_info($pdf, "Creator", "pdftest.php");
  pdf_set_info($pdf, "Author", "Luke Welling and Laura Thomson");
  pdf_set_info($pdf, "Title", "Hello World (PHP)");

  // US letter is 11" x 8.5" and there are approximately 72 points per inch
  pdf_begin_page($pdf, 8.5*72, 11*72);
  pdf_add_outline($pdf, 'Page 1');
  $font = pdf_findfont($pdf, 'Times-Roman', 'host', 0);
  pdf_setfont($pdf, $font, 24);
  pdf_set_text_pos($pdf, 50, 700);

  // write text
  pdf_show($pdf,'Hello,world!');
  pdf_continue_text($pdf,'(says PHP)');

  // end the document
  pdf_end_page($pdf);
  pdf_close($pdf);
  fclose($fp);
   
  // display a link to download
  echo "download the pdf <a href = 'hello.pdf'>here</a>";
?>    