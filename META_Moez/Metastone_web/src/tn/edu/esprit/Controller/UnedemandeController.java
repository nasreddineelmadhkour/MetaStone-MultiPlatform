/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class UnedemandeController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Label description;
    int id_demande;
    int id_utilisateur;
    @FXML
    private AnchorPane anchor_demande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public AnchorPane getAnchor_demande() {
        return anchor_demande;
    }

    public void setAnchor_demande(AnchorPane anchor_demande) {
        this.anchor_demande = anchor_demande;
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    
    
    
}
