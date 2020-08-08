<?php

include('include_fns.php');

unset($HTTP_SESSION_VARS['auth_user']);
session_destroy();

header('Location: '.$HTTP_SERVER_VARS['HTTP_REFERER']);

?>
