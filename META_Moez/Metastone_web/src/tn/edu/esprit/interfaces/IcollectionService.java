/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;

import java.util.List;
import tn.edu.esprit.model.Collection;
//import tn.edu.esprit.model.collection;

/**
 *
 * @author Moez
 */
public interface IcollectionService {
    //Ajouter
    public void ajouterCollection(Collection n);
    //Afficher
    public List<Collection> afficherCollection();
    //Supprimer
    public void supprimerCollection(int Collection);
    //Modifier
    public void modifierCollection(int ID_UTILISATEUR,int ID_CARTE, Collection n);    //Fusionner
    public void fusionnerCollection(int ID_COLLECTION1,int ID_COLLECTION2,int Id_utilisateur);
}
