<?php

// publish_story.php -- action a release, go back to publish.php

include('include_fns.php');

$conn = db_connect();

$now = time();

$story = $HTTP_GET_VARS['story'];
$sql = "update stories set published = $now
        where id = $story";
$result = mysql_query($sql, $conn);

header('Location: '.$HTTP_SERVER_VARS['HTTP_REFERER']);
?>
