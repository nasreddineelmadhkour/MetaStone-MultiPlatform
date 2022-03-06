/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;


/**
 *
 * @author admin
 */
public class Utilisateur {
    private int ID_UTILISATEUR;
    private String date_naiss;
    private String mtc,nom,prenom,email,tel,adresse,nom_utilisateur,
            mot_de_passe,sexe,photo_de_profil,role,rank,id,id_consommateur;
    private int code;
   
       
//constructor
    public Utilisateur(String nom, String prenom, String date_naiss,String email,String tel,String adresse,String nom_utilisateur,String mot_de_passe,String sexe,String photo_de_profil,String mtc,String role, String rank,String id_consommateur) {
        this.mtc = mtc;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.sexe = sexe;
        this.photo_de_profil = photo_de_profil;
        this.role = role;
        this.rank = rank;
        this.id_consommateur=id_consommateur;
    }
    public Utilisateur(int ID_UTILISATEUR, String nom, String prenom, String date_naiss, String email, String tel, String adresse, String nom_utilisateur, String mot_de_passe, String sexe, String photo_de_profil,String mtc, String role, String rank, String id_consommateur) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.mtc = mtc;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.sexe = sexe;
        this.photo_de_profil = photo_de_profil;
        this.role = role;
        this.rank = rank;
        this.id_consommateur = id_consommateur;   
    }

    //..
    public Utilisateur ()
    {
       mtc="";
       nom="";
       prenom="";
       date_naiss="";
       email="";
       tel="";
       adresse="";
       nom_utilisateur="";
       mot_de_passe="";
       sexe="";
       photo_de_profil="";
       role="";
       rank="";
       id_consommateur="";
       
       
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    




    public String getId() {
        return id;
    }

    public String getMtc() {
        return mtc;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPhoto_de_profil() {
        return photo_de_profil;
    }

    public String getRole() {
        return role;
    }

    public String getRank() {
        return rank;
    }

    public String getId_consommateur() {
        return id_consommateur;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMtc(String mtc) {
        this.mtc = mtc;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPhoto_de_profil(String photo_de_profil) {
        this.photo_de_profil = photo_de_profil;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setId_consommateur(String id_consommateur) {
        this.id_consommateur = id_consommateur;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }
    
    
    //Affichage

    @Override
    public String toString() {
        return "Utilisateur{" + "ID_UTILISATEUR=" + ID_UTILISATEUR + ", date_naiss=" + date_naiss + ", mtc=" + mtc + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", adresse=" + adresse + ", nom_utilisateur=" + nom_utilisateur + ", mot_de_passe=" + mot_de_passe + ", sexe=" + sexe + ", photo_de_profil=" + photo_de_profil + ", role=" + role + ", rank=" + rank + ", id=" + id + ", id_consommateur=" + id_consommateur + ", code=" + code + '}';
    }

   
    
    
}
