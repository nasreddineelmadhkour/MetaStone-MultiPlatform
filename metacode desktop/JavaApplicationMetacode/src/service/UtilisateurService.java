/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IutilisateurService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
