<?php

namespace App\Controller;

use App\Entity\Collection;
use App\Form\CollectionType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

use Symfony\Component\Routing\Annotation\Route;
/**
 * @Route("/collection")
 */
class CollectionController extends AbstractController
{
    /**
     * @Route("/back", name="app_collection_index_back", methods={"GET"})
     */
    public function index_back(EntityManagerInterface $entityManager): Response
    {
        $collections = $entityManager
            ->getRepository(Collection::class)
            ->findAll();

        return $this->render('collection/index_back.html.twig', [
            'collections' => $collections,
        ]);
    }
    /**
     * @Route("/front", name="app_collection_index_front", methods={"GET"})
     */
    public function index_front(EntityManagerInterface $entityManager): Response
    {
        $collections = $entityManager
            ->getRepository(Collection::class)
            ->findAll();

        return $this->render('collection/index_front.html.twig', [
            'collections' => $collections,
        ]);
    }

    /**
     * @Route("/new", name="app_collection_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $collection = new Collection();
        $form = $this->createForm(CollectionType::class, $collection);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($collection);
            $entityManager->flush();

            return $this->redirectToRoute('app_collection_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('collection/new.html.twig', [
            'collection' => $collection,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idCollection}", name="app_collection_show", methods={"GET"})
     */
    public function show(Collection $collection): Response
    {
        return $this->render('collection/show.html.twig', [
            'collection' => $collection,
        ]);
    }

    /**
     * @Route("/{idCollection}/edit", name="app_collection_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Collection $collection, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CollectionType::class, $collection);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_collection_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('collection/edit.html.twig', [
            'collection' => $collection,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idCollection}", name="app_collection_delete", methods={"POST"})
     */
    public function delete(Request $request, Collection $collection, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$collection->getIdCollection(), $request->request->get('_token'))) {
            $entityManager->remove($collection);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_collection_index', [], Response::HTTP_SEE_OTHER);
    }
}
