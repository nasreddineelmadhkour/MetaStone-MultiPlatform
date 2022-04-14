package tn.edu.esprit.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import tn.edu.esprit.model.Poste;

/**
 *
 * @author ASUS
 */
public interface IposteService {
   
    //Ajouter
    public void ajouterPoste(Poste p);
    //Afficher
    public List<Poste> afficherPoste();
    //Supprimer
    public void supprimerPoste(int Id_poste);
    //Modifier
    public void modifierPoste(int Id_poste ,Poste p);
    public List<Poste> findbyCategorie(String Categorie);
    public List<Poste> sortByDate();

    //public List<Poste> afficherPosteParCategorie(String Categorie);
   // public List<Poste> afficherPosteParDate(int UpVote);

    

}
