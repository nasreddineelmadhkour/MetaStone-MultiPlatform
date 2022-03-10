/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Merche;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.interfaces.ImercheService;
import tn.edu.esprit.model.Commande;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.util.SendSimpleEmail;

/**
 *
 * @author FadyBelY
 */
public class MercheService {

    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

//CRUDS
    //AJOUT
    public void ajouterMerche(Merche m) throws SQLException {
        //request 
        String msg;
        String req = "INSERT INTO `merche`(`Nom_produit`, `Prix_produit`, `Description_produit`, `Type_produit`, `Taille_produit`,`Quantite_produit`) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, m.getNom_produit());
        pst.setInt(2, m.getPrix_produit());
        pst.setString(3, m.getDescription_produit());
        pst.setString(4, m.getType_produit());
        pst.setInt(5, m.getTaille_produit());
        pst.setInt(6, m.getQuantite_produit());
        // pst.setString(7, m.getImage_produit());

        pst.executeUpdate();
        System.out.println("Merche added succesfully");
        //envoie de l'email pour chaque utilisateur abonné
        msg = "********** Metastone *********\n"
                + "Nouveau produit à " + m.getPrix_produit() + "\n"
                + "Nous vous présente notre derniere " + m.getType_produit() + " " + m.getNom_produit() + " .. "
                + m.getDescription_produit();

        req = "SELECT * FROM AbonnerMerche";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            new SendSimpleEmail(rs.getString(3), "Nouveau Produit", msg);
        }
    }

    //MODIFIER 
    public void modifierMerche(Merche m, int Id_produit) throws SQLException {

        //request 
        String req;
        if (m.getNom_produit() != "") {
            req = "UPDATE `merche` SET  `Nom_produit`=? ,`Prix_produit`=?,`Description_produit`=?,`Type_produit`=?,`Taille_produit`=?,`Quantite_produit`=? WHERE Id_produit =?";

            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, m.getNom_produit());
            pst.setInt(2, m.getPrix_produit());
            pst.setString(3, m.getDescription_produit());
            pst.setString(4, m.getType_produit());
            pst.setInt(5, m.getTaille_produit());
            pst.setInt(6, m.getQuantite_produit());
            pst.setInt(7, Id_produit);
            pst.executeUpdate();
            System.out.println("Your merche has been updated");

        }

    }

    //SUPPRIMER
    public void SupprimerMerche(int Id_produit) {
        //request 
        String req = "DELETE FROM `merche` WHERE Id_produit=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, Id_produit);
            pst.executeUpdate();

            System.out.println("Merche Deleted succesfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Merche> afficherMerche() {

        //LIST
        List<Merche> merche = new ArrayList<>();
        //request 
        String req = "SELECT * FROM MERCHE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                merche.add(new Merche(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return merche;
    }

//LES METIERS
    // recherche:
    public List<Merche> afficherMercheParType(String Type_produit) {
        //LIST
        List<Merche> merche = new ArrayList<>();
        //request 
        String req = "SELECT * FROM MERCHE WHERE  Type_produit like '" + Type_produit + "'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                merche.add(new Merche(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (merche.size() < 1) {
            System.out.println("La liste est vide!");
        }
        return merche;
    }

    public List<Merche> afficherMercheParNom(String Nom_produit) {
        //LIST
        List<Merche> merche = new ArrayList<>();
        List<Merche> fin = new ArrayList<>();
        //request 
        String req = "SELECT * FROM MERCHE WHERE  Nom_produit like '%" + Nom_produit + "%'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                if (rs.getString(2) == Nom_produit) {
                    fin.add(new Merche(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                    return fin;
                }
                merche.add(new Merche(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (merche.size() < 1) {
            System.out.println("La liste est vide!");
        }
        return merche;
    }

    public List<Merche> afficherMercheParPrix(boolean croissante) {
        //LIST
        List<Merche> merche = new ArrayList<>();
        String cr = "ASC";
        //request 
        if (!croissante) {
            cr = "DESC";
        }
        String req = "SELECT * FROM MERCHE ORDER BY Prix_produit " + cr;
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                merche.add(new Merche(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (merche.size() < 1) {
            System.out.println("La liste est vide!");
        }
        return merche;
    }

    //acheter
    public void acheterMerche(int Id_produit, int ID_utilisateur, int Quantite_a_acheter) {
        if (Quantite_a_acheter > 0) {
            int mtc = 0;
            int prix = 0;
            int qte = 0;
            String userAdresse = "";
            String req1 = "SELECT * FROM `utilisateur` WHERE ID_utilisateur  like '" + ID_utilisateur + "'";

            String req2 = "SELECT * FROM MERCHE WHERE Id_produit like '" + Id_produit + "'";
            try {
                Statement st = cnx.createStatement();
                ResultSet m = st.executeQuery(req1);
                if (m.next()) {
                    mtc = m.getInt(12);
                    userAdresse = m.getString(7);
                }

                ResultSet p = st.executeQuery(req2);
                if (p.next()) {
                    prix = p.getInt(3) * Quantite_a_acheter;
                    qte = p.getInt(7);

                }
                System.out.println("MTC = " + mtc);
                System.out.println("PRIX = " + prix);
                if (qte >= Quantite_a_acheter) {
                    if (mtc >= prix) {
                        System.out.println("Produit Acheter!");
                        //set user MTC = MTC - prix
                        String req;
                        req = "UPDATE `utilisateur` SET  `MTC`=? WHERE ID_utilisateur =?";
                        PreparedStatement pstU = cnx.prepareStatement(req);
                        pstU.setInt(1, mtc - prix);
                        pstU.setInt(2, ID_utilisateur);
                        pstU.executeUpdate();
                        //set Prod qte = qte - 1

                        req = "UPDATE `merche` SET  `Quantite_produit`=? WHERE Id_produit =?";
                        PreparedStatement pstM = cnx.prepareStatement(req);
                        pstM.setInt(1, qte - 1);
                        pstM.setInt(2, Id_produit);
                        pstM.executeUpdate();
                        //if qte = 0 then delete from table merche
                        //3adi commande lel user el produit hetha
                        /*
                    String Type_paiement = "MTC"
                    Date_commande = currentDate
                    float Prix_total = (float) prix
                    String Adresse = user::adresse
                    String Date_livraison = currentDate + shipping Day ( [ 7..14] );
                    int Id_utilisateur = ID_utilisateur
                         */
                        CommandeService commande = new CommandeService();
                        Commande c = new Commande("MTC", "25/02/2022", prix, userAdresse, "04/03/2022", ID_utilisateur, Id_produit, qte);
                        commande.ajouterCommande(c, ID_utilisateur);
                    }
                } else {
                    System.out.println("Hors stock!");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Quantite invalide!");
        }

    }

    public void abonnementMerche(int ID_utilisateur) throws SQLException {
        String req = "SELECT * FROM UTILISATEUR WHERE ID_utilisateur like '" + ID_utilisateur + "'";
        Statement st = cnx.createStatement();
        ResultSet rsU = st.executeQuery(req);
        rsU.next();
        String userEmail = rsU.getString(5);

        req = "SELECT * FROM abonnermerche WHERE Id_utilisateur like '" + ID_utilisateur + "'";

        ResultSet rs = st.executeQuery(req);
        try {
            if (rs.next()) {
                System.out.println("Utilisateur deja abonné!");
            } else {
                req = "INSERT INTO `abonnermerche`(`Id_utilisateur`, `email`) VALUES (?,?)";

                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setInt(1, ID_utilisateur);
                pst.setString(2, userEmail);
                pst.executeUpdate();
                System.out.println("Abonné!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void desabonnementMerche(int ID_utilisateur) {
        //request 
        String req = "DELETE FROM `abonnermerche` WHERE ID_utilisateur=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, ID_utilisateur);
            pst.executeUpdate();

            System.out.println("Desabonné!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //TEST
    public boolean idProdExiste(int id_prod) {
        List<Merche> mercheList = new ArrayList<>();
        String req = "SELECT * FROM MERCHE WHERE  Type_produit like '" + id_prod + "'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                mercheList.add(new Merche(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (mercheList.size() > 1);
    }
}
