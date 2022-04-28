/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;


import java.util.List;
import tn.edu.esprit.model.Tournoi;
/**
 *
 * @author proinfo.tn
 */
public interface ItournoiService {
    //ajouter
    public void ajoutertournoi(Tournoi t);
    //afficher
    public List<Tournoi> affichertournoi();
    //supprimer
     public void supprimertournoi(int id_tournoi );
    //modifier
     public void modifiertournoi (int id_tournoi,Tournoi t );
    
}
