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
//constructor
public class Collection {
    private int ID_COLLECTION, ID_UTILISATEUR, ID_Carte;

    public Collection(int ID_COLLECTION, int ID_UTILISATEUR, int ID_Carte) {
        this.ID_COLLECTION = ID_COLLECTION;
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.ID_Carte = ID_Carte;
    }
    public Collection(int ID_Carte, int ID_COLLECTION) {
        this.ID_COLLECTION=ID_COLLECTION;
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }
    
    
    public Collection() 
    {
        
    }

    public int getId_collection() {
        return ID_COLLECTION;
    }

    public void setId_collection(int id_collection) {
        this.ID_COLLECTION = ID_COLLECTION;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }
    
    public void setID_Carte(int ID_Carte) {
        this.ID_Carte = ID_Carte;
    }


    

    /*@Override
    public String toString() {
        return "COLLECTION{" + "ID_COLLECTION=" + ID_COLLECTION + ", ID_UTILISATEUR=" + ID_UTILISATEUR + ", ID_Carte=" + ID_Carte +'}';
    }*/
    
    
    
}
