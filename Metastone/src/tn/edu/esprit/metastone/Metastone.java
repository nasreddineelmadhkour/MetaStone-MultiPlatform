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
        // TODO code application logic here

        
        IposteService p= new PosteService() ;
            
        Poste p1 = new Poste(1, 100, "meta","28/10/1998", "ceci le contenu de commentaire 1", "categorie_1");
        System.out.println(p1.afficherPoste());
    }
    
}
