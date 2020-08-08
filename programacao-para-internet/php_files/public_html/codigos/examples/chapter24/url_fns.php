<?php
require_once('db_fns.php');

function get_user_urls($username)
{
  //extract from the database all the URLs this user has stored
  if (!($conn = db_connect()))
    return false;
  $result = mysql_query( "select bm_URL
                          from bookmark
                          where username = '$username'");
  if (!$result)
    return false; 

  //create an array of the URLs 
  $url_array = array();
  for ($count = 1; $row = mysql_fetch_row ($result); ++$count) 
  {
    $url_array[$count] = addslashes($row[0]);
  }  
  return $url_array;
}
  
function add_bm($new_url)
{
  // Add new bookmark to the database

  echo "Attempting to add ".htmlspecialchars($new_url).'<br />';
  global $HTTP_SESSION_VARS;
  $valid_user = $HTTP_SESSION_VARS['valid_user'];
  
  if (!($conn = db_connect()))
    return false;

  // check not a repeat bookmark
  $result = mysql_query("select * from bookmark
                         where username='$valid_user' 
                         and bm_URL='$new_url'");
  if ($result && (mysql_num_rows($result)>0))
    return false;

  // insert the new bookmark
  if (!mysql_query( "insert into bookmark values
                          ('$valid_user', '$new_url')"))
    return false; 

  return true;
} 

function delete_bm($user, $url)
{
  // delete one URL from the database
  if (!($conn = db_connect()))
    return false;

   // delete the bookmark
  if (!mysql_query( "delete from bookmark 
                       where username='$user' and bm_url='$url'"))
    return false;
  return true;  
}

function recommend_urls($valid_user, $popularity = 1)
{
  // We will provide semi intelligent recomendations to people
  // If they have an URL in common with other users, they may like
  // other URLs that these people like 
  if (!($conn = db_connect()))
    return false;

  // find other matching users
  // with an url the same as you
  
  if (!($result = mysql_query("
                    select distinct(b2.username) 
                    from bookmark b1, bookmark b2
                    where b1.username='$valid_user'
                    and b1.username != b2.username
                    and b1.bm_URL = b2.bm_URL
                   ")))
     return false;
  if (mysql_num_rows($result)==0)
    return false;

  // create set of users with urls in common
  // for use in IN clause
  $row = mysql_fetch_object($result);
  $sim_users = "('".($row->username)."'";
  while ($row = mysql_fetch_object($result))
  {
      $sim_users .= ", '".($row->username)."'";
  }
  $sim_users .= ')';

  // create list of user urls
  // to avoid replicating ones we already know about
  if (!($result = mysql_query("
                    select bm_URL 
                    from bookmark
                    where username='$valid_user'")))
    return false;

  // create set of user urls for use in IN clause
  $row = mysql_fetch_object($result);
  $user_urls = "('".($row->bm_URL)."'"; 
  while ($row = mysql_fetch_object($result))
  {
      $user_urls .= ", '".($row->bm_URL)."'";
  }
  $user_urls .= ')'; 

  // as a simple way of excluding people's private pages, and 
  // increasing the chance of recommending appealing URLs, we
  // specify a minimum popularity level
  // if $popularity = 1, then more than one person must have 
  // an URL before we will recomend it
 
  // find out max number of possible URLs
  if (!($result = mysql_query("
                    select bm_URL
                    from bookmark
                    where username in $sim_users
                    and bm_URL not in $user_urls
                    group by bm_URL 
                    having count(bm_URL)>$popularity
                  ")))
     return false;
                              
  if (!($num_urls=mysql_num_rows($result)))
    return false;

  $urls = array();
  // build an array of the relevant urls
  for ($count=0; $row = mysql_fetch_object($result); $count++)
  {
     $urls[$count] = $row->bm_URL; 
  }
                              
  return $urls; 
}
?>
