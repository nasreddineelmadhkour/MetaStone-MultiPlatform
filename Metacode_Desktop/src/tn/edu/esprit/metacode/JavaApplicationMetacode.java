/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metacode;

import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.DemandeService;
import tn.edu.esprit.service.UtilisateurService;


/**
 *
 * @author admin
 */
public class JavaApplicationMetacode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        
        
        // ************ Ajouter Utilisateur ************* 
        UtilisateurService us= new UtilisateurService();
        Utilisateur u = new Utilisateur("El daa","hahaha","1998-04-28","nasreddidazne@d.com","28000046","dsa","dz","aze","Homme","url","1000","ADMIN","HERO","0");
        //us.ajouterUtilisateur(u);
        
        // ************** Affichage Utilisateur **************
        System.out.println("\n ********* Affichage Utilisateur ********** \n");
        System.out.println(us.afficherUtilisateur());
        
       // *************** Supprimer Utilisateur *************
       //us.supprimerUtilisateur(8);
       
       // *********** Modifier Utilisateur ****************
       //Utilisateur u2 = new Utilisateur();
       //u2.setNom("El Madkhour");
       //us.modifierUtilisateur(3,u2);
       
       
       // **************** Affichage Demande ***************
       DemandeService ds= new DemandeService();
       System.out.println("\n ********* Affichage Demande ********** \n");
       System.out.println(ds.afficherDemande());
    }
    
}
