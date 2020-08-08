<?php

// unpublish_story.php -- action a release, go back to release.php

include('include_fns.php');

$conn = db_connect();
$story = $HTTP_GET_VARS['story'];
$sql = "update stories set published = null
        where id = $story";
$result = mysql_query($sql, $conn);

header('Location: '.$HTTP_SERVER_VARS['HTTP_REFERER']);
?>
