<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

class CategorySearch
{

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Category")
     */
    private $category;


    public function getCategory(): ?Tournoi
    {
        return $this->category;
    }

    public function setCategory(?Tournoi $category): self
    {
        $this->category = $category;

        return $this;
    }



}