/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ProfilController implements Initializable {

        Utilisateur u = new Utilisateur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setUtilisateur(Utilisateur u) {
        this.u=u;
    }
    
}
