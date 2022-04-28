<?php

namespace App\Controller;

use App\Entity\Tournoi;
use App\Form\TournoiType;
use App\Entity\RecompSearch;
use App\Form\RecompSearchType;
use App\Repository\TournoiRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/tournoi")
 */
class TournoiController extends AbstractController
{

    /**
     * @Route("/front", name="app_tournoi_indexfront", methods={"GET"})
     */
    public function home(TournoiRepository $tournoiRepository): Response
    
    {
        return $this->render('tournoi/indexfront.html.twig', [
            'tournois' => $tournoiRepository->findAll(),
        ]);
    }

    /**
     * @Route("/", name="app_tournoi_index")
     */
    public function index(TournoiRepository $tournoiRepository,Request $request): Response
    {   $priceSearch = new RecompSearch();
        $form = $this->createForm(RecompSearchType::class,$priceSearch);
        $form->handleRequest($request);
  
        $tournois= $this->getDoctrine()->getRepository(Tournoi::class)->findAll();
  
        if($form->isSubmitted() && $form->isValid()) {
          $minPrice = $priceSearch->getMinPrice(); 
          $maxPrice = $priceSearch->getMaxPrice();
            
          $tournois= $this->getDoctrine()->getRepository(Tournoi::class)->findByPriceRange($minPrice,$maxPrice);
      }
  
      return  $this->render('tournoi/index.html.twig',[ 'form' =>$form->createView(), 'tournois' => $tournois]);  
    
        
    }

    /**
     * @Route("/new", name="app_tournoi_new", methods={"GET", "POST"})
     */
    public function new(Request $request, TournoiRepository $tournoiRepository): Response
    {
        $tournoi = new Tournoi();
        $form = $this->createForm(TournoiType::class, $tournoi);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $tournoiRepository->add($tournoi);
            return $this->redirectToRoute('app_tournoi_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('tournoi/new.html.twig', [
            'tournoi' => $tournoi,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idTournoi}", name="app_tournoi_show", methods={"GET"})
     */
    public function show(Tournoi $tournoi): Response
    {
        return $this->render('tournoi/show.html.twig', [
            'tournoi' => $tournoi,
        ]);
    }

    /**
     * @Route("/{idTournoi}/edit", name="app_tournoi_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Tournoi $tournoi, TournoiRepository $tournoiRepository): Response
    {
        $form = $this->createForm(TournoiType::class, $tournoi);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $tournoiRepository->add($tournoi);
            return $this->redirectToRoute('app_tournoi_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('tournoi/edit.html.twig', [
            'tournoi' => $tournoi,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idTournoi}", name="app_tournoi_delete", methods={"POST"})
     */
    public function delete(Request $request, Tournoi $tournoi, TournoiRepository $tournoiRepository): Response
    {
        if ($this->isCsrfTokenValid('delete'.$tournoi->getIdTournoi(), $request->request->get('_token'))) {
            $tournoiRepository->remove($tournoi);
        }

        return $this->redirectToRoute('app_tournoi_index', [], Response::HTTP_SEE_OTHER);
    }
}
