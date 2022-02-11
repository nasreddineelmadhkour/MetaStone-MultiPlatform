/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author admin
 */
public class MaConnexion {
    // BD Credentials
    final static String URL= "jdbc:mysql://127.0.0.1:3306/metacode";
    final static String USERNAME="root";
    final static String PWD="";
    //att
    private Connection cnx;
    
    //Singleton #1
    static MaConnexion instance=null;
    //constructor
    //Singleton #2

    private MaConnexion() {
       
        try {
            cnx= (Connection) DriverManager.getConnection(URL,USERNAME,PWD);
            System.out.println("Connexion etablie avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    //getters & setters

    public Connection getCnx() {
        return cnx;
    }
    
    //Singleton #3
    public static MaConnexion getInstance() {
        if(instance==null){
            instance=new MaConnexion();
        }
        return instance;
    }
    

    
}
