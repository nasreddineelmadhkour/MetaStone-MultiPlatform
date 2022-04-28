<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur", uniqueConstraints={@ORM\UniqueConstraint(name="Nom_utilisateur", columns={"Nom_utilisateur"}), @ORM\UniqueConstraint(name="E_mail", columns={"email"})})
 * @ORM\Entity
 */
class Utilisateur
{
    /**
     * @var int
     *
     * @ORM\Column(name="ID_utilisateur", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idUtilisateur;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom", type="string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="age", type="string", length=22, nullable=false)
     */
    private $age;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     */
    private $email;

    /**
     * @var int
     *
     * @ORM\Column(name="Tel", type="integer", nullable=false)
     */
    private $tel;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse", type="string", length=40, nullable=false)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_utilisateur", type="string", length=20, nullable=false)
     */
    private $nomUtilisateur;

    /**
     * @var string
     *
     * @ORM\Column(name="Mot_de_passe", type="string", length=50, nullable=false)
     */
    private $motDePasse;

    /**
     * @var string
     *
     * @ORM\Column(name="Sexe", type="string", length=255, nullable=false)
     */
    private $sexe;

    /**
     * @var string
     *
     * @ORM\Column(name="Photo_de_profil", type="string", length=80, nullable=false)
     */
    private $photoDeProfil;

    /**
     * @var int
     *
     * @ORM\Column(name="MTC", type="integer", nullable=false)
     */
    private $mtc;

    /**
     * @var string
     *
     * @ORM\Column(name="Role", type="string", length=255, nullable=false)
     */
    private $role;

    /**
     * @var string
     *
     * @ORM\Column(name="Rank", type="string", length=255, nullable=false)
     */
    private $rank;

    /**
     * @var string
     *
     * @ORM\Column(name="Id_consommateur", type="string", length=255, nullable=false)
     */
    private $idConsommateur;

    /**
     * @var int|null
     *
     * @ORM\Column(name="code", type="integer", nullable=true)
     */
    private $code;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=255, nullable=false, options={"default"="activer"})
     */
    private $etat = 'activer';

    public function getIdUtilisateur(): ?int
    {
        return $this->idUtilisateur;
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

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getAge(): ?string
    {
        return $this->age;
    }

    public function setAge(string $age): self
    {
        $this->age = $age;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getTel(): ?int
    {
        return $this->tel;
    }

    public function setTel(int $tel): self
    {
        $this->tel = $tel;

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

    public function getNomUtilisateur(): ?string
    {
        return $this->nomUtilisateur;
    }

    public function setNomUtilisateur(string $nomUtilisateur): self
    {
        $this->nomUtilisateur = $nomUtilisateur;

        return $this;
    }

    public function getMotDePasse(): ?string
    {
        return $this->motDePasse;
    }

    public function setMotDePasse(string $motDePasse): self
    {
        $this->motDePasse = $motDePasse;

        return $this;
    }

    public function getSexe(): ?string
    {
        return $this->sexe;
    }

    public function setSexe(string $sexe): self
    {
        $this->sexe = $sexe;

        return $this;
    }

    public function getPhotoDeProfil(): ?string
    {
        return $this->photoDeProfil;
    }

    public function setPhotoDeProfil(string $photoDeProfil): self
    {
        $this->photoDeProfil = $photoDeProfil;

        return $this;
    }

    public function getMtc(): ?int
    {
        return $this->mtc;
    }

    public function setMtc(int $mtc): self
    {
        $this->mtc = $mtc;

        return $this;
    }

    public function getRole(): ?string
    {
        return $this->role;
    }

    public function setRole(string $role): self
    {
        $this->role = $role;

        return $this;
    }

    public function getRank(): ?string
    {
        return $this->rank;
    }

    public function setRank(string $rank): self
    {
        $this->rank = $rank;

        return $this;
    }

    public function getIdConsommateur(): ?string
    {
        return $this->idConsommateur;
    }

    public function setIdConsommateur(string $idConsommateur): self
    {
        $this->idConsommateur = $idConsommateur;

        return $this;
    }

    public function getCode(): ?int
    {
        return $this->code;
    }

    public function setCode(?int $code): self
    {
        $this->code = $code;

        return $this;
    }

    public function getEtat(): ?string
    {
        return $this->etat;
    }

    public function setEtat(string $etat): self
    {
        $this->etat = $etat;

        return $this;
    }


}
