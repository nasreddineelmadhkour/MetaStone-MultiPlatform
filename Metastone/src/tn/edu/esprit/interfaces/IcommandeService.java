/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;
import java.util.List;
import tn.edu.esprit.model.Commande;
/**
 *
 * @author FadyBelY
 */
public interface IcommandeService {
    public void ajouterCommande(Commande c,int Id_utilisateur);
    public void supprimerCommande(int Id_commande);
    public void supprimerTout(int Id_utilisateur);
   // public List<Commande> afficherCommande(int Id_utilisateur);
}
