/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;
import java.util.Date;

/**
 *
 * @author FadyBelY
 */
public class Commande {
//attribs
    private int Id_commande;
    private String Type_paiement;
    private String Date_commande;
    private int Prix_total;
    private String Adresse;
    private String Date_livraison;
    private int Id_utilisateur;
    private int Id_produit;
    private int Quantite_acheter;
//CTOR
    //ctor with ID
    public Commande(int Id_commande, String Type_paiement, String Date_commande, int Prix_total, String Adresse, String Date_livraison, int Id_utilisateur)
    {
        this.Id_commande = Id_commande;
        this.Type_paiement = Type_paiement;
        this.Date_commande = Date_commande;
        this.Prix_total = Prix_total;
        this.Adresse = Adresse;
        this.Date_livraison = Date_livraison;
        this.Id_utilisateur = Id_utilisateur;
    }
    //ctor w/o ID
    public Commande(String Type_paiement, String Date_commande, int Prix_total, String Adresse, String Date_livraison)
    {
        this.Type_paiement = Type_paiement;
        this.Date_commande = Date_commande;
        this.Prix_total = Prix_total;
        this.Adresse = Adresse;
        this.Date_livraison = Date_livraison;
    }
    //ctor default
    public Commande()
    {
        Type_paiement = "";
        Date_commande = "";
        Prix_total = 0;
        Adresse = "";
        Date_livraison = "";
    }
    
    //ctor with id_user
    public Commande(String Type_paiement, String Date_commande, int Prix_total, String Adresse, String Date_livraison, int Id_utilisateur,int Id_produit,int Quantite_acheter) {
        this.Type_paiement = Type_paiement;
        this.Date_commande = Date_commande;
        this.Prix_total = Prix_total;
        this.Adresse = Adresse;
        this.Date_livraison = Date_livraison;
        this.Id_utilisateur = Id_utilisateur;
        this.Id_produit = Id_produit;
        this.Quantite_acheter = Quantite_acheter;
    }

    public int getQuantite_acheter() {
        return Quantite_acheter;
    }

    public void setQuantite_acheter(int Quantite_acheter) {
        this.Quantite_acheter = Quantite_acheter;
    }
    public int getId_produit() {    
        return Id_produit;
    }

//GETTER & SETTER
    public void setId_produit(int Id_produit) {    
        this.Id_produit = Id_produit;
    }

    //GETTERS
    public int getId_commande() {
        return Id_commande;
    }

    public String getType_paiement() {
        return Type_paiement;
    }

    public String getDate_commande() {
        return Date_commande;
    }

    public int getPrix_total() {
        return Prix_total;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getDate_livraison() {
        return Date_livraison;
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }
    
    //SETTERS
    public void setId_commande(int Id_commande) {
        this.Id_commande = Id_commande;
    }

    public void setType_paiement(String Type_paiement) {
        this.Type_paiement = Type_paiement;
    }

    public void setDate_commande(String Date_commande) {
        this.Date_commande = Date_commande;
    }

    public void setPrix_total(int Prix_total) {
        this.Prix_total = Prix_total;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setDate_livraison(String Date_livraison) {
        this.Date_livraison = Date_livraison;
    }

    public void setId_utilisateur(int Id_utilisateur) {
        this.Id_utilisateur = Id_utilisateur;
    }
    
//Affichage
    //to String
    @Override
    public String toString() {
        return "Commande{" + "Id_commande=" + Id_commande + ", Type_paiement=" + Type_paiement + ", Date_commande=" + Date_commande + ", Prix_total=" + Prix_total + ", Adresse=" + Adresse + ", Date_livraison=" + Date_livraison + ", Id_utilisateur=" + Id_utilisateur + '}';
    }
    
            
            
            
}
