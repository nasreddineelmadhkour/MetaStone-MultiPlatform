/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.carte;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import gui.carte.AfficheCartesUserFormController;
import tn.edu.esprit.model.Carte;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class CarteFireController implements Initializable {

    @FXML
    private Label nomC;
     static Carte cart;
    @FXML
    private Label manaC;
    @FXML
    private Label atqC;
    @FXML
    private Label vieC;
    @FXML
    private Label descC;
    public void setInfo(Carte c){
        cart  = c;
        //setChosenCard(c);
        System.out.println(cart);
    }
     public void setChosenCard(Carte c)
     {
       nomC.setText(c.getNom());
       atqC.setText(Integer.toString(c.getattaque()));
       vieC.setText(Integer.toString(c.getvie()));
       descC.setText(c.getdescription());
     }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setChosenCard(cart);
    }

    @FXML
    private void GoTo_AfficherUserCarte(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("../carte/AfficheCartesUserForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
