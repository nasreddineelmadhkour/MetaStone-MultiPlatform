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
import tn.edu.esprit.interfaces.IdemandeService;
import tn.edu.esprit.model.Demande;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class DemandeService implements IdemandeService{
    Connection cnx= MaConnexion.getInstance().getCnx();

    @Override
    public void ajouterDemande(Demande d) {
//request 
        String req="INSERT INTO `DEMANDE`(`Type`, `Description`, `ID_UTILISATEUR`) "
                + "VALUES (?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,d.getType());
            pst.setString(2,d.getDescription());
            pst.setInt(3,d.getID_UTILISATEUR());
            
                         
            pst.executeUpdate();
            System.out.println("Demande ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public List<Demande> afficherDemande() {
        //LIST
        List<Demande> demandes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM DEMANDE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                demandes.add(new Demande(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return demandes;    }

    @Override
    public void supprimerUtilisateur(int ID_DEMANDE) {
    //request 
        String req="DELETE FROM `DEMANDE` WHERE ID_DEMANDE=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_DEMANDE);            
            pst.executeUpdate();
            
        
            System.out.println("Demande Supprimer avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void modifierUtilisateur(int ID_DEMANDE, Demande d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
