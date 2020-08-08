<?php

include('include_fns.php');
session_start();

$conn = db_connect();
$story = $HTTP_GET_VARS['story'];
$keyword = $HTTP_GET_VARS['keyword'];
$sql = "delete from keywords where story = $story and keyword = '$keyword'";

mysql_query($sql, $conn);

header("Location: keywords.php?story=$story");

?>
