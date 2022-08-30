<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Carte
 *
 * @ORM\Table(name="carte")
 * @ORM\Entity

 *
 */
class Carte
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_carte", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCarte;

    /**
     * @var int
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Mana", type="integer", nullable=false)
     */
    private $mana;

    /**

     * @Assert\NotBlank(message="must not be blanck")
     * @Assert\Length(
     *      min = 1,
     *      max = 10,
     *      minMessage = "doit etre >=0 ",
     *      maxMessage = "doit etre <=10" )
     * @ORM\Column(name="Type", type="string", length=9, nullable=false)
     */
    private $type;

    /**
     * @var int
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Vie", type="integer", nullable=false)
     */
    private $vie;

    /**
     * @var int
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Prix", type="integer", nullable=false)
     */
    private $prix;

    /**
     * @var string
     * @ORM\Column(name="Image", type="string", length=255, nullable=true)
     */
    private $image;

    /**
     * @var int
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Attaque", type="integer", nullable=false)
     */
    private $attaque;

    /**
     * @var int
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Defence", type="integer", nullable=false)
     */
    private $defence;

    /**
     * @var string
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Rarete", type="string", length=20, nullable=false)
     */
    private $rarete;

    /**
     * @var string
     * @Assert\NotBlank(message="must not be blanck")

     * @ORM\Column(name="Nom", type="string", length=11, nullable=false)
     */
    private $nom;

    /**
     * @var string
     * @Assert\NotBlank(message="must not be blanck")
     * @ORM\Column(name="Description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var bool

     * @ORM\Column(name="Visibilite", type="boolean", nullable=false)
     */
    private $visibilite;

    public function getIdCarte(): ?int
    {
        return $this->idCarte;
    }

    public function getMana(): ?int
    {
        return $this->mana;
    }

    public function setMana(int $mana): self
    {
        $this->mana = $mana;

        return $this;
    }

    public function getType(): ?string
    {
        return $this->type;
    }

    public function setType(string $type): self
    {
        $this->type = $type;

        return $this;
    }

    public function getVie(): ?int
    {
        return $this->vie;
    }

    public function setVie(int $vie): self
    {
        $this->vie = $vie;

        return $this;
    }

    public function getPrix(): ?int
    {
        return $this->prix;
    }

    public function setPrix(int $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $image): self
    {
        $this->image = $image;

        return $this;
    }

    public function getAttaque(): ?int
    {
        return $this->attaque;
    }

    public function setAttaque(int $attaque): self
    {
        $this->attaque = $attaque;

        return $this;
    }

    public function getDefence(): ?int
    {
        return $this->defence;
    }

    public function setDefence(int $defence): self
    {
        $this->defence = $defence;

        return $this;
    }

    public function getRarete(): ?string
    {
        return $this->rarete;
    }

    public function setRarete(string $rarete): self
    {
        $this->rarete = $rarete;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

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

    public function getVisibilite(): ?bool
    {
        return $this->visibilite;
    }

    public function setVisibilite(bool $visibilite): self
    {
        $this->visibilite = $visibilite;

        return $this;
    }


}
