<?php
// This class holds data about a single amazon product
// scalar attributes are all stored in the array nodes
// attributes from the XML document that require special treatment have their own array

// if the data came via XML/HTTP, most of the data will be in $this->nodes
// if the data came via SOAP, _ALL_ of the data will be in $this->soap

// This class' main purpose is to provide a common interface to the data from
// these two sources so all the display code can be common
class Product
{
  var $nodes = array();
  var $authors = array();
  var $listIDs = array();
  var $browseNames = array();
  var $customerReviews = array();
  var $similarProducts = array();
  var $_currentReview = -1;
  var $_currentBrowseName = -1;
  var $soap; // array returned by SOAP calls
  
  
  // most methods in this class are similar
  // return the XML variable or the SOAP one
  // a single Product instance will only have one or the other
  function similarProductCount()
  {
    if($this->soap)
      return count($this->soap['SimilarProducts']);
    else
      return count($this->similarProducts);
  }
  
  function similarProduct($i)
  {
    if($this->soap)
      return $this->soap['SimilarProducts'][$i];
    else
      return $this->similarProducts[$i];
  }
  
  function customerReviewCount()
  {
    if($this->soap)
      return count($this->soap['Reviews']['CustomerReviews']);
    else
      return count($this->customerReviews);
  }
  
  function customerReviewRating($i)
  {
    if($this->soap)
      return $this->soap['Reviews']['CustomerReviews'][$i]['Rating'];
    else
      return $this->customerReviews[$i]['RATING'];
  }

  function customerReviewSummary($i)
  {
    if($this->soap)
        return $this->soap['Reviews']['CustomerReviews'][$i]['Summary'];
    else
      return $this->customerReviews[$i]['SUMMARY'];
  }

  function customerReviewComment($i)
  {
    if($this->soap)
      return $this->soap['Reviews']['CustomerReviews'][$i]['Comment'];
    else
      return $this->customerReviews[$i]['COMMENT'];
  }
  
  
  function valid()
  {
    if(isset($this->nodes['PRODUCTNAME'])&&isset($this->nodes['OURPRICE'])&&isset($this->nodes['ASIN']))
      return true;
    if(isset($this->soap['ProductName'])&&isset($this->soap['OurPrice'])&&isset($this->soap['Asin']))
      return true;
  
    return false;
  }
  
  function ASIN()
  {
    if($this->soap) // we need to be careful that leadign 0s are not lost
      return padASIN($this->soap['Asin']);
    else
      return padASIN($this->nodes['ASIN']);
  }
  
  function imageURLMedium()
  {
    if($this->soap)
        return $this->soap['ImageUrlMedium'];
    else
        return $this->nodes['IMAGEURLMEDIUM'];
  }
  
  function imageURLLarge()
  {
    if($this->soap)
      return $this->soap['ImageUrlLarge'];
    else
      return $this->nodes['IMAGEURLLARGE'];
  }
  
  function productName()
  {
    if($this->soap)
      return $this->soap['ProductName'];
    else
      return $this->nodes['PRODUCTNAME'];
  }
  
  function ourPrice()
  {
    if($this->soap)
      return str_replace('$', '', $this->soap['OurPrice']);
    else
      return str_replace('$', '', $this->nodes['OURPRICE']);
  }
    
  function listPrice()
  {
    if($this->soap)
      return str_replace('$', '', $this->soap['ListPrice']);
    else
      return str_replace('$', '', $this->nodes['LISTPRICE']);
  }
  
  
  function authors()
  {
    if(isset($this->authors))
      return $this->authors;
    else if(isset($this->soap['Authors']))
      return $this->soap['Authors'];
    else
      return false;
  }

  function releaseDate()
  {
    if(isset($this->nodes['RELEASEDATE']))
      return $this->nodes['RELEASEDATE'];
    else if(isset($this->soap['ReleaseDate']))
      return $this->soap['ReleaseDate'];
    else
      return false;
  }  

  function avgCustomerRating()
  {
    if(isset($this->nodes['AVGCUSTOMERRATING']))
      return $this->nodes['AVGCUSTOMERRATING'];
    else if(isset($this->soap['AvgCustomerRating']))
      return $this->soap['AvgCustomerRating'];
    else
      return false;
  }

  function manufacturer()
  {
    if(isset($this->nodes['MANUFACTURER']))
      return $this->nodes['MANUFACTURER'];
    else if(isset($this->soap['Manufacturer']))
      return $this->soap['Manufacturer'];
    else
      return false;
  }

  function salesRank()
  {
    if(isset($this->nodes['SALESRANK']))
      return $this->nodes['SALESRANK'];
    else if(isset($this->soap['SalesRank']))
      return $this->soap['SalesRank'];
    else
      return false;
  }

  function availability()
  {
    if(isset($this->nodes['AVAILABILITY']))
      return $this->nodes['AVAILABILITY'];
    else if(isset($this->soap['Availability']))
      return $this->soap['Availability'];
    else
      return false;
  }
  
  
}
?>

