/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import tn.edu.esprit.interfaces.IdemandeService;
import tn.edu.esprit.interfaces.IutilisateurService;
import tn.edu.esprit.model.Demande;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.DemandeService;
import tn.edu.esprit.service.UtilisateurService;


/**
 *
 * @author admin
 */
public class Metastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        
        //-------- CRUD UTILISATEUR -------------
        
        // ************ Ajouter Utilisateur ************* 
        IutilisateurService us= new UtilisateurService();
        Utilisateur u = new Utilisateur("El daa","hahaha","1998-04-21","nasreazne@d.com","280006","ddzz","dazdax","aze","Homme","url","1000","ADMIN","HERO","0");
        //us.ajouterUtilisateur(u);
        
        // ************** Affichage Utilisateur **************
        //System.out.println("\n ********* Affichage Utilisateur ********** \n");
        //System.out.println(us.afficherUtilisateur());
        
       // *************** Supprimer Utilisateur *************
       //us.supprimerUtilisateur(10);
       //System.out.println(us.afficherUtilisateur());
       
       // *********** Modifier Utilisateur ****************
       Utilisateur u2 = new Utilisateur("elmadhkour","charf","1998-04-12","nasredddinemadhkour@g.com","28000045","sokra","nom_utilisateur","mdp1234562","Homme","url","mtc","role","rank","id_consommateur");
       //us.modifierUtilisateur(10, u2);
       //System.out.println(us.afficherUtilisateur());
       
       
       
       //----------- CRUD DEMANDE ----------------
       
       IdemandeService ds= new DemandeService();
       Demande d = new Demande(9,"Coaching","brabi hotni coach");
       //ds.ajouterDemande(d);

       
       
       // **************** Affichage Demande ***************

       System.out.println("\n ********* Affichage Demande ********** \n");
       System.out.println(ds.afficherDemande());
       
       // *************** Supprimer Demande *************
       //ds.supprimerDemande(3);
       //System.out.println(ds.afficherDemande());
    
       // *********** Modifier Utilisateur ****************
       Demande d2 = new Demande(0,"Type","Description");
       //ds.modifierDemande(4,d2);
       //System.out.println(ds.afficherDemande());
       
    }
    
}
