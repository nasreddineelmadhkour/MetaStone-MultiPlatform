/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;

/**
 *
 * @author proinfo.tn
 */
public class Tournoi {

     private int id_tournoi, Nbr_joueur;
     private Date Date;
     private String Description;
     private String Createur;
     private String Recompence ;
   
       
//constructor
    public Tournoi( Date Date, String Description, String Createur, int Nbr_joueur,  String Recompence) {
        this.Date = Date;
        this.Description = Description;
        this.Createur = Createur;
        this.Nbr_joueur = Nbr_joueur;
        this.Recompence = Recompence;
        
        
    }
    public Tournoi(int id_tournoi, Date Date, String Description, String Createur,int Nbr_joueur, String Recompence) {
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
       
 
     
        
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public int getNbr_joueur() {
        return Nbr_joueur;
    }

    public void setNbr_joueur(int Nbr_joueur) {
        this.Nbr_joueur = Nbr_joueur;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCreateur() {
        return Createur;
    }

    public void setCreateur(String Createur) {
        this.Createur = Createur;
    }

    public String getRecompence() {
        return Recompence;
    }

    public void setRecompence(String Recompence) {
        this.Recompence = Recompence;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}
