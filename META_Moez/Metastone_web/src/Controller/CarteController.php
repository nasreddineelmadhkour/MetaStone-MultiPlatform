<?php

namespace App\Controller;

use App\Entity\Carte;
use App\Form\CarteType;
use App\Repository\CarteRepository;
use Doctrine\ORM\EntityManagerInterface;
use Knp\Component\Pager\PaginatorInterface;
use MercurySeries\FlashyBundle\FlashyNotifier;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\File\Exception\FileException;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;

/**
 * @Route("/carte")
 */
class CarteController extends AbstractController
{

    /**
     * @Route("/back", name="app_carte_index", methods={"GET"})
     */
    public function index_back(EntityManagerInterface $entityManager): Response
    {
        $cartes = $entityManager
            ->getRepository(Carte::class)
            ->findAll();

        return $this->render('carte/index_back.html.twig', [
            'cartes' => $cartes,
        ]);
    }
    /**
     * @Route("/buyCard/{idCarte}", name="app_carte_buy", methods={"GET"})
     */
    public function buyCard(Carte $carte){
        $YOUR_DOMAIN = 'http://127.0.0.1:8000/carte';
        \Stripe\Stripe::setApiKey('sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl');

        $checkout_session = \Stripe\Checkout\Session::create([
            'payment_method_types' => ['card'],
            'line_items' => [[
                'price_data' => [
                    'currency' => 'eur',
                    'unit_amount' => $carte->getPrix()*100,
                    'product_data' => [
                        'name' => $carte->getNom(),
                    ],
                ],
                'quantity' => 1,
            ]],
            'mode' => 'payment',
            'success_url' => $this->generateUrl('success_url', [], UrlGeneratorInterface::ABSOLUTE_URL),
            'cancel_url' =>  $this->generateUrl('cancel_url', [], UrlGeneratorInterface::ABSOLUTE_URL)
        ]);
        return $this->redirect($checkout_session->url, 303);
    }
    /**
     * @Route("/success", name="success_url", methods={"GET"})
     */
    public function successUrl(): Response
    {
        return $this->render('stripe/success.html.twig');
    }
    /**
     * @Route("/cancel", name="cancel_url", methods={"GET"})
     */
    public function cancelUrl(): Response
    {
        return $this->render('stripe/cancel.html.twig');
    }
    /**
     * @Route("/front", name="app_carte_index_front", methods={"GET"})
     */
    public function index_front(EntityManagerInterface $entityManager): Response
    {
        $cartes = $entityManager
            ->getRepository(Carte::class)
            ->findAll();

        return $this->render('carte/index_front.html.twig', [
            'cartes' => $cartes,
        ]);
    }


    /**
     * @Route("/new", name="app_carte_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $carte = new Carte();
        $form = $this->createForm(CarteType::class, $carte);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $brochureFile */
            $brochureFile = $form->get('image')->getData();

            if ($brochureFile) {
                $originalFilename = pathinfo($brochureFile->getClientOriginalName(), PATHINFO_FILENAME);

                $safeFilename = transliterator_transliterate('Any-Latin; Latin-ASCII; [^A-Za-z0-9_] remove; Lower()', $originalFilename);
                $newFilename = $safeFilename.'-'.uniqid().'.'.$brochureFile->guessExtension();

                try {
                    $brochureFile->move(
                        $this->getParameter('brochures_directory'),
                        $newFilename
                    );
                } catch (FileException $e) {
                }
                $carte->setImage($newFilename);
            }

            $entityManager->persist($carte);
            $entityManager->flush();

            return $this->redirectToRoute('app_carte_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('carte/new_back.html.twig', [
            'carte' => $carte,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idCarte}/show", name="app_carte_show", methods={"GET"})
     */
    public function show_front(Carte $carte): Response
    {
        return $this->render('carte/show_card_front.html.twig', [
            'carte' => $carte,
        ]);
    }


    /**
     * @Route("/{idCarte}/edit", name="app_carte_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Carte $carte, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CarteType::class, $carte);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_carte_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('carte/edit.html.twig', [
            'carte' => $carte,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idCarte}/show_back", name="app_carte_show_back", methods={"GET"})
     */
    public function show_back(Carte $carte): Response
    {
        return $this->render('carte/show_card_back.html.twig', [
            'carte' => $carte,
        ]);
    }

    /**
     * @Route("/{idCarte}", name="app_carte_delete", methods={"POST","GET"})
     */
    public function delete(Request $request, Carte $carte, EntityManagerInterface $entityManager): Response
    {
        //if ($this->isCsrfTokenValid('delete'.$carte->getIdCarte(), $request->request->get('_token'))) {
            $entityManager->remove($carte);
            $entityManager->flush();
       // }

        return $this->redirectToRoute('app_carte_index', [], Response::HTTP_SEE_OTHER);
    }

    /**
     * @Route("/trade", name="app_trade", methods={"GET"})
     */
    public function index_trade(EntityManagerInterface $entityManager): Response
    {
        $cartes = $entityManager
            ->getRepository(Carte::class)
            ->findAll();

        return $this->render('carte/trade.html.twig', [
            'cartes' => $cartes,
        ]);
    }
    /**
     * @Route("/error404", name="app_erreur", methods={"GET"})
     */
    public function index_error404(EntityManagerInterface $entityManager): Response
    {
        $cartes = $entityManager
            ->getRepository(Carte::class)
            ->findAll();

        return $this->render('/error404.html.twig', [
            'cartes' => $cartes,
        ]);
    }





}
