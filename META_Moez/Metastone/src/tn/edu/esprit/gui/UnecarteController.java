/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class UnecarteController implements Initializable {

    @FXML
    private AnchorPane anchor_carte;
    @FXML
    private Label label_carte;
    private int id_collection;
    @FXML
    private ImageView image_carte;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public AnchorPane getAnchor_carte() {
        return anchor_carte;
    }

    public void setAnchor_carte(AnchorPane anchor_carte) {
        this.anchor_carte = anchor_carte;
    }

    public Label getLabel_carte() {
        return label_carte;
    }

    public void setLabel_carte(Label label_carte) {
        this.label_carte = label_carte;
    }

    public int getId_collection() {
        return id_collection;
    }

    public void setId_collection(int id_collection) {
        this.id_collection = id_collection;
    }

    
    
}
