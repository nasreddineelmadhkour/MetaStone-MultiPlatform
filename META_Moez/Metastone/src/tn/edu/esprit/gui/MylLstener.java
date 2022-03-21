/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;

/**
 *
 * @author THEOLDISBACK
 */
public interface MylLstener {

    public void onClickListener(Poste post);

    public void onClickListener(Commentaire comment);
    

    
}
