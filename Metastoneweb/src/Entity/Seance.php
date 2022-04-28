<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Seance
 *
 * @ORM\Table(name="seance", indexes={@ORM\Index(name="seance_id_coach", columns={"id_coach"})})
 * @ORM\Entity
 */
class Seance
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_seance", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSeance;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Duree", type="time", nullable=false)
     */
    private $duree;

    /**
     * @var int
     *
     * @ORM\Column(name="Nbr_participants", type="integer", nullable=false)
     */
    private $nbrParticipants;

    /**
     * @var string
     *
     * @ORM\Column(name="URL", type="string", length=255, nullable=false)
     */
    private $url;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix", type="float", precision=10, scale=0, nullable=false)
     */
    private $prix;

    /**
     * @var \Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_coach", referencedColumnName="ID_utilisateur")
     * })
     */
    private $idCoach;

    public function getIdSeance(): ?int
    {
        return $this->idSeance;
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

    public function getDuree(): ?\DateTimeInterface
    {
        return $this->duree;
    }

    public function setDuree(\DateTimeInterface $duree): self
    {
        $this->duree = $duree;

        return $this;
    }

    public function getNbrParticipants(): ?int
    {
        return $this->nbrParticipants;
    }

    public function setNbrParticipants(int $nbrParticipants): self
    {
        $this->nbrParticipants = $nbrParticipants;

        return $this;
    }

    public function getUrl(): ?string
    {
        return $this->url;
    }

    public function setUrl(string $url): self
    {
        $this->url = $url;

        return $this;
    }

    public function getPrix(): ?float
    {
        return $this->prix;
    }

    public function setPrix(float $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getIdCoach(): ?Utilisateur
    {
        return $this->idCoach;
    }

    public function setIdCoach(?Utilisateur $idCoach): self
    {
        $this->idCoach = $idCoach;

        return $this;
    }


}
