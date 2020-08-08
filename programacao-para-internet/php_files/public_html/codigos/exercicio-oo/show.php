<?php
   class Show {
    public $name;
    public $season;
    public $episode;

        
    function __construct($name){
        $this->name =  (string)$name;
        $this->season = 1;
        $this->episode = 1;  
    }

}
?>

