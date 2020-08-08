<head>
<meta charset="UTF-8">
</head>

<?php

    class test1 {
        protected $members = array();
        public function __get($arg) {
            if (array_key_exists($arg, $this->members)) {
                return ($this->members[$arg]);
            } else { return ("No such luck!\n"); }
        }
        public function __set($key, $val) {
            $this->members[$key] = $val;
        }
        public function __isset($arg) {
            print "Chamei!";
            return (isset($this->members[$arg]));
        }
    }
    $x = new test1();
    echo "<br />";
    echo "após instanciar, tenta acessar speed_limit:";
    print $x->speed_limit;
    
    echo "<br />";
    echo "agora fazemos o set do speed_limit";
    $x->speed_limit = "65 MPH\n";

    echo "<br />";
    echo "verifica speed_limit com isset";

    if (isset($x->speed_limit)) {
        printf("Speed limit is set to %s\n", $x->speed_limit);
    }

    echo "<br />";
    echo "atribui speed_limit como NULL ";
    $x->speed_limit = NULL;    
    
    echo "<br />";
    echo "valida speed_limit com empty():";
    if (empty($x->speed_limit)) {
        print "The method __isset() was called.\n";
    } else {
        print "The __isset() method wasn't called.\n";
    }

?>