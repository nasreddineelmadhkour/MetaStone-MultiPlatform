/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmetacode;

import java.sql.Connection;
import model.Utilisateur;
import service.UtilisateurService;
import util.MaConnexion;

/**
 *
 * @author admin
 */
public class JavaApplicationMetacode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //service
        UtilisateurService us= new UtilisateurService();
        //utilisateur
       // Utilisateur u = new Utilisateur(1000,"El Madhkour","Nasreddine","1998/04/12","nasreddine@gmail.com","28000046","Sokra","nasr2022","123mdp","Homme","url","ADMIN","HERO");
        //insert 
       // us.ajouterUtilisateur(u);
       //System.out.println(us.afficherUtilisateur());
       //us.supprimerUtilisateur();
    }
    
}
