/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import tn.edu.esprit.interfaces.IutilisateurService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class UtilisateurService implements IutilisateurService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();
    @Override
    public void ajouterUtilisateur(Utilisateur u) {
        //request 
        String req="INSERT INTO `utilisateur`(`Nom`, `Prenom`, `Date_naiss`, `email`, `Tel`, `Adresse`, `Nom_utilisateur`, `Mot_de_passe`, `Sexe`, `Photo_de_profil`, `MTC`, `Role`, `Rank`, `Id_consommateur`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,u.getNom());
            pst.setString(2,u.getPrenom());
            pst.setString(3,u.getDate_naiss());
            pst.setString(4,u.getEmail());
            pst.setString(5,u.getTel());
            pst.setString(6,u.getAdresse());
            pst.setString(7,u.getNom_utilisateur());
            pst.setString(8,u.getMot_de_passe());
            pst.setString(9,u.getSexe());
            pst.setString(10,u.getPhoto_de_profil());
            pst.setString(11,u.getMtc());
            pst.setString(12,u.getRole());
            pst.setString(13,u.getRank());
            pst.setString(14,u.getId_consommateur());
                         
            pst.executeUpdate();
            System.out.println("Utilisateur ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> afficherUtilisateur() {
        
        //LIST
        List<Utilisateur> utilisateurs = new ArrayList<>();
        //request 
        String req ="SELECT * FROM UTILISATEUR";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString("Date_naiss"),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return utilisateurs;
    }

    @Override
    public void supprimerUtilisateur(int ID_UTILISATEUR) {
         //request 
        String req="DELETE FROM `utilisateur` WHERE ID_UTILISATEUR=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_UTILISATEUR);            
            pst.executeUpdate();
            
        
            System.out.println("Utilisateur Supprimer avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifierUtilisateur(int ID_UTILISATEUR,Utilisateur u) {
        
        //request 
        String req="UPDATE `utilisateur` SET `Nom`=?, `Prenom`=? , `Date_naiss` = ?, "
                + "`email` =?, `Tel`=?, `Adresse`=?,`Mot_de_passe`=?, `Sexe`=?, "
                + "`Photo_de_profil`=? WHERE `ID_utilisateur`=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,u.getNom());
            pst.setString(2,u.getPrenom());
            pst.setString(3,u.getDate_naiss());
            pst.setString(4,u.getEmail());
            pst.setString(5,u.getTel());
            pst.setString(6,u.getAdresse());
            pst.setString(7,u.getMot_de_passe());
            pst.setString(8,u.getSexe());
            pst.setString(9,u.getPhoto_de_profil());
            pst.setInt(10,ID_UTILISATEUR);
            pst.executeUpdate();
            System.out.println("Modification terminer avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
         
         
         

    }


    
 
    
}
