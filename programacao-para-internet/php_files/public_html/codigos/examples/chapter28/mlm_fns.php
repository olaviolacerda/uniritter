<?php

// do we already have a record of this subscriber?
function subscriber_exists($email)
{
  if(!$email)
    return false;

  if(!db_connect())
    return false;

  $query = "select count(*) from subscribers where email = '$email'";

  $result = mysql_query($query);
        if(!$result)
    return false;

  return (mysql_result($result, 0, 0)>0);
}

// is this email address subscribed to this list?
function subscribed($email, $listid)
{
  if(!$email||!$listid)
    return false;

  if(!db_connect())
    return false;

  $query = "select count(*) from sub_lists where email = '$email'
            and listid = $listid";

  $result = mysql_query($query);
        if(!$result)
    return false;

  return (mysql_result($result, 0, 0)>0);
}

// is this listid the id of a list?
function list_exists($listid)
{
  if(!$listid)
    return false;

  if(!db_connect())
    return false;

  $query = "select count(*) from lists where listid = '$listid'";

  $result = mysql_query($query);
        if(!$result)
    return false;

  return (mysql_result($result, 0, 0)>0);
}

// get the name of the person with this email
function get_real_name($email)
{
  if(!$email)
    return false;

  if(!db_connect())
    return false;

  $query = "select realname from subscribers where email = '$email'";

  $result = mysql_query($query);
        if(!$result)
    return false;

  return trim(mysql_result($result, 0, 0));
}

// get the type (HTML or Text) that this person wants email in
function get_mimetype($email)
{
  if(!$email)
    return false;

  if(!db_connect())
    return false;

  $query = "select mimetype from subscribers where email = '$email'";

  $result = mysql_query($query);
        if(!$result)
    return false;

  return trim(mysql_result($result, 0, 0));
}

// subscribe this email address to this list
function subscribe($email, $listid)
{
  if(!$email||!$listid||!list_exists($listid)||!subscriber_exists($email))
    return false;

  //if already subscribed exit
  if(subscribed($email, $listid))
    return false;

  if(!db_connect())
    return false;

  $query = "insert into sub_lists values ('$email', $listid)";

  $result = mysql_query($query);
        return $result;
}

// unsubscribe this email address from this list
function unsubscribe($email, $listid)
{
  if(!$email||!$listid)
    return false;

  if(!db_connect())
    return false;

  $query = "delete from sub_lists where email = '$email' and listid = $listid";

  $result = mysql_query($query);
  return $result;
}

// load the data stored about this mail from the database
function load_mail_info($mailid)
{
  if(!$mailid)
    return false;

  if(!db_connect())
    return false;

  $query = "select subject, listid, status, sent from mail
            where mailid = $mailid";

  $result = mysql_query($query);

  if(!$result)
  {
    echo "Cannot retrieve this mail $query";
    return false;
  }
  return mysql_fetch_array($result);

}

// load the data stored about this list from the database
function load_list_info($listid)
{
  if(!$listid)
    return false;

  if(!db_connect())
    return false;

  $query = "select listname, blurb from lists where listid = $listid";
  $result = mysql_query($query);
        if(!$result)
  {
    echo 'Cannot retrieve this list';
    return false;
  }
  $info =  mysql_fetch_array($result);

  $query = "select count(*) from sub_lists where listid = $listid";
  $result = mysql_query($query);
        if($result)
  {
    $info['subscribers'] = mysql_result($result, 0, 0);
  }
  $query = "select count(*) from mail where listid = $listid
            and status = 'SENT'";
  $result = mysql_query($query);
        if($result)
  {
    $info['archive'] = mysql_result($result, 0, 0);
  }
  return $info;
}


// get the name that belongs to this list id
function get_list_name($listid)
{
  if(!$listid)
    return false;

  if(!db_connect())
    return false;

  $query = "select listname from lists where listid = $listid";
  $result = mysql_query($query);
        if(!$result)
  {
    return false;
  }
  return mysql_result($result, 0);
}




// add a new list to the database
function store_list($admin_user, $details)
{
  if(!filled_out($details))
  {
    echo 'All fields must be filled in.  Try again.<br /><br />';
    return false;
  }
  else
  {
    if(!check_admin_user($admin_user))
      return false;  
      // how did this function get called by somebody not logged in as admin?
    
    if(!db_connect())
    { 
      return false;
    }
    
    $query = "select count(*) from lists where listname = '".$details['name']."'";
    $result = mysql_query($query);
    if(mysql_result($result, 0, 0) > 0)
    {
      echo 'Sorry, there is already a list with this name.';
      return false;
    }
    
    $query = "insert into lists values (NULL, 
                                       '".$details['name']."',
                                       '".$details['blurb']."')";

    $result = mysql_query($query);
    return $result; 
  }
}

// get the lists that this user is subscribed to
function get_subscribed_lists($email)
{
  $list = array();  

  $query = "select lists.listid, listname from sub_lists, lists 
            where email='$email' and lists.listid = sub_lists.listid 
            order by listname";

  if(db_connect())
  {
    $result = mysql_query($query);
    if(!$result)
      echo '<p>Unable to get list from database.';
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      array_push($list, array(mysql_result($result, $i, 0),
                              mysql_result($result, $i, 1)));
    }
  }
  return $list;
}

//get the lists that this user is *not* subscribed to 
function get_unsubscribed_lists($email)
{
  $list = array();  

  $query = "select lists.listid, listname, email from lists left join sub_lists 
                   on lists.listid = sub_lists.listid 
                   and email='$email' where email is NULL order by listname";
  if(db_connect())
  {
    $result = mysql_query($query);
    if(!$result)
      echo '<p>Unable to get list from database.';
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      array_push($list, array(mysql_result($result, $i, 0), 
                 mysql_result($result, $i, 1)));
    }
  }
  return $list;
}

// get all lists 
function get_all_lists()
{
  $list = array();  

  $query = 'select listid, listname from lists order by listname';

  if(db_connect())
  {
    $result = mysql_query($query);
    if(!$result)
      echo "<p>Unable to get list from database - $query.";
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      array_push($list, array(mysql_result($result, $i, 0), 
                              mysql_result($result, $i, 1)));
    }
  }
  return $list;
} 

function get_archive($listid)
{
  //returns an array of the archived mail for this list
  //array has rows like (mailid, subject)

  $list = array();  
  $listname = get_list_name($listid);
  
  $query = "select mailid, subject, listid from mail 
            where listid = $listid and status = 'SENT' order by sent"; 

  if(db_connect())
  {
    $result = mysql_query($query);
    if(!$result)
    {
      echo "<p>Unable to get list from database - $query.";
      return false;
    }
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      $row = array(mysql_result($result, $i, 0), 
                   mysql_result($result, $i, 1), $listname, $listid); 
      array_push($list, $row);
    }
  }
  return $list;
} 

// get the list of mail created, but not yet sent
function get_unsent_mail($email)
{
  if(!check_admin_user($email))
  {
    return false;
  }
  
  $list = array();  

  $query = "select mailid, subject, listid from mail 
            where status = 'STORED' or status = 'TESTED' order by modified"; 

  if(db_connect())
  {
    $result = mysql_query($query);
    if(!$result)
    {
      echo '<p>Unable to get list from database.';
      return false;
    }
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      array_push($list, array(mysql_result($result, $i, 0), 
                              mysql_result($result, $i, 1), 
                              get_list_name(mysql_result($result, $i, 2)),
                              mysql_result($result, $i, 2)
                              )
                 );
    }
  }
  return $list;
} 

// add a new subscriber to the database, or let a user modify their data
function store_account($normal_user, $admin_user, $details)
{
  if(!filled_out($details))
  {
    echo 'All fields must be filled in.  Try again.<br /><br />';
    return false;
  }
  else
  {
    if(subscriber_exists($details['email']))
    {
      //check logged in as the user they are trying to change
      if(get_email()==$details['email'])
      {
        $query = "update subscribers set realname = '$details[realname]',
                                         mimetype = '$details[mimetype]'
                  where email = '" . $details[email] . "'";
        if(db_connect() && mysql_query($query))
        {
          return true;
        }
        else
        {
          echo 'could not store changes.<br /><br /><br /><br /><br /><br />';
          return false;
        }
      }
      else
      {
        echo '<p>Sorry, that email address is already registered here.';
        echo '<p>You will need to log in with that address to change '
             .' its settings.';
        return false;                 
      }      
    }
    else // new account
    {
      $query = "insert into subscribers 
                        values ('$details[email]',
                        '$details[realname]',
                        '$details[mimetype]',
                         password('$details[new_password]'),
                                                0)";          
      if(db_connect() && mysql_query($query))
      {
        return true;
      }
      else
      {
        echo 'Could not store new account.<br /><br /><br /><br /><br /><br />';
        return false;
      }
    }
  }
}

// create the message from the stored DB entries and files
// send test messages to the administrator, or real messages to the whole list
function send($mailid, $admin_user)
{
  if(!check_admin_user($admin_user))
    return false;
  
  if(!($info = load_mail_info($mailid)))
  { 
    echo "Cannot load list information for message $mailid";
    return false;
  }
  $subject = $info[0];
  $listid = $info[1];
  $status = $info[2];
  $sent = $info[3];
    
  $from_name = 'Pyramid MLM';
      
  $from_address = 'return@address';
    
  $query = "select email from sub_lists where listid = $listid";
  
  $result = mysql_query($query);
  if (!$result)
  {
    echo $query;
    return false;  
  }
  else if (mysql_num_rows($result)==0)
  {
    echo "There is nobody subscribed to list number $listid";
    return false; 
  }
  else
  {
    // include PEAR mail classes
    include('Mail.php');
    include('Mail/mime.php');

    // instantiate MIME class and pass it the carriage return/line feed 
    // character used on this system
    $message = new Mail_mime("\r\n");

    // read in the text version of the newsletter
    $textfilename = "archive/$listid/$mailid/text.txt";
    $tfp = fopen($textfilename, "r");
    $text = fread($tfp, filesize($textfilename));
    fclose($tfp);

    // read in the HTML version of the newsletter
    $htmlfilename = "archive/$listid/$mailid/index.html";
    $hfp = fopen($htmlfilename, "r");
    $html = fread($hfp, filesize($htmlfilename));
    fclose($hfp);

    // add HTML and text to the mimemail object
    $message->setTXTBody($text);
    $message->setHTMLBody($html);

    // get the list of images that relate to this message
    $query = "select path, mimetype from images where mailid = $mailid";
    if(db_connect())
    {
      $result = mysql_query($query);
      if(!$result)
      {
        echo '<p>Unable to get image list from database.';
        return false;
      }
      $num = mysql_numrows($result);
      for($i = 0; $i<$num; $i++)
      {  
        //load each image from disk
        $imgfilename = "archive/$listid/$mailid/".mysql_result($result, $i, 0);
        $imgtype = mysql_result($result, $i, 1);

        // add each image to the object
        $message->addHTMLImage($imgfilename, $imgtype, $imgfilename, true);
      }
    }  
    
    // create message body
    $body = $message->get();  

    // create message headers
    $from = '"'.get_real_name($admin_user).'" <'.$admin_user.'>';
    $hdrarray = array(              
                 'From'    => $from,
                 'Subject' => $subject);

    $hdrs = $message->headers($hdrarray);

    // create the actual sending object
    $sender =& Mail::factory('mail');
 
    if($status == 'STORED')
    {
      
      // send the HTML message to the administrator
      $sender->send($admin_user, $hdrs, $body);
      
      // send the plain text version of the message to administrator
      mail($admin_user, $subject, $text, 'From: "'.get_real_name($admin_user).'" <'.$admin_user.">");

      echo "Mail sent to $admin_user"; 

      // mark newsletter as tested
      $query = "update mail set status = 'TESTED' where mailid = $mailid";
      if(db_connect())
      {
        $result = mysql_query($query);
      }    
    
      echo '<p>Press send again to send mail to whole list.<center>';
      display_button('send', "&id=$mailid");
      echo '</center>';
    }    
    else if($status == 'TESTED')
    {
      //send to whole list
    
      $query = "select subscribers.realname, sub_lists.email, 
                       subscribers.mimetype  
                from sub_lists, subscribers 
                where listid = $listid and 
                      sub_lists.email = subscribers.email";
                      
      if(!db_connect())
        return false;
    
      $result = mysql_query($query);
      if(!$result)
        echo '<p>Error getting subscriber list';
      
      $count = 0;      
      // for each subscriber
      while( $subscriber = mysql_fetch_row($result) )
      {
        if($subscriber[2]=='H')
        {
          //send HTML version to people who want it
          $sender->send($subscriber[1], $hdrs, $body);
        }
        else
        {
          //send text version to people who don't want HTML mail
          mail($subscriber[1], $subject, $text, 
                         'From: "'.get_real_name($admin_user).'" <'.$admin_user.">");
        }
        $count++; 
      }
        
      $query = "update mail set status = 'SENT', sent = now() 
                where mailid = $mailid";
      if(db_connect())
      {
        $result = mysql_query($query);
      }
      echo "<p>A total of $count messages were sent.";    
    }
    else if($status == 'SENT')
    {
      echo '<p>This mail has already been sent.';    
    }
  }
}
