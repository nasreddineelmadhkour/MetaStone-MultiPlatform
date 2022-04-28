<?php

namespace App\Entity;

class RecompSearch
{

   /**
    * @var int|null   
    */  
   private $minPrice;

   /**
    * @var int|null   
    */ 
   private $maxPrice;

   
   public function getMinPrice(): ?int
   {
       return $this->minPrice;
   }

   public function setMinPrice(int $minPrice): self
   {
       $this->minPrice = $minPrice;

       return $this;
   }

   public function getMaxPrice(): ?int
   {
       return $this->maxPrice;
   }

   public function setMaxPrice(int $maxPrice): self
   {
       $this->maxPrice = $maxPrice;

       return $this;
   }

}