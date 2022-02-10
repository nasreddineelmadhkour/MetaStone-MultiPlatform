/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IutilisateurService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;
import util.MaConnexion;

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
                + "VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getDate_naiss()+"','"+u.getEmail()+"',"+u.getTel()+",'"+u.getAdresse()+"','"+u.getNom_utilisateur()+"','"+u.getMot_de_passe()+"','"+u.getSexe()+"','"+u.getPhoto_de_profil()+"',"+u.getMtc()+",'"+u.getRole()+"','"+u.getRank()+"',"+u.getId_consommateur()+")";

        try {
            //insert
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
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
                utilisateurs.add(new Utilisateur(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)));
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return utilisateurs;
    }
    
}
