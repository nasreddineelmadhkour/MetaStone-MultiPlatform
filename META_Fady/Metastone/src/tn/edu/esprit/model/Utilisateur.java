/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;

/**
 *
 * @author FadyBelY
 */
public class Utilisateur {
    private int ID_utilisateur;
    private String Nom;
    private String Prenom;
    private Date Date_naiss;
    private String email;
    private int Tel;
    private String Adresse;
    private String Nom_utilisateur;
    private String Mot_de_passe;
    private String Sexe;
    private String Photo_de_profil;
    private float MTC;
    private String Role;
    private String Rank;
    private int Id_consommateur;
    
    //CTOR
        //default
    public Utilisateur() {
    }
        //param
    public Utilisateur(int ID_utilisateur, String Nom, String Prenom, Date Date_naiss, String email, int Tel, String Adresse, String Nom_utilisateur, String Mot_de_passe, String Sexe, String Photo_de_profil, float MTC, String Role, String Rank, int Id_consommateur) {
        this.ID_utilisateur = ID_utilisateur;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Date_naiss = Date_naiss;
        this.email = email;
        this.Tel = Tel;
        this.Adresse = Adresse;
        this.Nom_utilisateur = Nom_utilisateur;
        this.Mot_de_passe = Mot_de_passe;
        this.Sexe = Sexe;
        this.Photo_de_profil = Photo_de_profil;
        this.MTC = MTC;
        this.Role = Role;
        this.Rank = Rank;
        this.Id_consommateur = Id_consommateur;
    }
    //param no id
    public Utilisateur(String Nom, String Prenom, Date Date_naiss, String email, int Tel, String Adresse, String Nom_utilisateur, String Mot_de_passe, String Sexe, String Photo_de_profil, float MTC, String Role, String Rank) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Date_naiss = Date_naiss;
        this.email = email;
        this.Tel = Tel;
        this.Adresse = Adresse;
        this.Nom_utilisateur = Nom_utilisateur;
        this.Mot_de_passe = Mot_de_passe;
        this.Sexe = Sexe;
        this.Photo_de_profil = Photo_de_profil;
        this.MTC = MTC;
        this.Role = Role;
        this.Rank = Rank;
    }
    
//

    public int getID_utilisateur() {
        return ID_utilisateur;
    }

    public void setID_utilisateur(int ID_utilisateur) {
        this.ID_utilisateur = ID_utilisateur;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Date getDate_naiss() {
        return Date_naiss;
    }

    public void setDate_naiss(Date Date_naiss) {
        this.Date_naiss = Date_naiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getNom_utilisateur() {
        return Nom_utilisateur;
    }

    public void setNom_utilisateur(String Nom_utilisateur) {
        this.Nom_utilisateur = Nom_utilisateur;
    }

    public String getMot_de_passe() {
        return Mot_de_passe;
    }

    public void setMot_de_passe(String Mot_de_passe) {
        this.Mot_de_passe = Mot_de_passe;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getPhoto_de_profil() {
        return Photo_de_profil;
    }

    public void setPhoto_de_profil(String Photo_de_profil) {
        this.Photo_de_profil = Photo_de_profil;
    }

    public float getMTC() {
        return MTC;
    }

    public void setMTC(float MTC) {
        this.MTC = MTC;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public int getId_consommateur() {
        return Id_consommateur;
    }

    public void setId_consommateur(int Id_consommateur) {
        this.Id_consommateur = Id_consommateur;
    }
    
    
}
