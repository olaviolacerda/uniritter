<?php
echo '<h1>HTTPS transfer with cURL</h1>';

$outputfile = '/tmp/writable/ssl-download.html';
$fp = fopen($outputfile, 'w+');

echo 'Initializing cURL session...<br />';
$ch = curl_init();

echo 'Setting cURL options...<br />';
curl_setopt ($ch, CURLOPT_URL, 'https://www.verisign.com/');
curl_setopt ($ch, CURLOPT_FILE, $fp);

echo 'Executing cURL session...<br />';
curl_exec ($ch);

echo 'Ending cURL session...<br />';
curl_close ($ch);

fclose($fp);

echo 'Here is the content of the file:<hr />';
readfile($outputfile);
?>