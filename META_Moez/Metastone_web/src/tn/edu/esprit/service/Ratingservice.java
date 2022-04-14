/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.rating;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author THEOLDISBACK
 */
public class Ratingservice {
    
     Connection cnx= MaConnexion.getInstance().getCnx();
    
     
     public void ajouterrating(rating r) {
      String req="INSERT INTO `rating`( `rate`, `id_post`) VALUES (?,?)";

        try {
             
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setDouble(1,r.getRate());
            pst.setInt(2,r.getId_poste());
            pst.executeUpdate();
            System.out.println("rate ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
              
            }
     
     
}
