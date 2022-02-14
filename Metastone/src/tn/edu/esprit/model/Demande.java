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
public class Demande {
    private int ID_DEMANDE,ID_UTILISATEUR;
    private String type,description;

    public Demande(int ID_UTILISATEUR, String type, String description) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.type = type;
        this.description = description;
    }
    public Demande(int ID_DEMANDE, String type, String description,int ID_UTILISATEUR) {
        this.ID_DEMANDE=ID_DEMANDE;
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.type = type;
        this.description = description;
    }
    
    
    public Demande() 
    {
        ID_DEMANDE=0;ID_UTILISATEUR=0;
        type="";description="";
    }

    
    
    
    public int getId_demande() {
        return ID_DEMANDE;
    }

    public void setId_demande(int id_demande) {
        this.ID_DEMANDE = ID_DEMANDE;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Demande{" + "ID_DEMANDE=" + ID_DEMANDE + ", ID_UTILISATEUR=" + ID_UTILISATEUR + ", type=" + type + ", description=" + description + '}';
    }
    
    
    
}
