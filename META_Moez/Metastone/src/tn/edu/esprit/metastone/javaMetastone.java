/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import tn.edu.esprit.interfaces.IcartesService;
import tn.edu.esprit.interfaces.IcollectionService;
import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.model.Collection;
import tn.edu.esprit.service.CartesService;
import tn.edu.esprit.service.CollectionService;



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
        //Cartes c = new Cartes(6,"fady",1,10,"url",8,3,"legandaire ","Madara","shinobi power",1);
        //cs.ajouterCartes(c);
        
            // ************** Affichage Cartes **************
        //System.out.println("\n ********* Affichage Cartes ********** \n");
        //System.out.println(cs.afficherCartes());
        
            // *************** Supprimer Cartes *************
        //cs.supprimerCartes(37);
       
            //*********** Modifier Cartes ****************
        //Cartes c2 = new Cartes(2,"moez",1,10,"url",8,3,"epic ","aif","shinobi power",1);
        //c2.setNom("");
        //cs.modifierCartes(3,c2);
        //System.out.println(cs.afficherCartes());
        //---------------------------------------------------------------------------------------------------------\\
            // ************ Ajouter Collection ************* 
        CollectionService ns= new CollectionService();
        //Collection n = new Collection(9,38);
        //ns.ajouterCollection(n);
        
            // **************** Affichage Collection ***************
        //System.out.println("\n ********* Affichage Collection ********** \n");
        //System.out.println(ns.afficherCollection());
        
        // **************** Fusionner Collection ***************
        ns.fusionnerCollection(7,8);

       
            // *************** Supprimer Collection *************
        //ns.supprimerCollection(14);
        //System.out.println("\n ********* Affichage Collection ********** \n");
        //System.out.println(ns.afficherCollection());
        
            //*********** Modifier Collection ****************
        //Collection n2 = new Collection(1,2,15);
        //n2.setID_COLLECTION();
        //ns.modifierCollection(1,2,15);
        //System.out.println(ns.afficherCollection());
        
    }
    
}
