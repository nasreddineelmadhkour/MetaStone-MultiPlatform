<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Joueur
 *
 * @ORM\Table(name="joueur", indexes={@ORM\Index(name="etranger_ID_Tournoi", columns={"Id_tournoi"}), @ORM\Index(name="etranger_joueur_id_User", columns={"Id_utilisateur"})})
 * @ORM\Entity
 */
class Joueur
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_joueur", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idJoueur;

    /**
     * @var string
     *
     * @ORM\Column(name="Emplacemment", type="string", length=255, nullable=false)
     */
    private $emplacemment;

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
     * @var \Tournoi
     *
     * @ORM\ManyToOne(targetEntity="Tournoi")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_tournoi", referencedColumnName="Id_tournoi")
     * })
     */
    private $idTournoi;

    public function getIdJoueur(): ?int
    {
        return $this->idJoueur;
    }

    public function getEmplacemment(): ?string
    {
        return $this->emplacemment;
    }

    public function setEmplacemment(string $emplacemment): self
    {
        $this->emplacemment = $emplacemment;

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

    public function getIdTournoi(): ?Tournoi
    {
        return $this->idTournoi;
    }

    public function setIdTournoi(?Tournoi $idTournoi): self
    {
        $this->idTournoi = $idTournoi;

        return $this;
    }


}
