/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.edu.esprit.gui.carte;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.edu.esprit.interfaces.MyListenerCarteAdmin;
import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.service.CartesService;

/**
 * FXML Controller class
 *
 * @author fady_bel_y
 */
public class AfficheCartesAdminFormController implements Initializable {
   
    private String parNom = "";
   
    private Cartes carte;
    private List<Cartes> carteList = new ArrayList<>();
    private String nom = "";
    private MyListenerCarteAdmin myListener;
    @FXML
    private Button bAjouter;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private TextField nomC;
    @FXML
    private TextField typeC;
    @FXML
    private TextField manaC;
    @FXML
    private TextField vieC;
    @FXML
    private TextField atqC;
    @FXML
    private TextField defC;
    @FXML
    private TextField rareC;
    @FXML
    private TextField prixC;
    @FXML
    private TextField descC;
    @FXML
    private Label idC;

    private void setChosenCarte(Cartes carte) {
        if (nom.compareTo("") == 0) {
            idC.setText(Integer.toString(carte.getID_CARTE()));
            nomC.setText(carte.getNom());
               typeC.setText(carte.gettype());
               manaC.setText(Integer.toString(carte.getmana()));
               vieC.setText(Integer.toString(carte.getvie()));
               atqC.setText(Integer.toString(carte.getattaque()));
               defC.setText(Integer.toString(carte.getdefence()));
               rareC.setText(carte.getrarete());
               prixC.setText(Integer.toString(carte.getprix()));
               descC.setText(carte.getdescription());
               
            bAjouter.setDisable(true);
            bModifier.setDisable(false);
            bSupprimer.setDisable(false);

        } else {
            idC.setText("");
                nomC.setText("");
               typeC.setText("");
               manaC.setText("");
               vieC.setText("");
               atqC.setText("");
               defC.setText("");
               rareC.setText("");
               prixC.setText("");
               descC.setText("");
            bAjouter.setDisable(false);
            bModifier.setDisable(true);
           bSupprimer.setDisable(true);
        }

    }

    public void Update(String nomProd) {
        Cartes carte;
        CartesService cartes = new CartesService();
        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(cartes.afficherCartesParNom(parNom));
        myListener = new MyListenerCarteAdmin() {
            @Override
            public void onClickListener(Cartes carte) {
                setChosenCarte(carte);

            }
        };

        int c = 0;
        int l = 0;
        try {
            for (int i = 0; i < carteList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CartesA.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                CartesAController cartesController = fxmlLoader.getController();
                cartesController.setData(carteList.get(i), myListener);
                if (c > 2) {
                    c = 0;
                    l++;
                }
                grid.add(anchorPane, c++, l);
                //grid weight
                grid.setMinWidth(164);
                grid.setPrefWidth(164);
                grid.setMaxWidth(164);//
                //height
                grid.setMinHeight(233);
                grid.setPrefHeight(233);
                grid.setMaxHeight(233);//
                grid.setLayoutY(20);

               
                GridPane.setMargin(anchorPane, new Insets(150, 0, 20, 40));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // bProd.setDisable(true);
        bAjouter.setDisable(false);
        bModifier.setDisable(true);
        bSupprimer.setDisable(true);
//        filtre.getItems().add("Nom");
//        filtre.getItems().add("Type");
//        filtre.getItems().add("Taille");
       
       
       // nom = nomProd_ch.toString();
        parNom = "";
        Update(parNom);
    }




    @FXML
    private void AJOUTER(ActionEvent event) {
        CartesService cartes = new CartesService();
        Alert alert = new Alert(AlertType.INFORMATION);
          Cartes carte = new Cartes(Integer.parseInt(manaC.getText()), typeC.getText(), Integer.parseInt(vieC.getText()), Integer.parseInt(prixC.getText()), "", Integer.parseInt(atqC.getText()), Integer.parseInt(defC.getText()), rareC.getText(), nomC.getText(), descC.getText(), 1);
          cartes.ajouterCartes(carte);
          alert.setAlertType(AlertType.INFORMATION);
          alert.setTitle("Success");
          alert.setHeaderText("Ajouter!");
          alert.setContentText("Carte Ajouter avec success!");
          parNom = "";
          Update(parNom);
          alert.showAndWait();
    }

    @FXML
    private void MODIFIER(ActionEvent event) {
        Cartes carte = new Cartes(Integer.parseInt(manaC.getText()), typeC.getText(), Integer.parseInt(vieC.getText()), Integer.parseInt(prixC.getText()), "", Integer.parseInt(atqC.getText()), Integer.parseInt(defC.getText()), rareC.getText(), nomC.getText(), descC.getText(), 1);
        CartesService cartes = new CartesService();
        int id = Integer.parseInt(idC.getText());
        cartes.modifierCartes(id, carte);
        carteList.clear();
        grid.getChildren().clear();
        parNom = "";
        Update(parNom);
    }

    @FXML
    private void SUPPRIMER(ActionEvent event) {
        CartesService cartes = new CartesService();
        int id = Integer.parseInt(idC.getText());
        cartes.supprimerCartes(id);
        carteList.clear();
        grid.getChildren().clear();
        parNom = "";
        Update(parNom);
    }
   
}