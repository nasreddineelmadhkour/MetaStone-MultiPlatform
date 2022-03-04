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
import java.util.Random;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class ServiceUtilisateur implements Iservices<Utilisateur>{

    Connection cnx= MaConnexion.getInstance().getCnx();

    
    @Override
    public void ajouter(Utilisateur u) throws SQLException {
        //request 
        String req="INSERT INTO `utilisateur`(`Nom`, `Prenom`, `Date_naiss`, `email`, `Tel`, `Adresse`, `Nom_utilisateur`, `Mot_de_passe`, `Sexe`, `Photo_de_profil`, `MTC`, `Role`, `Rank`, `Id_consommateur`, `Code`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)";

        
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
            
        
        
    }

    @Override
    public void modifier(Utilisateur u, int ID_UTILISATEUR) throws SQLException {
            //request 
        String req="UPDATE `utilisateur` SET `Nom`=?, `Prenom`=? , `Date_naiss` = ?, "
                + "`email` =?, `Tel`=?, `Adresse`=?,`Mot_de_passe`=?, `Sexe`=?, "
                + "`Photo_de_profil`=? WHERE `ID_utilisateur`=?";

        
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
    }

    @Override
    public void supprimer(int ID_UTILISATEUR) throws SQLException {
        //request 
        String req="DELETE FROM `utilisateur` WHERE ID_UTILISATEUR=?";

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_UTILISATEUR);            
            pst.executeUpdate();
            
        
            System.out.println("Utilisateur Supprimer avec Succes");
        
    }

    @Override
    public List<Utilisateur> afficher() throws SQLException {
        //LIST
        List<Utilisateur> utilisateurs = new ArrayList<>();
        //request 
        String req ="SELECT * FROM UTILISATEUR";

            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString("Date_naiss"),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
                
            }
          
        return utilisateurs;

    }
    
    public int generer(int ID_UTILISATEUR) throws SQLException{
        Random rand = new Random();
        int code = rand.nextInt((9999 - 1000) + 1) + 1000;
        
        String req="UPDATE `utilisateur` SET `CODE`= ? WHERE ID_UTILISATEUR=?";
            
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,code);
            pst.setInt(2,ID_UTILISATEUR);            
            pst.executeUpdate();
           
        return code;
    }
    
    public String getEmailutilisateur(String username) throws SQLException{
    String email="";
    
    String req="SELECT email FROM `utilisateur` WHERE nom_utilisateur=? ";
           
            //insert
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,username);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                 email=rs.getString(1);
            }
    
    return email;
    }
    public boolean verifierLogin(String username,String password)throws SQLException{
    
    String req="SELECT * FROM `utilisateur` WHERE nom_utilisateur=? AND Mot_de_passe=? ;";
            int id=-1;
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,username);
            pst.setString(2,password);            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
                System.out.println(id);
            }
            if(id!=-1)
                return true;
            
            return false;
    }
    
    public Utilisateur getUtilisateur(int ID_UTILISATEUR) throws SQLException{
    Utilisateur u=new Utilisateur();
    
    String req="SELECT * FROM `utilisateur` WHERE ID_UTILISATEUR=? ;";
           
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_UTILISATEUR);

            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               u.setID_UTILISATEUR(rs.getInt(1));
               u.setNom(rs.getString(2));
               u.setPrenom(rs.getString(3));
               u.setDate_naiss(rs.getString(4));
               u.setEmail(rs.getString(5));
               u.setTel(rs.getString(6));
               u.setAdresse(rs.getString(7));
               u.setNom_utilisateur(rs.getString(8));
               u.setMot_de_passe(rs.getString(9));
               u.setSexe(rs.getString(10));
               u.setPhoto_de_profil(rs.getString(11));
               u.setMtc(rs.getString(12));
               u.setRole(rs.getString(13));
               u.setRank(rs.getString(14));
               u.setId_consommateur(rs.getString(15));
               u.setCode(rs.getInt(16));

            }
    return u;
    }
    
    public Utilisateur getUtilisateur(String username) throws SQLException{
    Utilisateur u=new Utilisateur();
    
    String req="SELECT * FROM `utilisateur` WHERE Nom_Utilisateur=? OR email=? ;";
           
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,username);
            pst.setString(2,username);

            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               u.setID_UTILISATEUR(rs.getInt(1));
               u.setNom(rs.getString(2));
               u.setPrenom(rs.getString(3));
               u.setDate_naiss(rs.getString(4));
               u.setEmail(rs.getString(5));
               u.setTel(rs.getString(6));
               u.setAdresse(rs.getString(7));
               u.setNom_utilisateur(rs.getString(8));
               u.setMot_de_passe(rs.getString(9));
               u.setSexe(rs.getString(10));
               u.setPhoto_de_profil(rs.getString(11));
               u.setMtc(rs.getString(12));
               u.setRole(rs.getString(13));
               u.setRank(rs.getString(14));
               u.setId_consommateur(rs.getString(15));
               u.setCode(rs.getInt(16));

            }
    return u;
    }
    
    
}
