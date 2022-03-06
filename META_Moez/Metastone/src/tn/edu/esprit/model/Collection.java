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
    private int ID_COLLECTION, ID_UTILISATEUR, ID_CARTE;
    private String id,image;

    public Collection(int ID_COLLECTION, int ID_UTILISATEUR, int ID_CARTE) {
        this.ID_COLLECTION = ID_COLLECTION;
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.ID_CARTE = ID_CARTE;
    }
    public Collection(int ID_UTILISATEUR, int ID_CARTE) {
        this.ID_UTILISATEUR=ID_UTILISATEUR;
        this.ID_CARTE = ID_CARTE;
    }
       
    public Collection ()
    {
    }
    
    
    public String getId() {
        return id;
    }
    

    public int getID_COLLECTION() {
        return ID_COLLECTION;
    }

    public void setID_COLLECTION(int ID_COLLECTION) {
        this.ID_COLLECTION = ID_COLLECTION;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }
    
    public int getID_CARTE() {
        return ID_CARTE;
    }
    
    public void setID_CARTE(int ID_CARTE) {
        this.ID_CARTE = ID_CARTE;
    }
    
    
   public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    

    @Override
    public String toString() {
        return "COLLECTION{" + "ID_COLLECTION=" + ID_COLLECTION + ", ID_UTILISATEUR=" + ID_UTILISATEUR + ", ID_CARTE=" + ID_CARTE +'}';
    }

 
    
    
}
