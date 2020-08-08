<?php

// if we are using IIS, we need to set $PHP_AUTH_USER and $PHP_AUTH_PW
if (substr($SERVER_SOFTWARE, 0, 9) == 'Microsoft' &&
    !isset($PHP_AUTH_USER) &&
    !isset($PHP_AUTH_PW) &&
    substr($HTTP_AUTHORIZATION, 0, 6) == 'Basic '
   )
{
  list($PHP_AUTH_USER, $PHP_AUTH_PW) =
    explode(':', base64_decode(substr($HTTP_AUTHORIZATION, 6)));
}

// Replace this if statement with a database query or similar
if ($PHP_AUTH_USER != 'user' || $PHP_AUTH_PW != 'pass')
{
  // visitor has not yet given details, or their
  // name and password combination are not correct

  header('WWW-Authenticate: Basic realm="Realm-Name"');
  if (substr($SERVER_SOFTWARE, 0, 9) == 'Microsoft')
    header('Status: 401 Unauthorized');
  else
    header('HTTP/1.0 401 Unauthorized');

  echo '<h1>Go Away!</h1>';
  echo 'You are not authorized to view this resource.';
}
else
{
  // visitor has provided correct details
  echo '<h1>Here it is!</h1>';
  echo '<p>I bet you are glad you can see this secret page.</p>';
}
?>