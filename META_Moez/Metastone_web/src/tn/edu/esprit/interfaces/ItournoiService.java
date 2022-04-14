/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;


import java.util.List;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.lignetournoi;
import tn.edu.esprit.service.TournoiService.TrayIconDemo;
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
     
     public void displayTray(TrayIconDemo td);
     
}
