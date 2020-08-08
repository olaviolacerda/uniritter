<?php
  include ('book_sc_fns.php');
  // The shopping cart needs sessions, so start one
  session_start();

  do_html_header('Checkout');

  $card_type = $HTTP_POST_VARS['card_type'];
  $card_number = $HTTP_POST_VARS['card_number'];
  $card_month = $HTTP_POST_VARS['card_month'];
  $card_year = $HTTP_POST_VARS['card_year'];
  $card_name = $HTTP_POST_VARS['card_name'];

  if($HTTP_SESSION_VARS['cart']&&$card_type&&$card_number&&
     $card_month&&$card_year&&$card_name )
  {
    //display cart, not allowing changes and without pictures 
    display_cart($HTTP_SESSION_VARS['cart'], false, 0);

    display_shipping(calculate_shipping_cost());  

    if(process_card($HTTP_POST_VARS))
    {
      //empty shopping cart
      session_destroy();
      echo 'Thankyou for shopping with us.  Your order has been placed.';
      display_button('index.php', 'continue-shopping', 'Continue Shopping');  
    }
    else
    {
    echo 'Could not process your card. ';
    echo 'Please contact the card issuer or try again.';
      display_button('purchase.php', 'back', 'Back');
    }
  }
  else
  {
    echo 'You did not fill in all the fields, please try again.<hr />';
    display_button('purchase.php', 'back', 'Back');
  } 
 
  do_html_footer();
?>