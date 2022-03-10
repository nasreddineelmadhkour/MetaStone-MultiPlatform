/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.carte;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import tn.edu.esprit.interfaces.MyListenerCarte;
import tn.edu.esprit.model.Carte;
import tn.edu.esprit.service.CarteService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AfficheCartesUserFormController implements Initializable {
  Parent root = null;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListenerCarte myListener;
    private static Carte c;
    
    public String nomCarte;

    private List<Carte> carteList = new ArrayList<>();

    public void Update() {
        
        CarteService carte = new CarteService();

        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(carte.afficherCarte());
      
        
        myListener = new MyListenerCarte() {
            @Override
            public void onClickListener(Carte c) {
                CarteFireController.cart = c;
                try {
            root = FXMLLoader.load(getClass().getResource("CarteFire.fxml"));
            
        } catch (IOException ex) {
                    System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) scroll.getScene().getWindow();
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
                stage.close();
                primaryStage.show();
            }
        };
        int colonne = 0;
        int l = 0;
        try {
            for (int i = 0; i < carteList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Cartes.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                CartesController carteController = fxmlLoader.getController();
                carteController.setData(carteList.get(i), myListener);
                if (colonne > 4) {
                    colonne = 0;
                    l++;
                }
                grid.add(anchorPane, colonne++, l);
                //grid weight
                grid.setMinWidth(500);
                grid.setPrefWidth(500);
                grid.setMaxWidth(500);//
                //height
                grid.setMinHeight(300);
                grid.setPrefHeight(300);
                grid.setMaxHeight(300);//
                //  grid.setLayoutY(20);

                GridPane.setMargin(anchorPane, new Insets(60, 0, 0, 0));
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
        Update();
    }

}
