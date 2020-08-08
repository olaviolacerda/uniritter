<?php

$response = urlencode('This text is coming from PHP');

header('Content-Type: text/plain');
echo 'intext='.$response;

?>
