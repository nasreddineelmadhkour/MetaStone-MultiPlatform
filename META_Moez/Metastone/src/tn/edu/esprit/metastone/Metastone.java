/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;



import java.sql.SQLException;
import tn.edu.esprit.service.CollectionService;


/**
 *
 * @author admin
 */
public class Metastone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {        
        
        
//        //-------- CRUD UTILISATEUR -------------
//        
//        // ************ Ajouter Utilisateur ************* 
//        Utilisateur u = new Utilisateur("El daa","hahaha","1998-04-21","nasreazne@d.com","280006","ddzz","dazdax","aze","Homme","url","1000","ADMIN","HERO","0");
//
//        Iservices iu=(Iservices) new ServiceUtilisateur();
//        //iu.ajouter(u);
//
//        // ************** Affichage Utilisateur **************
//        //System.out.println("\n ********* Affichage Utilisateur ********** \n");
//        System.out.println(iu.afficher());
//        
//       // *************** Supprimer Utilisateur *************
//       //iu.supprimer(10);
//       //System.out.println(iu.afficher());
//       
//       // *********** Modifier Utilisateur ****************
//       Utilisateur u2 = new Utilisateur("elmadhkour","charf","1998-04-12","nasredddinemadhkour@g.com","28000045","sokra","nom_utilisateur","mdp1234562","Homme","url","mtc","role","rank","id_consommateur");
//       //iu.modifier(10, u2);
//       //System.out.println(iu.afficher());
//       
//       
//       
//       //----------- CRUD DEMANDE ----------------
//       
//       Iservices id= new ServiceDemande();
//       //Demande d = new Demande(9,"Coaching","brabi hotni coach");
//       //id.ajouter(d);
//
//       
//       
//       // **************** Affichage Demande ***************
//
//       //System.out.println("\n ********* Affichage Demande ********** \n");
//       //System.out.println(id.afficher());
//       
//       // *************** Supprimer Demande *************
//       //id.supprimer(3);
//       //System.out.println(id.afficher());
//    
//       // *********** Modifier Utilisateur ****************
//       /*
//       Demande d2 = new Demande(0,"Type","Description");
//       //id.modifier(4,d2);
//       //System.out.println(id.afficher());
//       ServiceUtilisateur USER=new ServiceUtilisateur();
//       
//       
//       int code=0;
//       String email="";
//       email=USER.getEmailutilisateur("nasr2022");  //Login 
//        
//       if(email!="")
//       {
//           
//           System.out.println(code);
//           System.out.println(email);
//           code=USER.generer(3);
//           //Mail.sendMail(email, code);
//       }
//       else 
//       {
//           System.out.println("\n ----- Username n'existe pas ------\n");
//       }
//      */
//       
//       //ServiceUtilisateur Us=new ServiceUtilisateur();
//        //System.out.println(Us.verifierLogin("nasra","123"));
//        
////        Iservices USER=new ServiceUtilisateur();
////            Utilisateur U=new Utilisateur();
////            U.setMot_de_passe("123");
////            U.setEmail("oumaima@gmail.com");
////            U.setNom("nasri");
////            U.setPrenom("oumaima");
////            U.setSexe("Femme");
////            U.setNom_utilisateur("ouma123");
////            U.setDate_naiss("2000-12-06");
////            U.setAdresse("Sokra");
////            U.setTel("26554663");
////            U.setPhoto_de_profil("URL");
////            U.setRole("utilisateur");
////            U.setMtc("0");
////            U.setId_consommateur("0");
////            U.setRank("Bronze");
////            USER.ajouter(U);
        //CartesService cs=new CartesService();
        //System.out.println(cs.afficherCartesParId(1));
        
        CollectionService CS= new CollectionService();
        System.out.println(CS.afficherCollection(22));
    }
    
}
