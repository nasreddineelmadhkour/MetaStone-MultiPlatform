/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;



import tn.edu.esprit.interfaces.IcommentaireService;
import tn.edu.esprit.interfaces.IposteService;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.service.CommentaireService;
import tn.edu.esprit.service.PosteService;


/**
 *
 * @author ASUS
 */
public class Metastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           // ********************CRUD poste *********************
        

    

        // ************ Ajouter Poste *************
        //IposteService p = new PosteService();
        //Poste p1 = new Poste("bug 404","28/10/1998","this our first comment ","categorie 1 ",3);
        //System.out.println("// ************ Ajouter Poste *************\n");
        //p.ajouterPoste(p1);
        
        
        // ************** Affichage post **************
        //System.out.println("\n ********* Affichage poste ********** \n");
        //System.out.println(p.afficherPoste());
        
        
// *******************************************************************************************************
        // *************** modifier poste *************
       //Poste p2 = new Poste("bug404","28/10/1998","this our second comment in your life","categorie-2",3);
       //p.modifierPoste(40, p2);
       //System.out.println(" *************** modifier poste *************\n");
       
       
//******************************************************************************************************
// ************** supprimer poste **************
       //System.out.println(" *************** supprimer poste *************\n");

               //p.supprimerPoste(10);

        
       
    

        
        

       
       
       //----------- CRUD COMMENTAIRE ----------------
       
      IcommentaireService d = new CommentaireService();
      Commentaire c1 = new Commentaire( "this is false comment",3, 36);
      
      //d.ajouterCommentaire(c1);
      Commentaire c2 = new Commentaire( "this our second comment ",3 ,37);
      //d.ajouterCommentaire(c2);

       
       
       // **************** Affichage Commentaire ***************

       System.out.println("\n ********* Affichage Commentaire ********** \n");
       System.out.println(d.afficherCommentaire());
       
       // *************** Supprimer Commentaire *************
       //d.supprimerCommentaire(38);
    
       // *********** Modifier Commentaire ****************
       d.modifierCommentaire(42,c2);
       //System.out.println(d.afficherDemande());
       
    }
}
