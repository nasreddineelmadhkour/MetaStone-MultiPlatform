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
import java.util.stream.Collectors;
import tn.edu.esprit.interfaces.ItournoiService;
import tn.edu.esprit.model.lignetournoi;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.interfaces.IlignetournoiService;
import tn.edu.esprit.model.Evenement;

/**
 *
 * @author admin
 */
public class lignetournoiService implements IlignetournoiService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();
   

    @Override
    public List<lignetournoi> afficherlignetournoi() {
        
        //LIST
        List<lignetournoi> lignetournois = new ArrayList<>();
        //request 
        String req ="SELECT * FROM `lignetournoi` ";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                lignetournois.add(new lignetournoi (rs.getInt(2),rs.getInt(3),rs.getInt(4)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lignetournois;
    }

    @Override
    public void supprimerlignetournoi (int  id_lignetournoi) {
         //request 
        String req="DELETE FROM `lignetournoi` WHERE id_lignetournoi=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,id_lignetournoi);            
            pst.executeUpdate();
            
        
            System.out.println("tournoi Supprimé avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifierlignetournoi (int id_lignetournoi,lignetournoi t) {
        
         //request 
       /*  String req;
  
         req="UPDATE `tournoi` SET  `emplacemment`=? ,`id_tournoi`=?,`id_utilisateur`=? WHERE id_lignetournoi =?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
             pst.setInt(1,j.getEmplacement());
            pst.setInt(2,j.getId_tournoi());
            pst.setInt(3,j.getId_utilisateur());
            pst.executeUpdate();
            
            System.out.println("modification  de date terminée avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        */}

    @Override
    public void ajouterlignetournoi(lignetournoi j) {
 //request 
        String req="INSERT INTO `lignetournoi`(`emplacemment`, `id_tournoi`, `id_utilisateur`) "
                + "VALUES (?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,j.getEmplacement());
            pst.setInt(2,j.getId_tournoi());
            pst.setInt(3,j.getId_utilisateur());
            
                         
            pst.executeUpdate();
            System.out.println("joueur ajouté avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    
    }

         
         

    }


    
 
    
