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
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.edu.esprit.interfaces.IevenementService;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class EvenementService implements IevenementService{
    Connection cnx= MaConnexion.getInstance().getCnx();

    
    @Override
    public void ajouterEvenemenet(Evenement e)  {
//request 
        String req="INSERT INTO `EVENEMENT`(`Date`, `Lieu`, `Duree`, `Sponsore`) "
                + "VALUES (?,?,?,?)";

    try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,e.getDate1());
            pst.setString(2,e.getLieu());
            pst.setInt(3,e.getDuree());
            pst.setString(4,e.getSponsore());
            
                         
            pst.executeUpdate();
            System.out.println("Evenement ajouté2 avec Succes");
           
    }
    catch (SQLException ex) { 
        ex.printStackTrace();
    }
    }

   
    @Override
    public List<Evenement> afficherEvenement() {
        //LIST
        List<Evenement> evenement = new ArrayList<>();
        //request 
        String req ="SELECT * FROM EVENEMENT";
        
            //insert
            Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                evenement.add(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return evenement;
        }
    
           
    @Override
    public void supprimerEvenement(int id_evenement)  {
 String req="DELETE FROM `EVENEMENT` WHERE id_evenement=?";
 
            PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1,id_evenement);            
            pst.executeUpdate();
            
        
            System.out.println("evenement Supprimé avec Succes");
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
               
    }

    @Override
    public void modifierEvenement(int id_evenement, Evenement e)  {
String req;
         
         req="update `Evenement` SET  `Date`=? ,`Lieu`=?,`Duree`=?,`Sponsore`=? WHERE  id_evenement =?";

        
            PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1,e.getDate1());
            pst.setString(2,e.getLieu());  
            pst.setInt(3,e.getDuree());
            pst.setString(4,e.getSponsore());
            pst.setInt(5,id_evenement);
            pst.executeUpdate();
            
            System.out.println("modification  de Date1 est  terminée avec Succes");
        } catch (SQLException ex) {
            
        }
            
       
       
           
          }

    @Override
    public List<Evenement> findbyLieu(String lieu) {
        List<Evenement> evenements=afficherEvenement();
        List<Evenement> resultat=evenements.stream().filter(evenement->lieu.equals(evenement.getLieu())).collect(Collectors.toList());
        return resultat;   
    }

    @Override
    public List<Evenement> sortBySponsore() {
        List<Evenement> evenements = afficherEvenement();
        List<Evenement> resultat=evenements.stream().sorted( Comparator.comparing(Evenement::getSponsore)).collect(Collectors.toList());
        return resultat;   
    }

    public EvenementService() {
    }


}  