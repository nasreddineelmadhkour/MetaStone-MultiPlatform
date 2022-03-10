/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//mailing

import java.util.Properties;

import javax.mail.Session;

//other
import tn.edu.esprit.model.Commande;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.interfaces.IcommandeService;
import tn.edu.esprit.util.SendSimpleEmail;

/**
 *
 * @author FadyBelY
 */
public class CommandeService {

    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

//CRUDS
    //AJOUT
    public void ajouterCommande(Commande c, int Id_utilisateur) {
        //request 
        String req1 = "INSERT INTO `commande`(`Type_paiement`, `Date_commande`, `Prix_total`, `Adresse`, `Date_livraison`,`Id_utilisateur`,`Id_produit`,`Quantite_acheter`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        String req = "SELECT * FROM UTILISATEUR WHERE ID_utilisateur like '" + Id_utilisateur + "'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rsP = st.executeQuery("SELECT * FROM MERCHE WHERE Id_produit like '"+c.getId_produit()+"'");
            rsP.next();
            //mailing
            String a = "";
            String sujet = "Commande effectué";
            String msg = "*********** METASTONE ***********"
                    + "Votre commande a été effectué avec success\n"
                    + "Vous avez commandé: "+rsP.getString(2)+"\n"
                    + "Methode de paiement: "+c.getType_paiement()+"\n"
                    + "Total Prix: "+c.getPrix_total()+"\n\n"
                    + "Si vous n'avez pas passer cette commande veuiller nous contactez\n";
            //cherche lemail
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                a = rs.getString(5);
                
                new SendSimpleEmail(a, sujet, msg);
                //ajout de la commande
                PreparedStatement pst = cnx.prepareStatement(req1);
                pst.setString(1, c.getType_paiement());
                pst.setString(2, c.getDate_commande());
                pst.setInt(3, c.getPrix_total());
                pst.setString(4, c.getAdresse());
                pst.setString(5, c.getDate_livraison());
                pst.setInt(6, Id_utilisateur);
                pst.setInt(7, c.getId_produit());
                pst.setInt(8,c.getQuantite_acheter());
                pst.executeUpdate();
                System.out.println("Commande ajouter avec Success");
            } else {
                System.out.println("ERREUR EMAIL!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //MODIFIER COMMANDE
    public void modifierCommande(Commande c, int Id_commande) {
        /*
        SELECT role FROM utilisateur WHERE Id_utilisateur = ...
         */
        //request 
        String req;
        req = "UPDATE `commande` SET  `Type_paiement`=? ,`Date_commande`=?,`Prix_total`=?,`Adresse`=?,`Date_livraison`=? WHERE Id_commande =?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getType_paiement());
            pst.setString(2, c.getDate_commande());
            pst.setInt(3, c.getPrix_total());
            pst.setString(4, c.getAdresse());
            pst.setString(5, c.getDate_livraison());
            pst.setInt(6, Id_commande);

            System.out.println("Command has been updated!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //SUPPRIMER
    public void supprimerCommande(int Id_commande,boolean all) {
        //request 
        String req;
        try {
            //REFUND MTC
            //get prix_total & userID
            req = "SELECT * FROM COMMANDE WHERE Id_commande like '" + Id_commande + "'";
            Statement st = cnx.createStatement();
            ResultSet rsC = st.executeQuery(req);
            if (rsC.next()) {
                int Id_produit = rsC.getInt(8);
                int prix = rsC.getInt(4);
                System.out.println("prix = " + prix);
                int userID = rsC.getInt(7);
                System.out.println("userID = " + userID);
                //get userMTC
                req = "SELECT * FROM utilisateur WHERE ID_utilisateur like '" + userID + "'";
                ResultSet rsU = st.executeQuery(req);
                rsU.next();
                int userMTC = rsU.getInt(12);
                String userEmail = rsU.getString(5);
                //get mercheQuantite
                req = "SELECT * FROM merche WHERE Id_produit like '" + Id_produit + "'";
                ResultSet rsGetM = st.executeQuery(req);
                rsGetM.next();
                int quantite = rsGetM.getInt(7);
                int newQuantite = rsGetM.getInt(8);
                //refunding MTCs
                req = "UPDATE `utilisateur` SET  `MTC`=? WHERE ID_utilisateur =?";
                PreparedStatement pstU = cnx.prepareStatement(req);
                pstU.setInt(1, userMTC + prix);
                pstU.setInt(2, userID);
                pstU.executeUpdate();
                //refund quantite
                req = "UPDATE `merche` SET  `Quantite_produit`=? WHERE Id_produit =?";
                PreparedStatement pstM = cnx.prepareStatement(req);
                pstM.setInt(1,quantite+newQuantite);
                pstM.setInt(2,Id_produit);
                pstM.executeUpdate();
                //ANNULATION DE LA COMMANDE
                req = "DELETE FROM `commande` WHERE Id_commande=?";
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setInt(1, Id_commande);
                pst.executeUpdate();
                System.out.println("Your command has been deleted");
                //mailing
                int prixTotal = userMTC + prix;
                String msg = "Votre commande a été annuler\n"
                        + "Vous avez rembourcer "+prixTotal;
                
                if(!all)
                {
                   new SendSimpleEmail(userEmail, "Votre commande a été annuler", msg);
                }
                
            } else {
                System.out.println("Cette commande n'existe pas");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Clear ALL

    public void supprimerTout(int Id_utilisateur) throws SQLException
    {
        String req = "SELECT * FROM COMMANDE WHERE ID_utilisateur like '"+Id_utilisateur+"'";
        int Id_commande;
        
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while(rs.next())
        {
            Id_commande = rs.getInt(1);
            supprimerCommande(Id_commande,true);
        }
        req = "SELECT * FROM utilisateur WHERE ID_utilisateur like '"+Id_utilisateur+"'";
        ResultSet rsMail = st.executeQuery(req);
        rsMail.next();
        String userEmail = rsMail.getString(5);
        String msg = "Toutes vos commandes ont été annulé!";
        
        new SendSimpleEmail(userEmail, "Annulation des commandes", msg);
        
    }
    /*
    
    public void supprimerTout(int Id_utilisateur) {
        //request 
        String req = "DELETE FROM `commande` WHERE Id_utilisateur=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, Id_utilisateur);
            pst.executeUpdate();

            System.out.println("All commands has been deleted");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
*/

    //Affiche
    public List<Commande> afficherCommande(int Id_utilisateur) {
        //LIST
        List<Commande> commande = new ArrayList<>();
        //request 
        String req = "SELECT * FROM COMMANDE where Id_utilisateur like '" + Id_utilisateur + "'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.println("rs 2: " + rs.getString(2) + "rs 3: " + rs.getString(3) + " rs 4: " + rs.getInt(4) + " rs 5: " + rs.getString(5) + " " + rs.getString(6));
                commande.add(new Commande(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;
    }

    public List<Commande> afficherToutLesCommande() {
        //LIST
        List<Commande> commande = new ArrayList<>();
        //request 
        String req = "SELECT * FROM COMMANDE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                commande.add(new Commande(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;
    }

}
