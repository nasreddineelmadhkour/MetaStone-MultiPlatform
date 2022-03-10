/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.carte;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.edu.esprit.interfaces.MyListenerCarte;
import tn.edu.esprit.model.Cartes;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class CartesController implements Initializable {

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
    private MyListenerCarte myListener;
    private Cartes cart;

    public void setData(Cartes c, MyListenerCarte myListener) {
        this.cart = c;
        this.myListener = myListener;
        nom_carte.setText(c.getNom());
        desc.setText(c.getdescription());
        atq.setText(Integer.toString(c.getattaque()));
        vie.setText(Integer.toString(c.getvie()));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent event) throws IOException {
       myListener.onClickListener(cart);
//        URL fxURL = getClass().getResource("CarteFire.fxml");
//        FXMLLoader loader = new FXMLLoader(fxURL);
//        Parent root = (Parent) loader.load();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setTitle("Metastone - Merche");
//        stage.setScene(new Scene(root));
//        stage.show();

    }

}
