/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class ChoiceFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void merche(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("../gui/admin/merche/AjouterMercheForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //  stage.initModality(Modality.APPLICATION_MODAL);
        //  stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
