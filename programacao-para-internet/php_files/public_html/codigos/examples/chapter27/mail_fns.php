<?php
function retrieve_message($auth_user, $accountid, $messageid, $fullheaders)
{
  $message = array();
  
  if(!($auth_user && $messageid && $accountid))
    return false;
  
  $imap = open_mailbox($auth_user, $accountid);
  if(!$imap) 
    return false;      
  
  $header = imap_header($imap, $messageid);
  
  if(!$header) 
    return false;
  
  $message['body'] = imap_body($imap, $messageid);
  if(!$message['body']) 
    $message['body'] = "[This message has no body]\n\n\n\n\n\n";
    
  if($fullheaders)
    $message['fullheaders'] = imap_fetchheader($imap, $messageid);
  else
    $message['fullheaders'] = '';
  
  $message['subject'] = $header->subject;
  $message['fromaddress'] =   $header->fromaddress;
  $message['toaddress'] =   $header->toaddress;
  $message['ccaddress'] =   $header->ccaddress;
  $message['date'] =   $header->date;
    
  // note we can get more detailed information by using from and to 
  // rather than fromaddress and toaddress, but these are easier
  
  imap_close($imap); 
  return $message;
}

function account_exists($auth_user, $accountid)
{
  //does this user have an account with this id?
  
  $query = "select count(*) from accounts where username = '$auth_user' and accountid = $accountid";
  if(db_connect())
  {
    $result = mysql_query($query);
    return mysql_result($result, 0, 0);
  }
  return false;
}

function get_account_list($auth_user)
{
  // get an array of the account ids that belong to this user

  $query = "select accountid from accounts where username = '$auth_user'";
  $list = array();
  
  if(db_connect())
  {
    $result = mysql_query($query);
    $num = mysql_numrows($result);
    for($i = 0; $i<$num; $i++)
    {
      array_push($list, mysql_result($result, $i, 0));
    }
  }
  return $list;
}

function number_of_accounts($auth_user)
{
  // get the number of accounts that belong to this user
  
  $query = "select count(*) from accounts where username = '$auth_user'";

  if(db_connect())
  {
    $result = mysql_query($query);
      if($result)
        return mysql_result($result, 0, 0);
  }
  return 0;
}

function delete_account($auth_user, $accountid)
{
  //delete one of this user's accoutn from the DB

  $query = "delete from accounts where accountid='$accountid' and username = '$auth_user'";
  if(db_connect())
  {
    $result = mysql_query($query);
  }
  return $result;
}

function get_account_settings($auth_user, $accountid=0)
{
  //get an array containing the settings for this account
  
  $settings = array();
  if(db_connect())
  {
    if($accountid>0 && $accountid!='')
    {
      $query = "select * from accounts where accountid=$accountid and username = '$auth_user'";
    }
    else if (number_of_accounts($auth_user)==1)
	  {
      $query = "select * from accounts where username = '$auth_user'";
    }
    else
    {
      return false;
    }
    $result = mysql_query($query);
	  if($result)
    {
      $settings = mysql_fetch_array($result);
      return $settings;
    }
    else
      return false;
  }
  return false;
}

function get_accounts($auth_user)
{
  $list = array();
  if(db_connect())
  {
    $query = "select * from accounts where username = '$auth_user'";
    $result = mysql_query($query);
	  if($result)
    {
      while($settings = mysql_fetch_array($result))
        array_push( $list, $settings);
    }
    else
      return false;
  }
  return $list;
}


function store_account_settings($auth_user, $settings)
{
  if(!filled_out($settings))
  {
    echo 'All fields must be filled in.  Try again.<br /><br />';
    return false;
  }
  else
  {
    if($settings['account']>0)
      $query = "update accounts  set server = '$settings[server]',
                  port = $settings[port], type = '$settings[type]',
                  remoteuser = '$settings[remoteuser]', 
                  remotepassword = '$settings[remotepassword]' 
                where accountid = $settings[account] 
                  and username = '$auth_user'";
    else
      $query = "insert into accounts values ('$auth_user', 
                     '$settings[server]', $settings[port], 
                     '$settings[type]', '$settings[remoteuser]', 
                     '$settings[remotepassword]', NULL)";
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
}

function delete_message($auth_user, $accountid, $message_id)
{
  // delete a single message from the server
  
  $imap = open_mailbox($auth_user, $accountid);
  if($imap)
  {
    imap_delete($imap, $message_id);
    imap_expunge($imap);
    imap_close($imap);
    return true;
  }
  return false;
}


function open_mailbox($auth_user, $accountid)
{
  global $HTTP_SESSION_VARS;
  
  // select mailbox if there is only one
  if(number_of_accounts($auth_user)==1)
  {
    $accounts = get_account_list($auth_user); 
    $HTTP_SESSION_VARS['selected_account'] = $accounts[0]; 
    $accountid = $accounts[0];
  }

  // connect to the POP3 or IMAP server the user has selected
  $settings = get_account_settings($auth_user, $accountid);
  if(!sizeof($settings)) return 0;
  $mailbox = '{'.$settings[server];
  if($settings[type]=='POP3')
    $mailbox .= '/pop3';
  
  $mailbox .= ':'.$settings[port].'}INBOX';

  // suppress warning, remember to check return value  
@ $imap = imap_open($mailbox, $settings['remoteuser'], $settings['remotepassword']);

  return  $imap;
}


function get_list($imap)
{
  // get the list of messages in this mailbox
  $headers = imap_headers($imap);
  $messages = sizeof($headers);
  for($i = 0; $i<$messages; $i++)
  {
    echo $headers[$i];
  }
  imap_close($imap); 
}

function send_message($to, $cc, $subject, $message)
{
  //send one email via PHP
  global $HTTP_SESSION_VARS;
  
  if (!db_connect())
  { 
    return false;
  }
  $query = 'select address from users where username=\''.$HTTP_SESSION_VARS['auth_user']."'";
  
  $result = mysql_query($query);
  if (!$result)
  {
    return false;  
  }
  else if (mysql_num_rows($result)==0)
  {
    return false; 
  }
  else
  {
    $other = 'From: '.mysql_result($result, 0, 'address')."\r\nCc: $cc";
    if (mail($to, $subject, $message, $other))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}

function add_quoting($string, $pattern = '> ')
{
  // add a quoting pattern to mark text quoted in your reply
  return $pattern.str_replace("\n", "\n$pattern", $string);
}


