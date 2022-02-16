/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;

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
    //Supprimer
    public void supprimerCartes(int ID_CARTE);
    //Modifier
    public void modifierCartes(int ID_CARTE,Cartes c);
    
}
