<?php
  include ('book_sc_fns.php');
  // The shopping cart needs sessions, so start one
  session_start();

  @ $new = $HTTP_GET_VARS['new'];

  if($new)
  {
    //new item selected
    if(!isset($HTTP_SESSION_VARS['cart']))
    {
      $HTTP_SESSION_VARS['cart'] = array();
      $HTTP_SESSION_VARS['items'] = 0;
      $HTTP_SESSION_VARS['total_price'] ='0.00';
    }
    if(isset($HTTP_SESSION_VARS['cart'][$new]))
      $HTTP_SESSION_VARS['cart'][$new]++;
    else 
      $HTTP_SESSION_VARS['cart'][$new] = 1;
    $HTTP_SESSION_VARS['total_price'] =       
                                      calculate_price($HTTP_SESSION_VARS['cart']);
    $HTTP_SESSION_VARS['items'] = calculate_items($HTTP_SESSION_VARS['cart']);

  }
  if(isset($HTTP_POST_VARS['save']))
  {   
    foreach ($HTTP_SESSION_VARS['cart'] as $isbn => $qty)
    {
      if($HTTP_POST_VARS[$isbn]=='0')
        unset($HTTP_SESSION_VARS['cart'][$isbn]);
      else 
        $HTTP_SESSION_VARS['cart'][$isbn] = $HTTP_POST_VARS[$isbn];
    }
    $HTTP_SESSION_VARS['total_price'] = 
calculate_price($HTTP_SESSION_VARS['cart']);
    $HTTP_SESSION_VARS['items'] = calculate_items($HTTP_SESSION_VARS['cart']);
  }

  do_html_header('Your shopping cart');

  if($HTTP_SESSION_VARS['cart']&&array_count_values($HTTP_SESSION_VARS['cart']))
    display_cart($HTTP_SESSION_VARS['cart']);
  else
  {
    echo '<p>There are no items in your cart</p>';
    echo '<hr />';
  }
  $target = 'index.php';

  // if we have just added an item to the cart, continue shopping in that category
  if($new)
  {
    $details =  get_book_details($new);
    if($details['catid'])    
      $target = 'show_cat.php?catid='.$details['catid']; 
  }
  display_button($target, 'continue-shopping', 'Continue Shopping');  

  // use this if SSL is set up
  // $path = $HTTP_SERVER_VARS['PHP_SELF'];
  // $server = $HTTP_SERVER_VARS['SERVER_NAME'];
  // $path = str_replace('show_cart.php', '', $path);
  // display_button('https://'.$server.$path.'checkout.php', 
                    'go-to-checkout', 'Go To Checkout');  

  // if no SSL use below code
  display_button('checkout.php', 'go-to-checkout', 'Go To Checkout');  

  
  do_html_footer();
?>