/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.interfaces.ImercheService;
import tn.edu.esprit.model.Commande;
import tn.edu.esprit.service.MercheService;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.CommandeService;



/**
 *
 * @author FadyBelY
 */
public class Metastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnx= MaConnexion.getInstance().getCnx();
        
        // TODO code application logic here
        Merche m = new Merche(0,"Produit 0",5,"Testing","NULL",2);
        MercheService merche = new MercheService();
        //ajout
        //merche.ajouterMerche(m);
        //modifier
        m.setDescription_produit("UPDATE");
        //merche.modifierMerche(m, 4);
        //supprimer
        //merche.SupprimerMerche(4);
        
        // COMMANDE
        /*
      
        */
        CommandeService commande = new CommandeService();
        Commande c = new Commande("Type2","",10,"adresse","",9);
       
        
        //ajout
       // commande.ajouterCommande(c, 3);
        //c.setType_paiement("Type2");
        //commande.ajouterCommande(c,9);
        //AFFICHE
        
        List<Commande> afficheC = new ArrayList<>();
        afficheC = commande.afficherCommande(3);
        System.out.println(afficheC);
        

        //commande.supprimerTout(3);
        
        
    }
    
}
