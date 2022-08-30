<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tournoi
 *
 * @ORM\Table(name="tournoi")
 * @ORM\Entity
 */
class Tournoi
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_tournoi", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTournoi;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="Description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="Createur", type="string", length=255, nullable=false)
     */
    private $createur;

    /**
     * @var int
     *
     * @ORM\Column(name="Nbr_joueur", type="integer", nullable=false)
     */
    private $nbrJoueur;

    /**
     * @var float
     *
     * @ORM\Column(name="Recompence", type="float", precision=10, scale=0, nullable=false)
     */
    private $recompence;

    public function getIdTournoi(): ?int
    {
        return $this->idTournoi;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getCreateur(): ?string
    {
        return $this->createur;
    }

    public function setCreateur(string $createur): self
    {
        $this->createur = $createur;

        return $this;
    }

    public function getNbrJoueur(): ?int
    {
        return $this->nbrJoueur;
    }

    public function setNbrJoueur(int $nbrJoueur): self
    {
        $this->nbrJoueur = $nbrJoueur;

        return $this;
    }

    public function getRecompence(): ?float
    {
        return $this->recompence;
    }

    public function setRecompence(float $recompence): self
    {
        $this->recompence = $recompence;

        return $this;
    }


}
