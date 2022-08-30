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
public class Evenement {
 private int id_Evenement,Duree;
    private String Date,Lieu,Sponsore;

    public Evenement( String Date, String Lieu, int Duree, String Sponsore) {
        this.Date = Date;
        this.Lieu = Lieu;
        this.Duree = Duree;
        this.Sponsore = Sponsore;
        
    }
    public Evenement(int id_Evenement, String Date, String Lieu,int Duree,String Sponsore ) {
        this.id_Evenement=id_Evenement;
        this.Date = Date;
        this.Lieu =Lieu;
        this.Duree = Duree;
        this.Sponsore = Sponsore;
    }
    
    
    public Evenement() 
    {
        
    }
public int getid_Evenement() {
        return id_Evenement;
    }

    public void setid_Evenement(int id_Evenement) {
        this.id_Evenement = id_Evenement;
    }

    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }
    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }
    public String getSponsore() {
        return Sponsore;
    }

    public void setSponsore(String Sponsore) {
        this.Sponsore = Sponsore;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_Evenement=" + id_Evenement + ", Duree=" + Duree + ", Date=" + Date + ", Lieu=" + Lieu + ", Sponsore=" + Sponsore + '}';
    }

    
   
    
    
}
