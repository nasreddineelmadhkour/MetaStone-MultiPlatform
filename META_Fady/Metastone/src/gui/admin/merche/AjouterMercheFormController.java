/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.admin.merche;


import gui.admin.merche.*;
import gui.*;
import tn.edu.esprit.metastone.*;
import gui.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.MercheService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AjouterMercheFormController implements Initializable {

    @FXML
    private TextField tfNom_produit;
    @FXML
    private TextField tfTaille_produit;
    @FXML
    private TextField tfQuantite_produit;
    @FXML
    private TextField tfPrix_produit;
    @FXML
    private Button bAjouterMerche;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfDescription_produit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addMerche(ActionEvent event) {
        String nom = tfNom_produit.getText();
        int prix = Integer.parseInt(tfPrix_produit.getText());
        String description = tfDescription_produit.getText();
        String type = tfType.getText();
        int taille = Integer.parseInt(tfTaille_produit.getText());
        int qte = Integer.parseInt(tfQuantite_produit.getText());
        Merche m = new Merche(nom, prix, description, type, taille, qte);
        MercheService merche = new MercheService();
        Alert alert = new Alert(AlertType.INFORMATION);

        try {
            merche.ajouterMerche(m);
            alert.setTitle("Success");
            alert.setHeaderText("Ajouter!");
            alert.setContentText("Merche Ajouter avec success!");
        } catch (SQLException ex) {
            alert.setAlertType(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Add error!");
            alert.setContentText(ex.getMessage());

        } finally {
            alert.showAndWait();
        }

    }

    @FXML
    private void retourAffiche(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("AfficheMercheForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      //  stage.initModality(Modality.APPLICATION_MODAL);
      //  stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
