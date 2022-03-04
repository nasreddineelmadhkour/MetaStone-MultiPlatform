/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.util.List;
import tn.edu.esprit.model.Cartes;

/**
 *
 * @author Moez
 */
public interface IcartesService {
    //Ajouter
    public void ajouterCartes(Cartes c);
    //Afficher
    public List<Cartes> afficherCartes();
             //par id
             public List<Cartes> afficherCartesParId(int Id_utilisateur);
             //par Type
             public List<Cartes> afficherCartesParType(String Type);
             //par Nom
             public List<Cartes> afficherCartesParNom (String Nom);
    //Supprimer
    public void supprimerCartes(int ID_CARTE);
    //Modifier
    public void modifierCartes(int ID_CARTE,Cartes c);
    public Cartes getCarte(int id_carte);
}
