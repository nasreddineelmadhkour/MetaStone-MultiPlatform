<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Abonnemerche
 *
 * @ORM\Table(name="abonnemerche")
 * @ORM\Entity
 */
class Abonnemerche
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_abo", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAbo;

    public function getIdAbo(): ?int
    {
        return $this->idAbo;
    }


}
