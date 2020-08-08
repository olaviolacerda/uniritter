<?php

include('include_fns.php');
session_start();

$conn = db_connect();
$story = $HTTP_POST_VARS['story'];
$keyword = $HTTP_POST_VARS['keyword'];
$weight = $HTTP_POST_VARS['weight'];

$sql = "insert into keywords (story, keyword, weight)
        values ($story, '$keyword', $weight)";

mysql_query($sql, $conn);

header("Location: keywords.php?story=$story");

?>
