/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metacode;

import tn.edu.esprit.model.Utilisateur;
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
        
        //service
        UtilisateurService us= new UtilisateurService();
        //utilisateur     public Utilisateur(String nom, String prenom, String date_naiss,   String email, String tel, String adresse, String nom_utilisateur, String mot_de_passe, String sexe, String photo_de_profil,String mtc, String role, String rank) {
        
        Utilisateur u = new Utilisateur("El daa","hahaha","1998-04-28","nasreddidazne@d.com","28000046","dsa","dz","aze","Homme","url","1000","ADMIN","HERO","0");
        //insert 
        //us.ajouterUtilisateur(u);
       //System.out.println(us.afficherUtilisateur());
       //us.supprimerUtilisateur(8);
       //Utilisateur u2 = new Utilisateur();
       //u2.setNom("El Madkhour");
       //us.modifierUtilisateur(3,u2);
       
    }
    
}
