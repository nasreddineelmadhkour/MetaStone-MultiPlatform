/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import tn.edu.esprit.interfaces.IcartesService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author Moez
 */
public class CartesService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();

    public void ajouterCartes(Cartes c) {
        //request 
        String req="INSERT INTO `carte`(`Mana`, `Type`, `Vie`, `Prix`, `Image`, `Attaque`, `Defence`, `Rarete`, `Nom`, `Description`, `Visibilite`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,c.getmana());
            pst.setString(2,c.gettype());
            pst.setInt(3,c.getvie());
            pst.setInt(4,c.getprix());
            pst.setString(5,c.getimage());
            pst.setInt(6,c.getattaque());
            pst.setInt(7,c.getdefence());
            pst.setString(8,c.getrarete());
            pst.setString(9,c.getNom());
            pst.setString(10,c.getdescription());
            pst.setInt(11,c.getvisibilte());
                                
            pst.executeUpdate();
            System.out.println("Carte ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Cartes> afficherCartes() {
        
        //LIST
        List<Cartes> cartes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM CARTE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                cartes.add(new Cartes(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cartes;
    }

    public void supprimerCartes(int ID_CARTE) {
         //request 
        String req="DELETE FROM `carte` WHERE ID_CARTE=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_CARTE);            
            pst.executeUpdate();
            
        
            System.out.println("Cartes Supprime avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    public void modifierCartes(int ID_CARTE,Cartes c) {
        
         //request 
         String req;
         if(c.getNom()!="")
         {
         req="UPDATE `carte` SET  `Nom`=? ,`Mana`=?,`Type`=?,`Vie`=?,`Prix`=?,`Description`=?,`Attaque`=?,`Defence`=?,`Rarete`=? WHERE ID_CARTE =?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,c.getNom());
            pst.setInt(2,c.getmana());
            pst.setString(3,c.gettype());
            pst.setInt(4,c.getvie());
            pst.setInt(5,c.getprix());
            pst.setString(6,c.getdescription());
            pst.setInt(7,c.getattaque());
            pst.setInt(8,c.getdefence());
            pst.setString(9,c.getrarete());
            pst.setString(10,c.getimage());
            pst.setInt(11,c.getvisibilte());
            pst.setInt(12,ID_CARTE);
            System.out.println("modification de carte terminer avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
         }
                  

    }

             
}
