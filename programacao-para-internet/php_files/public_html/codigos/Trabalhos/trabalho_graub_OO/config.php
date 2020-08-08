<?php

define('DB_NAME', 'trabalho_graub');
		define('DB_USER', 'root');
		define('DB_PASSWORD', '');
		define('DB_HOST', 'localhost');
		if ( !defined('ABSPATH') )
			define('ABSPATH', dirname(__FILE__) . '/');
		if ( !defined('BASEURL') )
	define('BASEURL', '/files/');
if ( !defined('DBAPI') )
	define('DBAPI', ABSPATH . 'banco/database.php');
