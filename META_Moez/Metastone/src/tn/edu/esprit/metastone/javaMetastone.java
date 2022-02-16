/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.service.CartesService;


/**
 *
 * @author admin
 */
public class javaMetastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        
        
        // ************ Ajouter Cartes ************* 
        CartesService cs= new CartesService();
        Cartes c = new Cartes(1,"terra",5,10,"url",8,3,"epic ","drg","dmg",1);
        cs.ajouterCartes(c);
        
        // ************** Affichage Cartes **************
        System.out.println("\n ********* Affichage Cartes ********** \n");
        System.out.println(cs.afficherCartes());
        
       // *************** Supprimer Cartes *************
       //cs.supprimerCartes(8);
       
        //*********** Modifier Cartes ****************
       Cartes c2 = new Cartes();
       c2.setNom("Moez");
       //c2.modifierUtilisateur(3,c2);
       
       
       // **************** Affichage Demande ***************
       //DemandeService ds= new DemandeService();
       //System.out.println("\n ********* Affichage Demande ********** \n");
       //System.out.println(ds.afficherDemande());
    }
    
}
