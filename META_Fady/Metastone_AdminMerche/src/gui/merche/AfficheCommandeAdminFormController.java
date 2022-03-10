/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.merche;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tn.edu.esprit.model.Commande;
import tn.edu.esprit.service.CommandeService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AfficheCommandeAdminFormController implements Initializable {

    @FXML
    private Button bCommande;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private Button bAjouter;

    private List<Commande> commandeList = new ArrayList<>();
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    public void Update() {
        Commande cmd;
        CommandeService commande = new CommandeService();
        
        commandeList.clear();
        grid.getChildren().clear();
        commandeList.addAll(commande.afficherToutLesCommande());
        int c = 0;
        int l = 0;
        try {
            for (int i = 0; i < commandeList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("commandesItem.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                CommandesItemController commandeController = fxmlLoader.getController();
                commandeController.setData(commandeList.get(i));
                if (c > 0) {
                    c = 0;
                    l++;
                }
                grid.add(anchorPane, c++, l);
                //grid weight
                grid.setMinWidth(200);
                grid.setPrefWidth(200);
                grid.setMaxWidth(200);//
                //height
                grid.setMinHeight(303);
                grid.setPrefHeight(303);
                grid.setMaxHeight(303);//
                grid.setLayoutY(20);

               GridPane.setMargin(anchorPane, new Insets(20, 0, 0, 40));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bCommande.setDisable(true);
        bAjouter.setDisable(true);
        bModifier.setDisable(true);
        bSupprimer.setDisable(true);
        Update();
    }

    @FXML
    private void GoToProduit(ActionEvent event) throws IOException {
       // URL fxURL = getClass().getResource("AfficheMercheAdminForm.fxml");
       URL fxURL = getClass().getResource("../carte/AfficheCartesUserForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
