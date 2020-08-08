<html>
<body>
<h1>Send Me Private Mail</h1>

<?php
 // you might need to change this line, if you do not use 
 // the default ports, 80 for normal traffic and 443 for SSL
 if($HTTP_SERVER_VARS['SERVER_PORT']!=443)
   echo '<p><font color="red">
            WARNING: you have not connected to this page using SSL.  
            Your message could be read by others.</font></p>';
?>

<form method="post" action="send_private_mail.php"><br />
Your email address:<br />
<input type="text" name="from" size"="38"><br />
Subject:<br />
<input type="text" name="title" size="38"><br />
Your message:<br />
<textarea name="body" cols="30" rows="10">
</textarea><br />
<input type="submit" value="Send!">
</form>
</body>
</html>