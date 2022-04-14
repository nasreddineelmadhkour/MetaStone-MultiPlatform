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
public class Evenement {
 private int id_evenement,Duree;
    private String Date1,Lieu,Sponsore;
   

    public Evenement( String Date1, String Lieu, int Duree, String Sponsore) {
        this.Date1 = Date1;
        this.Lieu = Lieu;
        this.Duree = Duree;
        this.Sponsore = Sponsore;
        
    }
    public Evenement(int id_evenement, String Date1, String Lieu,int Duree,String Sponsore ) {
        this.id_evenement=id_evenement;
        this.Date1 = Date1;
        this.Lieu =Lieu;
        this.Duree = Duree;
        this.Sponsore = Sponsore;
    }
    public Evenement(int id_evenement, String Date1, int Duree ) {
        this.id_evenement = id_evenement;
        this.Date1 = Date1;
        this.Duree = Duree ;
        
    }
    
    public Evenement(String Date1, int id_evenement, int Duree){
     this.id_evenement = id_evenement;
        this.Date1 = Date1;
        this.Duree = Duree ;
        
    
    }

    public Evenement() {
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String Date1) {
        this.Date1 = Date1;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public String getSponsore() {
        return Sponsore;
    }

    public void setSponsore(String Sponsore) {
        this.Sponsore = Sponsore;
    }

  

    
   
    
    
}
