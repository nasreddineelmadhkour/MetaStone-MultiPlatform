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
import tn.edu.esprit.interfaces.IcommentaireService;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author ASUS
 */
public class CommentaireService implements IcommentaireService{
    
    
    Connection cnx= MaConnexion.getInstance().getCnx();
    
    /**
     *
     * @param c
     */
    @Override
    public void ajouterCommentaire(Commentaire c) {
        String req;
        req = "INSERT INTO Commentaire(Id_cmnt,commentaire,Id_utilisateur) VALUES (?,?,?)";

    

    
        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,c.getId_cmnt());
            pst.setString(2,c.getCommentaire());
            pst.setInt(3,c.getId_utilisateur());
         

                         
            pst.executeUpdate();
            System.out.println("Commentaire ajoutée");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param Id_cmnt
     */
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

    /**
     *
     * @param Id_cmnt
     * @param c
     */
    @Override
    public void modifierCommentaire(int Id_cmnt, Commentaire c) {
        
        //request 
        String req;
        
        req="UPDATE Commentaire SET commentaire=? WHERE Id_cmnt=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
           
            pst.setString(2,c.getCommentaire());
            
            pst.executeUpdate();
            
            System.out.println("modification terminer avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
         
    }
    
}



