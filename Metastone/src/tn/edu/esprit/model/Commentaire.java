/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;


/**
 *
 * @author ASUS
 */

public class Commentaire {
    private int Id_cmnt;
    private String Commentaire;
    private int Id_utilisateur;
    private int Id_poste;	
    public Commentaire () 
    {
        Id_cmnt=0;
        Id_utilisateur=0;
        Commentaire="";
        Id_poste=0;
    }
     public Commentaire( String Commentaire,int Id_utilisateur, int Id_poste) {
        this.Commentaire = Commentaire;
        this.Id_utilisateur = Id_utilisateur;
        this.Id_poste = Id_poste;
    }
    public Commentaire(int Id_cmnt, String Commentaire, int Id_utilisateur, int Id_poste) {
        this.Id_cmnt = Id_cmnt;
        this.Commentaire = Commentaire;
        this.Id_utilisateur = Id_utilisateur;
        this.Id_poste = Id_poste;
        
    }

   
    
    public int getId_cmnt() {
        return Id_cmnt;
    }

    public void setId_cmnt(int Id_cmnt) {
        this.Id_cmnt = Id_cmnt;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }

    public void setId_utilisateur(int Id_utilisateur) {
        this.Id_utilisateur = Id_utilisateur;
    }

    public int getId_poste() {
        return Id_poste;
    }

    public void setId_poste(int Id_poste) {
        this.Id_poste = Id_poste;
    }
    @Override
   public String toString() {
        return "Commentaire{" + "Id_cmnt=" + Id_cmnt + ", Commentaire=" + Commentaire + ", Id_utilisateur=" + Id_utilisateur + ", Id_poste=" + Id_poste + '}';
    }
}
