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

import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author ASUS
 */
public class CommentaireService implements IcommentaireService {
    
    
    Connection cnx= MaConnexion.getInstance().getCnx();

    @Override
    public void ajouterCommentaire(Commentaire c) {
        String req;
        req = "INSERT INTO `commentaire` (`Commentaire`,`Id_utilisateur`,`Id_poste`)  VALUES (?,?,?)";

    

    
        try {
            PreparedStatement pst;
            pst = cnx.prepareStatement(req);
           
            pst.setString(1,c.getCommentaire());
            pst.setInt(2, c.getId_utilisateur());
            pst.setInt(3, c.getId_poste());

            pst.executeUpdate();
            
            System.out.println("Commentaire ajoutée");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    
    @Override
    public List<Commentaire> afficherCommentaire() {
        //LIST
        List<Commentaire> commentaires;
        commentaires = new ArrayList<>();
        //request 
        String req;
        req = "SELECT * FROM commentaire";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                commentaires.add(new Commentaire(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return commentaires; 
    }
    
    
     public List<Commentaire> afficherCommentaire1(int idpost) {
        //LIST
        List<Commentaire> commentaires;
        commentaires = new ArrayList<>();
        //request 
        String req;
        req = "SELECT * FROM commentaire WHERE Id_poste="+idpost;
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                commentaires.add(new Commentaire(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return commentaires; 
    }

    @Override
    public void supprimerCommentaire(int Id_cmnt) {
    //request 
        String req;
        req = "DELETE FROM commentaire WHERE Id_cmnt=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_cmnt);            
            pst.executeUpdate();
            
        
            System.out.println("commentaire supprimée");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }


    @Override
    public void modifierCommentaire(int Id_cmnt, Commentaire c) {
        
        //request 
        String req;
        
        req="UPDATE commentaire SET Commentaire=? WHERE Id_cmnt=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
           
            pst.setString(1,c.getCommentaire());
            pst.setInt(2, Id_cmnt);
            
            pst.executeUpdate();
            
            System.out.println("modification terminée");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
         
    }
    public int calculateups(int upvote) throws SQLException {
        int nbups = 0;
        Statement ste = cnx.createStatement();
       
        ResultSet rs = ste.executeQuery("select upvote FROM commentaire ;" );
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }

    public int calculatedowns(int downvote) throws SQLException {
             int nbups = 0;
        Statement ste = cnx.createStatement();
       
        ResultSet rs = ste.executeQuery("select downvote FROM commentaire ;");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }
    }
    



