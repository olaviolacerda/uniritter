<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="index.css"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <?php
      error_reporting(0);
			ini_set(“display_errors”, 0 );
    
      $p = $_POST['peso'];
      $a = $_POST['altura'];
    
      if(isset($p, $a)){
        $imc = $p / (pow($a,2));
      }
    
      if($imc < 18){
        $s = "Peso abaixo do ideal";
      }
      if($imc >= 18 & $imc < 25 ){
        $s = "Peso normal";
      }
      if($imc > 25){
        $s = "Acima do peso";
      }
    ?>
  </head>
  <body>
    <div class="container" style="margin-top:10vh;">
      <div class="row">
      <div class="col-lg-1"></div>
      <div class="col-lg-10">
        <div class="panel panel-primary">
          <div class="panel-heading">SISTEMA DE CRIPTOGRAFIA EM RSA</div>
          <div class="panel-body">
             <form class="form-horizontal" action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
              <div class="form-group" style="margin-left:5vh;margin-right:5vh;;">
                <label for="altura">Altura</label>
                <input type="text" class="form-control" id="altura" placeholder="altura" name="altura">
              </div>
              <div class="form-group" style="margin-left:5vh;margin-right:5vh;">
                <label for="peso">Peso</label>
                <input type="text" class="form-control" id="peso" placeholder="Peso" name="peso">
              </div>
              <div class="form-group form-inline" style="margin-top:3%;;margin-right:5vh;margin-left:45.5%;">
                <input type="submit" class="form-control btn btn-warning" value="Calcular">
              </div>               
            </form>
            <br>
            <?php 
              if(isset($p, $a)){
                echo "
                  <div class='col-lg-1'></div>
                  <div class=' col-lg-10 alert alert-success' role='alert' style='text-align:center;'>".$s."</div>
                  <div class='col-lg-1'></div>
                ";
              }
            ?>
           </div>
         </div>
      </div>
      <div class="col-lg-1"></div>
    </div>
    </div>
  </body>
</html>