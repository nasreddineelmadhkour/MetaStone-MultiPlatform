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
 * @author FadyBelY
 */
public interface IcarteService {
    public List<Cartes> afficherCartes();
    public void ajouterCartes(Cartes c);
    public void supprimerCartes(int ID_CARTE);
    public void modifierCartes(int ID_CARTE,Cartes c);
    public List<Cartes> afficherCartesParId(int Id_carte);
    public List<Cartes> afficherCartesParType(String type);
    public List<Cartes> afficherCartesParNom(String Nom);
    //public List<Cartes> afficherCarte();
    public List<Cartes> afficherCartesParMana(int Mana);
    
    
}
