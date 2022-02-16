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
import tn.edu.esprit.interfaces.IposteService;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author ASUS
 */
public class PosteService implements IposteService{
    
    
    Connection cnx= MaConnexion.getInstance().getCnx();
    
    /**
     *
     * @param p
     */
    @Override
    public void ajouterPoste(Poste p) {
        String req;
        req = "INSERT INTO Poste(Titre,Date_poste,Contenu,Categorie,Id_utilisateur) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst;
            pst = cnx.prepareStatement(req);
            pst.setString(1,p.getTitre());
            pst.setString(2,p.getDate_poste());
            pst.setString(3,p.getContenu());
            pst.setString(4,p.getCategorie());
            pst.setInt(5,p.getId_utilisateur());
                   
            pst.executeUpdate();
            System.out.println("Poste ajoutée");
            
        } catch (SQLException ex) {
        }    }

    public List<Poste> afficherDemande() {
        //LIST
        List<Poste> postes;
        postes = new ArrayList<>();
        //request 
        String req;
        req = "SELECT * FROM poste";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                postes.add(new Poste(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return postes; 
    }

    /**
     *
     * @param Id_poste
     */
    @Override
    public void supprimerPoste(int Id_poste) {
    //request 
        String req="DELETE FROM poste WHERE Id_poste=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_poste);
            
            System.out.println("poste supprimée");
            
        } catch (SQLException ex) {
        }    }

    /**
     *
     * 
     * @param Id_poste
     * @param p
     */
    @Override
    public void modifierPoste(int Id_poste, Poste p) {
        
        //request 
        String req;
        
        req="UPDATE Commentaire SET Contenu=?,Categorie=? WHERE Id_poste=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,p.getId_poste());
            
            
            pst.executeUpdate();
            
            System.out.println("modification terminer avec Succes");
        } 
        catch (SQLException ex) 
        {
        }
         
         
    }

    

    
}

   



