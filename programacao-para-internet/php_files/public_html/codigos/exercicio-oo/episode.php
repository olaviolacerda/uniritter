<?php
class Episode{
    private $title;
    private $id;
    private $season_id;
    private $number;
  
    function __construct($id, $season_id, $title, $number){
        $this->id = $id;
        $this->season_id = $season_id;
        $this->title = $title;
        $this->number = $number;
    }
    function getInfo(){
        return array($this->number, $this->title);
    }
}
?>