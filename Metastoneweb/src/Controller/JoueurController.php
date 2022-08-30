<?php

namespace App\Controller;

use App\Entity\Joueur;
use App\Entity\Tournoi;
use App\Form\JoueurType;
use App\Repository\JoueurRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\PropertySearch;
use App\Form\PropertySearchType;

use App\Entity\CategorySearch;
use App\Form\CategorySearchType;


/**
 * @Route("/joueur")
 */
class JoueurController extends AbstractController
{
    /**
     * @Route("/", name="app_joueur_index")
     */
    public function index(JoueurRepository $joueurRepository,Request $request): Response
    {   
        $propertySearch = new PropertySearch();
        $categorySearch = new CategorySearch();
        $form = $this->createForm(PropertySearchType::class,$propertySearch);
        $forms = $this->createForm(CategorySearchType::class,$categorySearch);
        $form->handleRequest($request);
        $forms->handleRequest($request);
       
        $joueurs= $this->getDoctrine()->getRepository(Joueur::class)->findAll();
        
       if($form->isSubmitted() && $form->isValid()) {
    
        $nom = $propertySearch->getNom();   
        if ($nom!="") 
        {
          $joueurs= $this->getDoctrine()->getRepository(Joueur::class)->findBy(['emplacemment' => $nom] );
        }
        else   
          
          $joueurs= $this->getDoctrine()->getRepository(Joueur::class)->findAll();
       }

          //Recherche par tournoi
          if($forms->isSubmitted() && $forms->isValid()) {
            $category = $categorySearch->getCategory();
           
            if ($category!="") 
            {
              $joueurs= $this->getDoctrine()->getRepository(Joueur::class)->findBy(['idTournoi' => $category] );
            }
            else   
              $joueurs= $this->getDoctrine()->getRepository(Joueur::class)->findAll();
            }

       
        return  $this->render('Joueur/index.html.twig',[ 'form' =>$form->createView(),'forms' =>$forms->createView(), 'joueurs' => $joueurs]);  
       
    }

    /**
     * @Route("/new", name="app_joueur_new", methods={"GET", "POST"})
     */
    public function new(Request $request, JoueurRepository $joueurRepository): Response
    {
        $joueur = new Joueur();
        $form = $this->createForm(JoueurType::class, $joueur);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $joueurRepository->add($joueur);
            return $this->redirectToRoute('app_joueur_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('joueur/new.html.twig', [
            'joueur' => $joueur,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idJoueur}", name="app_joueur_show", methods={"GET"})
     */
    public function show(Joueur $joueur): Response
    {
        return $this->render('joueur/show.html.twig', [
            'joueur' => $joueur,
        ]);
    }

    /**
     * @Route("/{idJoueur}/edit", name="app_joueur_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Joueur $joueur, JoueurRepository $joueurRepository): Response
    {
        $form = $this->createForm(JoueurType::class, $joueur);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $joueurRepository->add($joueur);
            return $this->redirectToRoute('app_joueur_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('joueur/edit.html.twig', [
            'joueur' => $joueur,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idJoueur}", name="app_joueur_delete", methods={"POST"})
     */
    public function delete(Request $request, Joueur $joueur, JoueurRepository $joueurRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$joueur->getIdJoueur(), $request->request->get('_token'))) {
            $joueurRepository->remove($joueur);
        }

        return $this->redirectToRoute('app_joueur_index', [], Response::HTTP_SEE_OTHER);
    }
}
