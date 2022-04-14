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
public class lignetournoi {
 private int id_lignetournoi, id_tournoi, id_utilisateur;
    private int Emplacement;

   
    public lignetournoi(int  id_lignetournoi ,int id_tournoi,int id_utilisateur, int Emplacement ) {
        this.id_lignetournoi=id_lignetournoi;
        this.id_tournoi = id_tournoi;
        this. id_utilisateur = id_utilisateur;
        this.Emplacement = Emplacement;
        
        
    }
    
    public lignetournoi ( int Emplacement,  int id_tournoi,int id_utilisateur){
    
        this.id_tournoi = id_tournoi;
        this. id_utilisateur = id_utilisateur;
        this.Emplacement = Emplacement;
    
    }
    
    public lignetournoi() 
    {
        
    }


    public int getId_lignetournoi() {
        return id_lignetournoi;
    }

    public void setId_lignetournoi(int id_lignetournoi) {
        this.id_lignetournoi = id_lignetournoi;
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(int Emplacement) {
        this.Emplacement = Emplacement;
    }

    

    @Override
    public String toString() {
        return "Joueur{" + "id_lignetournoi=" + id_lignetournoi + ", id_tournoi=" + id_tournoi + ", id_utilisateur=" + id_utilisateur + ", Emplacement=" + Emplacement +  '}';
    }

   

    
   
    
    
}
