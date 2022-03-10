/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.interfaces;

import java.sql.SQLException;
import java.util.List;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.model.Utilisateur;

/**
 *
 * @author FadyBelY
 */
public interface ImercheService {
    //Ajouter
    public void ajouterMerche(Merche m) throws SQLException;
    public void modifierMerche(Merche m, int Id_produit) throws SQLException;
    public void supprimerMerche(int Id_produit);
    public List<Merche> afficherMerche();
    //public List<Merche> afficherMesMerches(int Id_utilisateur);
    
    //LES METIERS
    //abonement
    public void abonnementMerche(int ID_utilisateur);
    public void desabonnementMerche(int ID_utilisateur);
        //recherche:
    public List<Merche> afficherMercheParNom(String Nom_produit);
    public List<Merche> afficherMercheParType(String Type_produit);
    public List<Merche> afficherMercheParPrix(boolean croissante);
    //test
    public boolean idProdExiste(int Id_produit);
   
        // Acheter
    public void acheterMerche(int Id_produit, int ID_utilisateur,int Quantite_a_acheter);
}
//mail baad mayechri fih purchasing details , sms .