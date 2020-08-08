<?php
require_once('Product.php');

// you can switch between XML/HTTP and SOAP using this constant set in 
// constants.php
if(METHOD=='SOAP')
{
  include_once('nusoap/nusoap.php');
}

// This class stores the result of queries
// Usually this is 1 or 10 instances of the Product class
class AmazonResultSet
{
  var $_browseNode;
  var $_ASIN;
  var $_page;
  var $_mode;
  var $_url;
  var $_type;
  var $_totalResults;
  var $_currentProduct = null;
  var $_products = array(); // array of Product objects
  var $_names = array();    
// array of names of the XML nodes we have entered.
// treated as a stack.  Only used during parsing.
      
  function products()
  {
    return $this->_products;
  }

  function totalResults()
  {
    return $this->_totalResults;
  }

  function getProduct($i)
  {
    if(isset($this->_products[$i]))
      return $this->_products[$i] ;
    else
      return false;
  }

  // Perform a query to get a page full of products from a browse node
  // Switch between XML/HTTP and SOAP in constants.php
  // Returns an array of Products
  function browseNodeSearch($browseNode, $page, $mode)
  {
    if(METHOD=='SOAP')
    {
      // the NuSOAP class generates a lot of notices. Turn them off.
      error_reporting(error_reporting() & ~E_NOTICE);   
      $soapclient = new soapclient(
            'http://soap.amazon.com/schemas2/AmazonWebServices.wsdl',
            'wsdl');
      $soap_proxy = $soapclient->getProxy();
      $parameters['mode']=$mode;
      $parameters['page']=$page;      
      $parameters['type']='heavy';
      $parameters['tag']=$this->_assocID;
      $parameters['devtag']=$this->_devTag;
      $parameters['sort']='+salesrank';
      $parameters['browse_node'] = $browseNode;
      
      // perform actual soap query
      $result = $soap_proxy->BrowseNodeSearchRequest($parameters);
      if(isSOAPError($result))
        return false;
      $this->_totalResults = $result['TotalResults'];
      $counter = 0;
      foreach($result['Details'] as $product)
      {
        $this->_products[$counter] = new Product;
        $this->_products[$counter]->soap = $result['Details'][$counter];
        $counter++;
      }
      unset($soapclient);
      unset($soap_proxy);
    }    
    else
    {
            // form URL and call parseXML to download and parse it
      $this->_type = 'browse';
      $this->_browseNode = $browseNode;
      $this->_page = $page;
      $this->_mode = $mode;
      $this->_url = 'http://xml.amazon.com/onca/xml2?t='.ASSOCIATEID
                  .'&dev-t='.DEVTAG.'&BrowseNodeSearch='
                  .$this->_browseNode.'&mode='.$this->_mode
                  .'&type=heavy&page='.$this->_page.'&sort=+salesrank&f=xml';
      $this->parseXML();
    }
    
    return $this->_products;
  }
  
  // Given an ASIN, get the URL of the large image
  // Returns a string
  function getImageUrlLarge($ASIN, $mode)
  {
    if( $this->_products[0]->imageURLLarge())
      return  $this->_products[0]->imageURLLarge();
    $this->ASINSearch($ASIN, $mode);
      return $this->_products[0]->imageURLLarge();
  }
    
  // Perform a query to get a products with specified ASIN
  // Switch between XML/HTTP and SOAP in constants.php
  // Returns a Products object
  function ASINSearch($ASIN, $mode = 'books')
  {
    $this->_type = 'ASIN';
    $this->_ASIN=$ASIN;
    $this->_mode = $mode;
    $ASIN = padASIN($ASIN);

    if(METHOD=='SOAP')
    {
      error_reporting(E_ALL & ~E_NOTICE);
      $soapclient = new soapclient (
            'http://soap.amazon.com/schemas2/AmazonWebServices.wsdl',
            'wsdl') ;
      $soap_proxy = $soapclient->getProxy();
      $parameters['asin']=$ASIN;
      $parameters['mode']=$mode;
      $parameters['type']="heavy";
      $parameters['tag']=$this->_assocID;
      $parameters['devtag']=$this->_devTag;
      
      $result = $soap_proxy->AsinSearchRequest($parameters);
      if(isSOAPError($result))
      {
        print_r($result);
        return false;
      }
      $this->_products[0] = new Product;
      $this->_products[0]->soap = $result['Details'][0];
      $this->_totalResults=1;
      unset($soapclient);
      unset($soap_proxy);
    }
    else
    {
      // form URL and call parseXML to download and parse it
      $this->_url = 'http://xml.amazon.com/onca/xml2?t='.ASSOCIATEID
                    .'&dev-t='.DEVTAG.'&AsinSearch='
                    .$this->_ASIN
                    .'&type=heavy&f=xml';
      $this->parseXML();
    }
    return $this->_products[0];
   }
  
  // Perform a query to get a page full of products with a keyword search
  // Switch between XML/HTTP and SOAP in index.php
  // Returns an array of Products
  function keywordSearch($search, $page, $mode = 'books')
  {
     if(METHOD=='SOAP')
    {
      error_reporting(E_ALL & ~E_NOTICE);   
      $soapclient = new soapclient(
           'http://soap.amazon.com/schemas2/AmazonWebServices.wsdl','wsdl');
      $soap_proxy = $soapclient->getProxy();
      $parameters['mode']=$mode;
      $parameters['page']=$page;      
      $parameters['type']="heavy";
      $parameters['tag']=$this->_assocID;
      $parameters['devtag']=$this->_devTag;
      $parameters['sort']='+salesrank';
      $parameters['keyword'] = $search;
      // perform actual soap request
      $result = $soap_proxy->KeywordSearchRequest($parameters);
        
      if(isSOAPError($result) )
        return false;
      $counter = 0;
      foreach($result['Details'] as $product)
      {
        $this->_products[$counter] = new Product;
        $this->_products[$counter]->soap = $result['Details'][$counter];
        $counter++;
      }
      $this->_totalResults = $result['TotalResults'] ;
      unset($soapclient);
      unset($soap_proxy);
    }    
    else
    {
      $this->_type = 'search';
      $this->_search=$search;
      $this->_page = $page;    
      $search = urlencode($search);
      $this->_mode = $mode;
      $this->_url = 'http://xml.amazon.com/onca/xml2?t='.ASSOCIATEID
                    .'&dev-t='.DEVTAG.'&KeywordSearch='
                    .$search.'&mode='.$this->_mode
                    .'&type=heavy&page='
                    .$this->_page
                    .'&sort=+salesrank&f=xml';
      $this->parseXML();
    }
    return $this->_products;
  }
    
  // Parse the XML into Product object(s)
  function parseXML()
  {
    $xml_parser = xml_parser_create();
    xml_parser_set_option($xml_parser,XML_OPTION_SKIP_WHITE,1);
    xml_set_object($xml_parser, $this);
    xml_set_element_handler($xml_parser, 
                            "startElementHandler", 
                            "endElementHandler");
    xml_set_character_data_handler($xml_parser, 'cdataHandler');

    if (!($fp = fopen($this->_url, "r")))
    {
      die("could not open XML input");
    }
    while ($data = fread($fp, 4096))
    {
      if (!xml_parse($xml_parser, $data, feof($fp)))
      {
        die(sprintf("XML error: %s at line %d",
                    xml_error_string(xml_get_error_code($xml_parser)),
                    xml_get_current_line_number($xml_parser)));
      }
    }
    xml_parser_free($xml_parser) ;
  }

  // function to catch callbacks when the XML parser reaches the start 
  // of a new element
  function startElementHandler($parser, $name, $attributes)
  {
    array_push($this->_names, $name);
  
    if($name=='DETAILS')
    {
      $this->_currentProduct = new Product();
    }
    if($name == 'BROWSENODE')
    {
      $this->_currentProduct->_currentBrowseName++;
    }
    if($name == 'CUSTOMERREVIEW')
    {
      $this->_currentProduct->_currentReview++;
    }
  }
  
  // function to catch callbacks when the XML parser has data from 
  // an element
  function cdataHandler($parser, $cdata)
  {
    $this->_currentName = array_slice($this->_names, -1, 1);
    $this->_currentName = $this->_currentName[0] ;
    
    switch($this->_currentName)
    {
      case 'TOTALRESULTS' :
        $this->_totalResults = $cdata;
      break;
    
      case 'DETAILS' :
      break;
      
      case 'AUTHOR' :
        $this->_currentProduct->authors[] = $cdata;
      break;
    
      case 'RATING' :
      case 'SUMMARY' :
      case 'COMMENT' :
        @$this->_currentProduct->
           customerReviews[$this->_currentProduct->_currentReview]
           [$this->_currentName] .= $cdata;
        // fields that may contain returns and &s need to be concatenated 
        // concatenation will give a notice if they are enabled - 
        // hence the @
      break;
    
      case 'LISTID' :
        $this->_currentProduct->listIDs[] = $cdata;
      break;
    
      case 'BROWSENAME' :
        @$this->_currentProduct->browseNames[$this->_currentProduct->_
                 currentBrowseName] .= $cdata;
        // fields that may contain returns and &s need to be concatenated 
        // concatenation will give a notice if they are enabled - 
        // hence the @
      break;
  
      case 'PRODUCT' :
        $this->_currentProduct->similarProducts[] = $cdata;
      break;
  
      // there are certain keys we are dealing with the 
      // children of separately so can ignore
      case 'CUSTOMERREVIEW' :
      case 'AUTHORS' :
      case 'BROWSELIST' :
      case 'BROWSENODE' :
      case 'LISTS' :
      case 'REVIEWS' :
      case 'SIMILARPRODUCTS' :
        //do nothing
       break;
      
      default :
        @$this->_currentProduct->nodes[$this->_currentName] .= $cdata;
      break;
    }
  }

  // function to get callbacks when the XML parser reaches an end of element
  function endElementHandler($parser, $name) 
  {
    if($name=='DETAILS')
    {
      //these are no longer required
      unset($this->_currentProduct->_currentReview);
      unset($this->_currentProduct->_currentBrowseName);
      
      array_push($this->_products, $this->_currentProduct);
    }
    array_pop($this->_names);
  }
}
? >