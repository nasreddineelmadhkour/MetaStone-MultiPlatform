/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import java.sql.Connection;
import tn.edu.esprit.interfaces.IevenementService;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.service.EvenementService;
import tn.edu.esprit.service.TournoiService;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author proinfo.tn
 */
public class Metastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
  
// ************ Ajouter Evenement ************* 
       IevenementService es= new EvenementService();
        Evenement  e = new Evenement("2022/02/17","Ghazela",25,"Orange");
        //es.ajouterEvenemenet(e);
    
 // ************** Affichage Evenement**************
        System.out.println("\n ********* Affichage Evenement ********** \n");
        System.out.println(es.afficherEvenement());
        
       // *************** Supprimer Evenement *************
       es.supprimerEvenement(1);
       
       // *********** Modifier Evenement ****************
       //Evenement u2 = new Evenement();
       //u2.setNom("");
       //us.modifierevenement(3,u2);
       
       
       // **************** Affichage Tournoi ***************
       TournoiService ts= new TournoiService();
       System.out.println("\n ********* Affichage Tournoi ********** \n");
       System.out.println(ts.affichertournoi());
    }
  
}
