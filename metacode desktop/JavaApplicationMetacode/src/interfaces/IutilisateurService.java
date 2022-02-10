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
    //add
    public void ajouterUtilisateur(Utilisateur u);
    //affichage
    public List<Utilisateur> afficherUtilisateur();
}
