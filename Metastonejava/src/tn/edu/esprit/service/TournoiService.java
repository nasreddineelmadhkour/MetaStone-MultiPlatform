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
import tn.edu.esprit.interfaces.ItournoiService;

import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class TournoiService implements ItournoiService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();
    @Override
    public void ajoutertournoi(Tournoi t) {
        //request 
        String req="INSERT INTO `tournoi`(`Date`, `Description`, `Createur`, `Nbr_joueur`, `Recompence`) "
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,t.getDate());
            pst.setString(2,t.getDescription());
            pst.setString(3,t.getCreateur());
            pst.setString(4,t.getNbr_joueur());
            pst.setString(5,t.getRecompence());
            
                         
            pst.executeUpdate();
            System.out.println("Tournoi ajouté avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Tournoi> affichertournoi() {
        
        //LIST
        List<Tournoi> tournois = new ArrayList<>();
        //request 
        String req ="SELECT * FROM TOURNOI";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                tournois.add(new Tournoi(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return  tournois;
    }

    @Override
    public void supprimertournoi (int  id_tournoi) {
         //request 
        String req="DELETE FROM `int tournoi` WHERE ID_TOURNOI=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,id_tournoi);            
            pst.executeUpdate();
            
        
            System.out.println("tournoi Supprimé avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modifiertournoi (int id_tournoi,Tournoi t) {
        
         //request 
         String req;
         if(t.getDate()!="")
         {
         req="UPDATE `tournoi` SET  `Date`=? ,`Description`=?,`Createur`=?,`Nbr_joueur`=?,`Recompence`=? WHERE id_tournoi =?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,t.getDate());
            pst.setString(2,t.getDescription());  
            pst.setString(3,t.getCreateur());
            pst.setString(4,t.getNbr_joueur());
            pst.setString(5,t.getRecompence());
            pst.setInt(6,id_tournoi);
            pst.executeUpdate();
            
            System.out.println("modification  de date terminée avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
         }
         
         

    }


    
 
    
}