package tn.edu.esprit.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

     
import java.util.List;
import tn.edu.esprit.model.Commentaire;

/**
 *
 * @author ASUS
 */
public interface IcommentaireService {
    //Ajouter
    public void ajouterCommentaire(Commentaire c);
    //Afficher
    public List<Commentaire> afficherCommentaire();
    //Supprimer
    public void supprimerCommentaire(int Id_cmnt );
    //Modifier
    public void modifierCommentaire(int Id_cmnt ,Commentaire c);

}
