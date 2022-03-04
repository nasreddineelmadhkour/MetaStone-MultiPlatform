/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import tn.edu.esprit.service.IcartesService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author Moez
 */
public class CartesService implements IcartesService{
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();

    public void ajouterCartes(Cartes c) {
        //request 
        String req="INSERT INTO `carte`(`Mana`, `Type`, `Vie`, `Prix`, `Image`, `Attaque`, `Defence`, `Rarete`, `Nom`, `Description`, `Visibilite`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,c.getmana());
            pst.setString(2,c.gettype());
            pst.setInt(3,c.getvie());
            pst.setInt(4,c.getprix());
            pst.setString(5,c.getimage());
            pst.setInt(6,c.getattaque());
            pst.setInt(7,c.getdefence());
            pst.setString(8,c.getrarete());
            pst.setString(9,c.getNom());
            pst.setString(10,c.getdescription());
            pst.setInt(11,c.getvisibilte());     
            pst.executeUpdate();
            System.out.println("Carte ajouter avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Cartes> afficherCartes() {
        
        //LIST
        List<Cartes> cartes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM CARTE ";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                cartes.add(new Cartes(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cartes;
    }
    

    @Override
    public void supprimerCartes(int ID_CARTE) {
         //request 
        String req="DELETE FROM `carte` WHERE ID_CARTE=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID_CARTE);            
            pst.executeUpdate();
            
        
            System.out.println("Cartes Supprime avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    @Override
    public void modifierCartes(int ID_CARTE,Cartes c) {
        
         //request 
       
         
        String req="UPDATE `carte` SET `Mana`=?, `Type`=? , `Vie` = ?, "
                + "`Prix` =?, `Image`=?, `Attaque`=?,`Defence`=?, `Rarete`=?, "
                + "`Nom`=?, `Description`=? , `Visibilite` = ? WHERE `Id_carte`=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,c.getmana());
            pst.setString(2,c.gettype());
            pst.setInt(3,c.getvie());
            pst.setInt(4,c.getprix());
            pst.setString(5,c.getimage());
            pst.setInt(6,c.getattaque());
            pst.setInt(7,c.getdefence());
            pst.setString(8,c.getrarete());
            pst.setString(9,c.getNom());
            pst.setString(10,c.getdescription());
            pst.setInt(11,c.getvisibilte());
            pst.setInt(12,ID_CARTE);
            pst.executeUpdate();
           
            System.out.println("modification de carte terminer avec Succes");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
         
        
                  

    }
    
    //afficher par id user
    @Override
    public List<Cartes> afficherCartesParId(int Id_carte)
    {
        //LIST
        List<Cartes> Cartes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM Carte WHERE Id_carte like '"+Id_carte+"'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                Cartes.add(new Cartes(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        if (Cartes.size() < 1) {
            System.out.println("La liste est vide!");
        }
        return Cartes;
    }
    
    
    
    @Override
   public List<Cartes> afficherCartesParType(String type)
    {
        //LIST
        List<Cartes> cartes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM CARTE WHERE Type like '"+type+"'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                cartes.add(new Cartes(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cartes;
    }
   
    @Override
   public List<Cartes> afficherCartesParNom(String Nom) {
        //LIST
        List<Cartes> cartes = new ArrayList<>();
        List<Cartes> aux = new ArrayList<>();
        //request 
        String req = "SELECT * FROM CARTE WHERE  Nom like '%" + Nom + "%'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                if (rs.getString(2) == Nom) {
                    cartes.add(new Cartes(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
                    return cartes;
                }
                cartes.add(new Cartes(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (cartes.size() < 1) {
            System.out.println("La liste est vide!");
        }
        return cartes;
    }
   
   /*
    public List<Cartes> findByRechercher(int Id_carte) throws SQLException {
        List<Cartes> arr = new ArrayList<>();
        String req = "select * from participation where idUser = ?";
        Cartes Cartes = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, user.getIdUser());
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int idComp = resultSet.getInt("idCompetition");
                ServiceCompetition ser2 = new ServiceCompetition();
                Competition comp = ser2.findById(idComp);
                arr.add(comp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }*/

    @Override
    public Cartes getCarte(int id_carte) {
        
        Cartes C=new Cartes();
        //LIST
        //request 
        String req ="SELECT * FROM CARTE where id_carte="+id_carte;
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                Cartes c=new Cartes(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
                
                C=c;
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return C;
    }
             
}
