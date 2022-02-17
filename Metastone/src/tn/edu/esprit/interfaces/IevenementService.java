/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;


import java.util.List;
import tn.edu.esprit.model.Evenement;
/**
 *
 * @author proinfo.tn
 */
public interface IevenementService {
    //ajouter
    public void ajouterEvenemenet(Evenement e);
    //afficher
    public List<Evenement> afficherEvenement();
    //supprimer
     public void supprimerEvenement(int id_Evenement );
    //modifier
     public void modifierEvenement (int id_Evenement,Evenement e );
    
}
