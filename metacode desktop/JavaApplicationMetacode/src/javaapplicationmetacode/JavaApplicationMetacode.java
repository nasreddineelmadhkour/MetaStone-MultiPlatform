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
        

            Connection cnx= MaConnexion.getInstance().getCnx();

        //service
        UtilisateurService us= new UtilisateurService();
        //utilisateur     public Utilisateur(String nom, String prenom, String date_naiss,   String email, String tel, String adresse, String nom_utilisateur, String mot_de_passe, String sexe, String photo_de_profil,String mtc, String role, String rank) {
        
        //Utilisateur u = new Utilisateur("El daa","daz","1998-04-28","nasreddidazne@gmail.com","28000046","dsa","daz15","123mdp","Homme","url","1000","ADMIN","HERO","0");
        //insert 
        //us.ajouterUtilisateur(u);
       //System.out.println(us.afficherUtilisateur());
       //us.supprimerUtilisateur();
       Utilisateur u2 = new Utilisateur();
       u2.setNom("El Madkhour");
       us.modifierUtilisateur(3,u2);
       
    }
    
}
