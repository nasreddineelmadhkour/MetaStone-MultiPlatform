/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;

import java.util.List;
import tn.edu.esprit.model.Merche;

/**
 *
 * @author FadyBelY
 */
public interface ImercheService {
    //Ajouter
    public void ajouterMerche(Merche m);
    public void modifierMerche(Merche m, int Id_produit);
    public void supprimerMerche(int Id_produit);
    public List<Merche> afficherMerche();
    public List<Merche> afficherMesMerches(int Id_utilisateur);
    
}
