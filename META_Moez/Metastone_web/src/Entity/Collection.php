<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Collection
 *
 * @ORM\Table(name="collection", indexes={@ORM\Index(name="etranger_collection_carte", columns={"Id_carte"}), @ORM\Index(name="etranger_collection_user", columns={"Id_utilisateur"})})
 * @ORM\Entity
 */

class Collection
{


    /**
     * @var int
     *
     * @ORM\Column(name="Id_collection", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCollection;

    /**
     * @var \Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_utilisateur", referencedColumnName="ID_utilisateur")
     * })
     */
    private $idUtilisateur;



    /**
     * @var \Carte
     *
     * @ORM\ManyToOne(targetEntity="Carte")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_carte", referencedColumnName="Id_carte")
     * })
     */
    private $idCarte;

    public function getIdCollection(): ?int
    {
        return $this->idCollection;
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


    public function getIdCarte(): ?Carte
    {
        return $this->idCarte;
    }

    public function setIdCarte(?Carte $idCarte): self
    {
        $this->idCarte = $idCarte;

        return $this;
    }


}
