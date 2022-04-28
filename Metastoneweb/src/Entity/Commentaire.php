<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commentaire
 *
 * @ORM\Table(name="commentaire", indexes={@ORM\Index(name="etranger_poste_comnt", columns={"Id_poste"}), @ORM\Index(name="etranger_user_comnt", columns={"Id_utilisateur"})})
 * @ORM\Entity
 */
class Commentaire
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_cmnt", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCmnt;

    /**
     * @var string
     *
     * @ORM\Column(name="Commentaire", type="string", length=255, nullable=false)
     */
    private $commentaire;

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
     * @var \Poste
     *
     * @ORM\ManyToOne(targetEntity="Poste")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id_poste", referencedColumnName="Id_poste")
     * })
     */
    private $idPoste;

    public function getIdCmnt(): ?int
    {
        return $this->idCmnt;
    }

    public function getCommentaire(): ?string
    {
        return $this->commentaire;
    }

    public function setCommentaire(string $commentaire): self
    {
        $this->commentaire = $commentaire;

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

    public function getIdPoste(): ?Poste
    {
        return $this->idPoste;
    }

    public function setIdPoste(?Poste $idPoste): self
    {
        $this->idPoste = $idPoste;

        return $this;
    }


}
