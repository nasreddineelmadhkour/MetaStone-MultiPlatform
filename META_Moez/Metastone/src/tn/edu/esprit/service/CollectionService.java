/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import tn.edu.esprit.interfaces.IcollectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Collection;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author Moez
 */
public class CollectionService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();

    public void ajouterCollection(Collection n) {
        //request 
        String req="INSERT INTO `collection`(`id_utilisateur`, `id_carte` ) "
                + "VALUES (?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);           
            pst.setInt(2,n.getID_UTILISATEUR());
            pst.setInt(1,n.getID_CARTE());
            pst.executeUpdate();
            System.out.println("Collection ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Collection> afficherCollection() {
        
        //LIST
        List<Collection> Collection = new ArrayList<>();
        //request 
        String req ="SELECT * FROM COLLECTION ";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                Collection.add(new Collection(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return Collection;
    }

    public void supprimerCollection(int ID_COLLECTION) {
         //request 
        String req="DELETE FROM `collection` WHERE ID_COLLECTION=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_COLLECTION);            
            pst.executeUpdate();
            
        
            System.out.println("collection Supprime avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    public void modifierCollection(int ID_UTILISATEUR,int ID_CARTE, Collection n) {
        
         //request 
       
         
        String req="UPDATE `collection` SET `Id_utilisateur`=1, `ID_CARTE`=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_UTILISATEUR);
            pst.setInt(2,ID_CARTE);
            pst.executeUpdate();
           
            System.out.println("modification de collection terminer avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
        
                  

    }

             
}
