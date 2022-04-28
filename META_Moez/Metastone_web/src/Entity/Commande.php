<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande", indexes={@ORM\Index(name="etrprod", columns={"Id_produit"}), @ORM\Index(name="etranger_cammande_user", columns={"Id_utilisateur"})})
 * @ORM\Entity
 */
class Commande
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_commande", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCommande;

    /**
     * @var string
     *
     * @ORM\Column(name="Type_paiement", type="string", length=255, nullable=false)
     */
    private $typePaiement;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_commande", type="date", nullable=false)
     */
    private $dateCommande;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix_total", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse", type="string", length=255, nullable=false)
     */
    private $adresse;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_livraison", type="date", nullable=false)
     */
    private $dateLivraison;

    /**
     * @var int
     *
     * @ORM\Column(name="Quantite_acheter", type="integer", nullable=false)
     */
    private $quantiteAcheter;

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
     * @var \Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_utilisateur", referencedColumnName="ID_utilisateur")
     * })
     */
    private $idUtilisateur;

    public function getIdCommande(): ?int
    {
        return $this->idCommande;
    }

    public function getTypePaiement(): ?string
    {
        return $this->typePaiement;
    }

    public function setTypePaiement(string $typePaiement): self
    {
        $this->typePaiement = $typePaiement;

        return $this;
    }

    public function getDateCommande(): ?\DateTimeInterface
    {
        return $this->dateCommande;
    }

    public function setDateCommande(\DateTimeInterface $dateCommande): self
    {
        $this->dateCommande = $dateCommande;

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

    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    public function setAdresse(string $adresse): self
    {
        $this->adresse = $adresse;

        return $this;
    }

    public function getDateLivraison(): ?\DateTimeInterface
    {
        return $this->dateLivraison;
    }

    public function setDateLivraison(\DateTimeInterface $dateLivraison): self
    {
        $this->dateLivraison = $dateLivraison;

        return $this;
    }

    public function getQuantiteAcheter(): ?int
    {
        return $this->quantiteAcheter;
    }

    public function setQuantiteAcheter(int $quantiteAcheter): self
    {
        $this->quantiteAcheter = $quantiteAcheter;

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

    public function getIdUtilisateur(): ?Utilisateur
    {
        return $this->idUtilisateur;
    }

    public function setIdUtilisateur(?Utilisateur $idUtilisateur): self
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }


}
