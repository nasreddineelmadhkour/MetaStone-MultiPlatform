/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author proinfo.tn
 */
public class Tournoi {

     private int id_tournoi, Nbr_joueur;
     private String Date,Description,Createur,Recompence ;
   
       
//constructor
    public Tournoi( String Date, String Description, String Createur, int Nbr_joueur,  String Recompence) {
        this.Date = Date;
        this.Description = Description;
        this.Createur = Createur;
        this.Nbr_joueur = Nbr_joueur;
        this.Recompence = Recompence;
        
        
    }
    public Tournoi(int id_tournoi, String Date, String Description, String Createur,int Nbr_joueur, String Recompence) {
        this.id_tournoi = id_tournoi;
        this.Date = Date;
        this.Description = Description;
        this.Createur = Createur;
        this.Nbr_joueur = Nbr_joueur;
        this.Recompence = Recompence;
        
    }

    //..
    public Tournoi ()
    {
       Date="";
       Description="";
       Createur="";
       Nbr_joueur=0;
       Recompence="";
       
       
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCreateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNbr_joueur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRecompence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
