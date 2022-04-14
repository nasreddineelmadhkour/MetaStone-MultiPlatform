/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;


import java.util.List;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.lignetournoi;
/**
 *
 * @author proinfo.tn
 */
public interface IlignetournoiService {
    //ajouter
    public void ajouterlignetournoi(lignetournoi j);
    //afficher
    public List<lignetournoi> afficherlignetournoi();
    //supprimer
     public void supprimerlignetournoi(int id_lignetournoi );
    //modifier
     public void modifierlignetournoi (int id_lignetournoi,lignetournoi j );
      
    
}
