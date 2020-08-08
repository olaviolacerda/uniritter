<?php
  $pictures = array('tire.jpg', 'oil.jpg', 'spark_plug.jpg',
                    'door.jpg', 'steering_wheel.jpg',
                    'thermostat.jpg', 'wiper_blade.jpg',
                    'gasket.jpg', 'brake_pad.jpg');
  
  srand ((float)microtime()*1000000);
  shuffle($pictures);
?>
<html>
<head>
  <title>Bob's Auto Parts</title>
</head>
<body>
  <center>
    <h1>Bob's Auto Parts</h1>
    <table width = 100%>
      <tr>
<?php
  for ( $i = 0; $i < 3; $i++ )
  {
    echo '<td align="center"><img src="';
    echo $pictures[$i];
    echo '"width="100" height="100"></td>';
  }
?>
      </tr>
    </table>
  </center>
</body>
</html>