/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Utilisateur;

/**
 *
 * @author admin
 */
public interface IutilisateurService {
    //
    public void ajouterUtilisateur(Utilisateur u);
    //Afficher
    public List<Utilisateur> afficherUtilisateur();
    //Supprimer
    public void supprimerUtilisateur(int ID_UTILISATEUR);
    //Modifier
    public void modifierUtilisateur(int ID_UTILISATEUR,Utilisateur u);
}
