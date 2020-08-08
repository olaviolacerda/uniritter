<?php

  include ('book_sc_fns.php');
  // The shopping cart needs sessions, so start one
  session_start();

  do_html_header("Checkout");
  //create short variable names
  $name = $HTTP_POST_VARS['name'];
  $address = $HTTP_POST_VARS['address'];
  $city = $HTTP_POST_VARS['city'];
  $zip = $HTTP_POST_VARS['zip'];
  $country = $HTTP_POST_VARS['country'];

  // if filled out
  if($HTTP_SESSION_VARS['cart']&&$name&&$address&&$city&&$zip&&$country)
  {
    // able to insert into database
    if( insert_order($HTTP_POST_VARS)!=false )
    {
      //display cart, not allowing changes and without pictures 
      display_cart($HTTP_SESSION_VARS['cart'], false, 0);

      display_shipping(calculate_shipping_cost());  

      //get credit card details
      display_card_form($name);

      display_button('show_cart.php', 'continue-shopping', 'Continue Shopping');  
    }
    else
    {
      echo 'Could not store data, please try again.';
      display_button('checkout.php', 'back', 'Back');
    }
  }
  else
  {
    echo 'You did not fill in all the fields, please try again.<hr />';
    display_button('checkout.php', 'back', 'Back');
  } 
 
  do_html_footer();
?>