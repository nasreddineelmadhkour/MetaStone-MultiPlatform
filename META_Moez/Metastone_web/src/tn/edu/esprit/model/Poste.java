/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;


/**
 *
 * @author ASUS
 */
public class Poste {
    private String Auteur;

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }
    private int Id_poste;
    private int Id_utilisateur;
    private String Titre;
    private Date Date_poste;
    private String Contenu ;
    private String Categorie;
    private int nbreVote;
    private int NbreCommentaire;
     private int nb_react;
    

    public Poste(String Titre,Date Date_poste,String Contenu,String Categorie,int Id_utilisateur,String Auteur,int NbreCommentaire,int nb_react,int nbreVote)
    {
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
        this.nbreVote = nbreVote;
        this.NbreCommentaire = NbreCommentaire;
        this.nb_react = nb_react;
        
    }
    public Poste(int Id_poste, int Id_utilisateur, String Titre, Date Date_poste, String Contenu, String Categorie, int nbreVote, int NbreCommentaire, int nb_react) {
        this.Id_poste = Id_poste;
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
        this.nbreVote = nbreVote;
        this.NbreCommentaire = NbreCommentaire;
        this.nb_react = nb_react;
        
    }
   

    

    public Poste() {
       
    }


    public Poste(int Id_poste, int Id_utilisateur, String Titre, Date Date_poste, String Contenu, String Categorie) {
        this.Id_poste = Id_poste;
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
    }
public Poste( String Titre,Date Date_poste, String Contenu,String Categorie, int Id_utilisateur) {
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
    }

    public Poste(String Titre, Date Date_poste, String Contenu, String Categorie) {
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
    }

    public Poste(int aInt, String string, Date date, String string0, String string1, int aInt0, int aInt1, int aInt2, String string2, int aInt3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Poste(String Auteur, int Id_poste, int Id_utilisateur, String Titre, Date Date_poste, String Contenu, String Categorie, int nbreVote, int NbreCommentaire, int nb_react) {
        this.Auteur = Auteur;
        this.Id_poste = Id_poste;
        this.Id_utilisateur = Id_utilisateur;
        this.Titre = Titre;
        this.Date_poste = Date_poste;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
        this.nbreVote = nbreVote;
        this.NbreCommentaire = NbreCommentaire;
        this.nb_react = nb_react;
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

    
    public Date getDate_poste() {
        return Date_poste;
    }

    public void setDate_poste(Date Date_poste) {
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

    public int getNbreVote() {
        return nbreVote;
    }

    public void setNbreVote(int nbreVote) {
        this.nbreVote = nbreVote;
    }

    public int getNbreCommentaire() {
        return NbreCommentaire;
    }

    public void setNbreCommentaire(int NbreCommentaire) {
        this.NbreCommentaire = NbreCommentaire;
    }

    public int getNb_react() {
        return nb_react;
    }

    public void setNb_react(int nb_react) {
        this.nb_react = nb_react;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    @Override
    public String toString() {
        return "Poste{" + "Id_poste=" + Id_poste + ", Id_utilisateur=" + Id_utilisateur + ", Titre=" + Titre + ", Date_poste=" + Date_poste + ", Contenu=" + Contenu + ", Categorie=" + Categorie + ", nbreVote=" + nbreVote + ", NbreCommentaire=" + NbreCommentaire + ", nb_react=" + nb_react + '}';
    }

    

    
}
