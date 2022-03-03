/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.admin.merche;

import gui.admin.merche.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.MercheService;
import tn.edu.esprit.util.MaConnexion;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AfficheMercheFormController implements Initializable {

    @FXML
    private TableView<Merche> tvMerche;
    @FXML
    private TableColumn<Merche, String> nom_prod;
    @FXML
    private TableColumn<Merche, Integer> prix_prod;
    @FXML
    private TableColumn<Merche, String> desc_prod;
    @FXML
    private TableColumn<Merche, String> type_prod;
    @FXML
    private TableColumn<Merche, Integer> taille_prod;
    @FXML
    private TableColumn<Merche, Integer> qte_prod;
    
    
    
    /**
     * Initializes the controller class.
     */
   // ObservableList<Merche> mercheList = new FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Merche> mercheList;
        nom_prod.setCellValueFactory(new PropertyValueFactory<Merche,String>("Nom_produit"));
        prix_prod.setCellValueFactory(new PropertyValueFactory<Merche,Integer>("Prix_produit"));
        desc_prod.setCellValueFactory(new PropertyValueFactory<Merche,String>("Description_produit"));
        type_prod.setCellValueFactory(new PropertyValueFactory<Merche,String>("Type_produit"));
        taille_prod.setCellValueFactory(new PropertyValueFactory<Merche,Integer>("Taille_produit"));
        qte_prod.setCellValueFactory(new PropertyValueFactory<Merche,Integer>("Quantite_produit"));
        MercheService merche = new MercheService();
        mercheList = (ObservableList<Merche>) merche.afficherMerche();
        //tvMerche.setItems(merche.afficherMerche());
    }

    @FXML
    private void modifierProd(ActionEvent event) {
    }

    @FXML
    private void supprimerProd(ActionEvent event) {
    }

    @FXML
    private void ajoutProd(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("AjouterMercheForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //  stage.initModality(Modality.APPLICATION_MODAL);
        //  stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void retourMC(ActionEvent event) {
    }

}
