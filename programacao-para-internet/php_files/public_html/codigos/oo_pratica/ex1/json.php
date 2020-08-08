<?php 
//$dados = {'nome':'sjaviel', 'seriados': [{'titulo': 'Braking Bad','temporada':'1', 'episodio':'1'}]};
$dados_array = ["nome"=>"sjaviel", "seriados"=> 
     array(
        array( 'titulo'=> 'Braking Bad', 'temporada'=>'1',  'episodio'=>'1'),
        array( 'titulo'=> 'Suits', 'temporada'=>'3',  'episodio'=>'6'))];
  
echo json_encode($dados_array);

?>