<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Merche
 *
 * @ORM\Table(name="merche")
 * @ORM\Entity
 */
class Merche
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_produit", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_produit", type="string", length=255, nullable=false)
     */
    private $nomProduit;

    /**
     * @var int
     *
     * @ORM\Column(name="Prix_produit", type="integer", nullable=false)
     */
    private $prixProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Description_produit", type="string", length=255, nullable=false)
     */
    private $descriptionProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Type_produit", type="string", length=255, nullable=false)
     */
    private $typeProduit;

    /**
     * @var int
     *
     * @ORM\Column(name="Taille_produit", type="integer", nullable=false)
     */
    private $tailleProduit;

    /**
     * @var int
     *
     * @ORM\Column(name="Quantite_produit", type="integer", nullable=false)
     */
    private $quantiteProduit;

    public function getIdProduit(): ?int
    {
        return $this->idProduit;
    }

    public function getNomProduit(): ?string
    {
        return $this->nomProduit;
    }

    public function setNomProduit(string $nomProduit): self
    {
        $this->nomProduit = $nomProduit;

        return $this;
    }

    public function getPrixProduit(): ?int
    {
        return $this->prixProduit;
    }

    public function setPrixProduit(int $prixProduit): self
    {
        $this->prixProduit = $prixProduit;

        return $this;
    }

    public function getDescriptionProduit(): ?string
    {
        return $this->descriptionProduit;
    }

    public function setDescriptionProduit(string $descriptionProduit): self
    {
        $this->descriptionProduit = $descriptionProduit;

        return $this;
    }

    public function getTypeProduit(): ?string
    {
        return $this->typeProduit;
    }

    public function setTypeProduit(string $typeProduit): self
    {
        $this->typeProduit = $typeProduit;

        return $this;
    }

    public function getTailleProduit(): ?int
    {
        return $this->tailleProduit;
    }

    public function setTailleProduit(int $tailleProduit): self
    {
        $this->tailleProduit = $tailleProduit;

        return $this;
    }

    public function getQuantiteProduit(): ?int
    {
        return $this->quantiteProduit;
    }

    public function setQuantiteProduit(int $quantiteProduit): self
    {
        $this->quantiteProduit = $quantiteProduit;

        return $this;
    }


}
