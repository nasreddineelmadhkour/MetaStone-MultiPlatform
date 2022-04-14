/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

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
    public List<Collection> afficherCollection(int ID_UTILISATEUR);
    //Supprimer
    public void supprimerCollection(int Collection);
    //Modifier
    public void modifierCollection(int ID_UTILISATEUR,int ID_CARTE, Collection n);    //Fusionner
    public int fusionnerCollection(int ID_COLLECTION1,int ID_COLLECTION2,int Id_utilisateur);
    public Collection afficheCollection(int id_collection);

}
