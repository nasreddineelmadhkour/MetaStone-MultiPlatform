/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.interfaces.ItournoiService;

import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author admin
 */
public class TournoiService implements ItournoiService {
    //var
    Connection cnx= MaConnexion.getInstance().getCnx();
    
    @Override
    public void ajoutertournoi(Tournoi t) {
        //request 
        String req="INSERT INTO `tournoi`(`Date`, `Description`, `Createur`, `Nbr_joueur`, `Recompence`) "
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setDate(1,t.getDate());
            pst.setString(2,t.getDescription());
            pst.setString(3,t.getCreateur());
            pst.setInt(4,t.getNbr_joueur());
            pst.setString(5,t.getRecompence());
            
                         
            pst.executeUpdate();
            System.out.println("Tournoi ajouté avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Tournoi> affichertournoi() {
        
        //LIST
        List<Tournoi> tournois = new ArrayList<>();
        //request 
        String req ="SELECT * FROM TOURNOI";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                tournois.add(new Tournoi(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return  tournois;
    }
    
    
    
    public List<Tournoi> affichertournoirecher(String rechercher) {
        
        //LIST
        List<Tournoi> tournois = new ArrayList<>();
        //request 
        String req ="SELECT * FROM TOURNOI where Date like '%"+rechercher+"%' or  Description like '%"+rechercher+"%'  or  Createur like '%"+rechercher+"%' or  Recompence like '%"+rechercher+"%' ORDER BY `tournoi`.`Nbr_joueur` ASC";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                tournois.add(new Tournoi(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
                
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return  tournois;
    }
    

    @Override
    public void supprimertournoi (int  id_tournoi) {
         //request 
        String req="DELETE FROM `tournoi` WHERE ID_TOURNOI=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,id_tournoi);            
            pst.executeUpdate();
            
        
            System.out.println("tournoi Supprimé avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifiertournoi (int id_tournoi,Tournoi t) {
            
        String req=null;
        req=" UPDATE `tournoi` SET `Date`='"+t.getDate()+"',`Description`='"+t.getDescription()+"',`Createur`='"+t.getCreateur()+"',`Nbr_joueur`="+t.getNbr_joueur()+",`Recompence`='"+t.getRecompence()+"' WHERE id_tournoi="+id_tournoi; 
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("tournoi est  modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
           
     
         
    }

    public void displayTray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayTray(TrayIconDemo td) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
         public class TrayIconDemo {

        /**
         *
         * @param args
         * @throws AWTException
         * @throws MalformedURLException
         */
        public  void main(String[] args) throws AWTException, MalformedURLException {
        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }
public void displayTray() throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Hello, World", "notification demo", MessageType.INFO);
    }
    }
    }


    
 
    
