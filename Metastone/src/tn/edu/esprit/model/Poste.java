/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class Poste {
    private int Id_poste;
    private int Id_utilisateur;
    private String Titre;
    private String Date_poste;
    private String Contenu ;
    private String Categorie;

    public Poste() {
    }

    /**
     *
     * @param Id_poste
     * @param Id_utilisateur
     * @param Titre
     * @param Date_poste
     * @param Contenu
     * @param Categorie
     */
    public Poste(int Id_poste, int Id_utilisateur, String Titre, String Date_poste, String Contenu, String Categorie) {
        this.Id_poste = Id_poste;
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
    }

    public Poste(String string, String string0, String string1, String string2, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

    public int getId_poste() {
        return Id_poste;
    }

    public void setId_poste(int Id_poste) {
        this.Id_poste = Id_poste;
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }

    public void setId_utilisateur(int Id_utilisateur) {
        this.Id_utilisateur = Id_utilisateur;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    
    public String getDate_poste() {
        return Date_poste;
    }

    public void setDate_poste(String Date_poste) {
        this.Date_poste = Date_poste;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    @Override
    public String toString() {
        return "Poste{" + "Id_poste=" + Id_poste + ", Id_utilisateur=" + Id_utilisateur + ", Titre=" + Titre + ", Date_poste=" + Date_poste + ", Contenu=" + Contenu + ", Categorie=" + Categorie + '}';
    }

    public boolean afficherPoste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
