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

/**
 *
 * @author FadyBelY
 */
public class MercheService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();


//CRUDS
   
    //AJOUT
    public void ajouterMerche(Merche m) {
        //request 
        System.out.println("O");
        String req="INSERT INTO `merche`(`Nom_produit`, `Prix_produit`, `Description_produit`, `Type_produit`, `Taille_produit`) "
                + "VALUES (?,?,?,?,?)";
         System.out.println(req);  
         
        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,m.getNom_produit());
            pst.setFloat(2,m.getPrix_produit());
            pst.setString(3,m.getDescription_produit());
            pst.setString(4,m.getType_produit());
            pst.setInt(5,m.getTaille_produit());
                                
            pst.executeUpdate();
            System.out.println("Merche added succesfully");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //MODIFIER 
     public void modifierMerche(Merche m,int Id_produit) {
        
         //request 
         String req;
         if(m.getNom_produit()!="")
         {
         req="UPDATE `merche` SET  `Nom_produit`=? ,`Prix_produit`=?,`Description_produit`=?,`Type_produit`=?,`Taille_produit`=? WHERE Id_produit =?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,m.getNom_produit());
            pst.setFloat(2,m.getPrix_produit());
            pst.setString(3,m.getDescription_produit());
            pst.setString(4,m.getType_produit());
            pst.setInt(5,m.getTaille_produit());
            
            System.out.println("Your merche has been updated");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
         }
                  

    }

    //SUPPRIMER
    public void SupprimerMerche(int Id_produit) {
    //request 
        String req="DELETE FROM `merche` WHERE Id_produit=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_produit);            
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
        String req ="SELECT * FROM MERCHE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                merche.add(new Merche(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return merche;
    }
        
}