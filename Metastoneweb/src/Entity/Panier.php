<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier", indexes={@ORM\Index(name="etranger_cammande_id", columns={"Id_commande"}), @ORM\Index(name="etranger_produit_id", columns={"Id_produit"})})
 * @ORM\Entity
 */
class Panier
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_panier", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idPanier;

    /**
     * @var int
     *
     * @ORM\Column(name="Nbr_produit", type="integer", nullable=false)
     */
    private $nbrProduit;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix_total", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixTotal;

    /**
     * @var \Merche
     *
     * @ORM\ManyToOne(targetEntity="Merche")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_produit", referencedColumnName="Id_produit")
     * })
     */
    private $idProduit;

    /**
     * @var \Commande
     *
     * @ORM\ManyToOne(targetEntity="Commande")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_commande", referencedColumnName="Id_commande")
     * })
     */
    private $idCommande;

    public function getIdPanier(): ?int
    {
        return $this->idPanier;
    }

    public function getNbrProduit(): ?int
    {
        return $this->nbrProduit;
    }

    public function setNbrProduit(int $nbrProduit): self
    {
        $this->nbrProduit = $nbrProduit;

        return $this;
    }

    public function getPrixTotal(): ?float
    {
        return $this->prixTotal;
    }

    public function setPrixTotal(float $prixTotal): self
    {
        $this->prixTotal = $prixTotal;

        return $this;
    }

    public function getIdProduit(): ?Merche
    {
        return $this->idProduit;
    }

    public function setIdProduit(?Merche $idProduit): self
    {
        $this->idProduit = $idProduit;

        return $this;
    }

    public function getIdCommande(): ?Commande
    {
        return $this->idCommande;
    }

    public function setIdCommande(?Commande $idCommande): self
    {
        $this->idCommande = $idCommande;

        return $this;
    }


}
