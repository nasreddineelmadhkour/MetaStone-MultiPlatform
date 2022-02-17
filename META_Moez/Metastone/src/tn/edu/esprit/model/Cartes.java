/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author Moez
 */
public class Cartes {
    private int ID_CARTE;
    private int mana;
    private String type;
    private int vie;
    private int prix;
    private String image;
    private int attaque;
    private int defence;
    private String rarete;
    private String nom;
    private String description;
    private int visibilte;
    private String id;
       
       
//constructor
    public Cartes(int mana, String type, int vie, int prix, String image, int attaque, int defence, String rarete, String nom, String description,int visibilte) {
        
        this.mana = mana;
        this.type = type;
        this.vie = vie;
        this.prix = prix;
        this.image = image;
        this.attaque = attaque;
        this.defence = defence;
        this.rarete = rarete;
        this.nom = nom;
        this.description = description;
        this.visibilte = visibilte;
    }
    public Cartes(int ID_CARTE, int mana, String type, int vie, int prix, String image, int attaque, int defence, String rarete, String nom, String description,int visibilte) {
        this.ID_CARTE = ID_CARTE;
        this.mana = mana;
        this.type = type;
        this.vie = vie;
        this.prix = prix;
        this.image = image;
        this.attaque = attaque;
        this.defence = defence;
        this.rarete = rarete;
        this.nom = nom;
        this.description = description;
        this.visibilte = visibilte;
    }

    //..
    public Cartes ()
    {
       
       mana=0;
       type="";
       vie=0;
       prix=0;
       image="";
       attaque=0;
       defence=0;
       rarete="";
       nom="";
       description="";
       visibilte=0;

       
       
    }


    




    public String getId() {
        return id;
    }




    public int getmana() {
        return mana;
    }

    public String gettype() {
        return type;
    }

    public int getvie() {
        return vie;
    }

    public int getprix() {
        return prix;
    }
    
    public String getimage() {
        return image;
    }

    

    public int getattaque() {
        return attaque;
    }

    public int getdefence() {
        return defence;
    }

    public String getrarete() {
        return rarete;
    }
    
    public String getNom() {
        return nom;
    }

    public String getdescription() {
        return description;
    }

    public int getvisibilte() {
        return visibilte;
    }

  
    public void setId(String id) {
        this.id = id;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setRarete(String rarete) {
        this.rarete = rarete;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisibilite(int visibilte) {
        this.visibilte = visibilte;
    }


    public int getID_CARTE() {
        return ID_CARTE;
    }

    public void setID_CARTE(int ID_CARTE) {
        this.ID_CARTE = ID_CARTE;
    }
    
    
    //Affichage

    @Override
    public String toString() {
        return "Cartes{" + "id=" + ID_CARTE +  ", mana=" + mana + ", type=" + type + ", vie=" + vie + ", prix=" + prix + ", image=" + image + ", attaque=" + attaque + ", defence=" + defence + ", rarete=" + rarete + ", nom=" + nom + ", description=" + description + ", visibilte=" + visibilte + '}';
    }

    public void modifiercartes(int i, Cartes c) {
    }

  
            
}
