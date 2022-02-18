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

import tn.edu.esprit.model.Commande;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.interfaces.IcommandeService;

/**
 *
 * @author FadyBelY
 */
public class CommandeService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();


//CRUDS
   
    //AJOUT
    public void ajouterCommande(Commande c,int Id_utilisateur) {
        //request 
        String req="INSERT INTO `commande`(`Type_paiement`, `Date_commande`, `Prix_total`, `Adresse`, `Date_livraison`,`Id_utilisateur`) "
                + "VALUES (?,?,?,?,?,?)";
         System.out.println(req);  
        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,c.getType_paiement());
            pst.setString(2, c.getDate_commande());
            pst.setFloat(3,c.getPrix_total());
            pst.setString(4,c.getAdresse());
            pst.setString(5, c.getDate_livraison());
            pst.setInt(6,Id_utilisateur);
                                
            pst.executeUpdate();
            System.out.println("Commande ajouter avec Success");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //SUPPRIMER
    public void supprimerCommande(int Id_commande) {
    //request 
        String req="DELETE FROM `commande` WHERE Id_commande=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_commande);            
            pst.executeUpdate();
            
        
            System.out.println("Your command has been deleted");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        //Clear ALL
    public void supprimerTout(int Id_utilisateur) {
    //request 
        String req="DELETE FROM `commande` WHERE Id_utilisateur=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_utilisateur);            
            pst.executeUpdate();
            
        
            System.out.println("All commands has been deleted");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Affiche
        public List<Commande> afficherCommande(int Id_utilisateur) {
        //LIST
        List<Commande> commande = new ArrayList<>();
        //request 
        String req ="SELECT * FROM COMMANDE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                if(rs.getInt("Id_utilisateur") == Id_utilisateur){
                commande.add(new Commande(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5)));
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return commande;
    }
        
}
