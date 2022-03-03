/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import tn.edu.esprit.service.MercheService;
import tn.edu.esprit.interfaces.ImercheService;


/**
 *
 * @author FadyBelY
 */
public class Merche {
//attribs
    private int Id_produit;
    private String Nom_produit;
    private int Prix_produit;
    private String Description_produit;
    private String Type_produit;
    private int Taille_produit;
    private int Quantite_produit;
//ctor
    
    //ctor with ID
    public Merche(int Id_produit, String Nom_produit, int Prix_produit, String Description_produit, String Type_produit, int Taille_produit,int Quantite_produit)
    {
        this.Id_produit = Id_produit;
        this.Nom_produit = Nom_produit;
        this.Prix_produit = Prix_produit;
        this.Description_produit = Description_produit;
        this.Type_produit = Type_produit;
        this.Taille_produit = Taille_produit;
        this.Quantite_produit = Quantite_produit;
    }
    
    //ctor w/o ID
    public Merche(String Nom_produit, int Prix_produit, String Description_produit, String Type_produit, int Taille_produit,int Quantite_produit)
    {
        this.Nom_produit = Nom_produit;
        this.Prix_produit = Prix_produit;
        this.Description_produit = Description_produit;
        this.Type_produit = Type_produit;
        this.Taille_produit = Taille_produit;
        this.Quantite_produit = Quantite_produit;
    }
    
    //ctor default
    public Merche()
    {
        Nom_produit = "";
        Prix_produit = 0;
        Description_produit = "";
        Type_produit = "";
        Taille_produit = 0;
    }
    
 //GETTER & SETTER
    
    // GETTERS
    public int getId_produit() {
        return Id_produit;
    }

    public String getNom_produit() {
        return Nom_produit;
    }

    public int getPrix_produit() {
        return Prix_produit;
    }

    public String getDescription_produit() {
        return Description_produit;
    }

    public String getType_produit() {
        return Type_produit;
    }

    public int getTaille_produit() {
        return Taille_produit;
    }
    
    //SETTERS
    public void setId_produit(int Id_produit) {
        this.Id_produit = Id_produit;
    }

    public void setNom_produit(String Nom_produit) {
        this.Nom_produit = Nom_produit;
    }

    public void setPrix_produit(int Prix_produit) {
        this.Prix_produit = Prix_produit;
    }

    public void setDescription_produit(String Description_produit) {
        this.Description_produit = Description_produit;
    }

    public void setType_produit(String Type_produit) {
        this.Type_produit = Type_produit;
    }

    public void setTaille_produit(int Taille_produit) {
        this.Taille_produit = Taille_produit;
    }

    public int getQuantite_produit() {
        return Quantite_produit;
    }

    public void setQuantite_produit(int Quantite_produit) {
        this.Quantite_produit = Quantite_produit;
    }
    
//Affichage
    
    //to String

    @Override
    public String toString() {
        return "Merche{" + "Id_produit=" + Id_produit + ", Nom_produit=" + Nom_produit + ", Prix_produit=" + Prix_produit + ", Description_produit=" + Description_produit + ", Type_produit=" + Type_produit + ", Taille_produit=" + Taille_produit + ", Quantite_produit=" + Quantite_produit + '}';
    }
   


}

