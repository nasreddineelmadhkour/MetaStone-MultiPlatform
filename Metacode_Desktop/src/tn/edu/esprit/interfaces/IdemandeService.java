/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;

import java.util.List;
import tn.edu.esprit.model.Demande;

/**
 *
 * @author admin
 */
public interface IdemandeService {
    //Ajouter
    public void ajouterDemande(Demande d);
    //Afficher
    public List<Demande> afficherDemande();
    //Supprimer
    public void supprimerUtilisateur(int ID_DEMANDE);
    //Modifier
    public void modifierUtilisateur(int ID_DEMANDE,Demande d);
}
