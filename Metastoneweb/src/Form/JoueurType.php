<?php

namespace App\Form;

use App\Entity\Joueur;
use App\Entity\Tournoi;
use App\Entity\Utilisateur;


use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class JoueurType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('emplacemment')
            ->add('idUtilisateur',EntityType::class,['class'=>Utilisateur::class,'choice_label'=>'idUtilisateur'])
            ->add('idTournoi',EntityType::class,['class'=>Tournoi::class,'choice_label'=>'idTournoi']);
           
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Joueur::class,
        ]);
    }
}
