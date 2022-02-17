/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import tn.edu.esprit.interfaces.IcartesService;
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
        //Cartes c = new Cartes(1,"moez",1,10,"url",8,3,"legandaire ","Madara","shinobi power",1);
        //cs.ajouterCartes(c);
        
        // ************** Affichage Cartes **************
        //System.out.println("\n ********* Affichage Cartes ********** \n");
        //System.out.println(cs.afficherCartes());
        
       // *************** Supprimer Cartes *************
       //cs.supprimerCartes(37);
       
        //*********** Modifier Cartes ****************
       Cartes c2 = new Cartes(11,"demon",1,10,"url",8,3,"legandaire ","Mlewi","shinobi power",1);
       //c2.setNom("");
       cs.modifierCartes(46,c2);
       //System.out.println(cs.afficherCartes());
       
       
       // **************** Affichage Collection ***************
       //CollectionService ns= new CollectionService();
       //System.out.println("\n ********* Affichage Collection ********** \n");
       //System.out.println(ns.afficherCollection());
    }
    
}
