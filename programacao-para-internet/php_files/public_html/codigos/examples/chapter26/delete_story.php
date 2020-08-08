<?php

// delete_story.php 

include('include_fns.php');

$conn = db_connect();


$story = $HTTP_GET_VARS['story'];
$sql = "delete from stories where id = $story";
$result = mysql_query($sql, $conn);

header('Location: '.$HTTP_SERVER_VARS['HTTP_REFERER']);
?> 