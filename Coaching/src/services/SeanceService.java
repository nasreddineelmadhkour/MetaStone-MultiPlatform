/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Seance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author Aziz
 */
public class SeanceService {
    
    Connection connexion;
    Statement stm;

    public SeanceService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    //Create 
    public void ajouterSeance(Seance c) throws SQLException {
        String req = "INSERT INTO `seance` (`Id_séance`, `Id_coach`, `Date`, `Durée`, `Nbr_participants`, `URL`, `Prix`) VALUES ('"
                + c.getID_Seance() + "', '"
                + c.getID_coach()+ "', '"
                + c.getDate()+ "', '"
                + c.getDuree()+ "', '"
                + c.getNBR_Participant()+ "', '"
                + c.getURL()+ "', '"
                + c.getPrix()+ "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }
    
    //Read
    public ArrayList<Seance> getSeances() throws SQLException {
        ArrayList<Seance> seances = new ArrayList<>();
        String req = "select * from seance";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Seance s = new Seance(
                    rst.getInt("Id_séance"),
                    rst.getInt("ID_coach"),
                    rst.getDate("Date"),
                    rst.getTime("Durée"),
                    rst.getInt("Nbr_participants"),
                    rst.getString("URL"),
                    rst.getFloat("Prix")
            );
            seances.add(s);
        }
        return seances;
    }
    
    
    //Update
    public void modifierSeance(Seance c) throws SQLException{
        String req = "UPDATE `seance` SET "+
                "`Id_coach` = '"+c.getID_coach()+
                "', `Date` = '"+c.getDate()+
                "', `Durée` = '"+ c.getDuree()
                + "', `Nbr_participants` = '"+c.getNBR_Participant()+
                "', `URL` = '"+ c.getURL()+
                "', `Prix` = '"+c.getPrix()+
                "' WHERE `seance`.`Id_séance` = '"+c.getID_Seance()+"' ";
        stm=connexion.createStatement();
        stm.executeUpdate(req);
    }
    
    
    //Delete
    public void supprimerSeance(int id) throws SQLException{
        String req="delete from `seance` WHERE `Id_séance` = '"+id+"'";
        stm=connexion.createStatement();
        stm.executeUpdate(req);
        
    }
    
}