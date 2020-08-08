<?php
  //include our function set
  include ('book_sc_fns.php');

  // The shopping cart needs sessions, so start one
  session_start();

  do_html_header('Checkout');
  
  if($HTTP_SESSION_VARS['cart']&&array_count_values($HTTP_SESSION_VARS['cart']))
  {
    display_cart($HTTP_SESSION_VARS['cart'], false, 0);
    display_checkout_form();
  }
  else
    echo '<p>There are no items in your cart</p>';
 
  display_button('show_cart.php', 'continue-shopping', 'Continue Shopping');  

  do_html_footer();
?>