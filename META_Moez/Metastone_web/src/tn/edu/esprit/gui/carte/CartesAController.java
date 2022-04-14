/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui.carte;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.interfaces.MyListenerCarteAdmin;
import tn.edu.esprit.model.Cartes;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class CartesAController implements Initializable {

    @FXML
    private Label mana;
    @FXML
    private Label atq;
    @FXML
    private Label vie;
    @FXML
    private Label nom_carte;
    @FXML
    private Label desc;
    private MyListenerCarteAdmin myListenerA;
    private Cartes cart;

    /**
     * Initializes the controller class.
     */
     public void setData(Cartes c, MyListenerCarteAdmin myListener) {
        this.cart = c;
        this.myListenerA = myListenerA;
        nom_carte.setText(c.getNom());
        desc.setText(c.getdescription());
        atq.setText(Integer.toString(c.getattaque()));
        vie.setText(Integer.toString(c.getvie()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
        myListenerA.onClickListener(cart);
    }
    
}
