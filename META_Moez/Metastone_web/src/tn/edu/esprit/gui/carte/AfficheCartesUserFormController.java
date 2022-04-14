/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui.carte;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import tn.edu.esprit.interfaces.MyListenerCarte;
import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.service.CartesService;

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
    private static Cartes c;
    
    public String nomCarte;
    
    private List<Cartes> carteList = new ArrayList<>();
    @FXML
    private TextField tfNom;
    
    
    public void UpdateParNom(String nom)
    {
        
        CartesService carte = new CartesService();
        
        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(carte.afficherCartesParNom(nom));
        
        myListener = new MyListenerCarte() {
            @Override
            public void onClickListener(Cartes c) {
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
    public void UpdateMana7plus(){
        CartesService carte = new CartesService();
        
        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(carte.afficherCartesParMana(7));
        carteList.addAll(carte.afficherCartesParMana(8));
        carteList.addAll(carte.afficherCartesParMana(9));
        carteList.addAll(carte.afficherCartesParMana(10));
        
        myListener = new MyListenerCarte() {
            @Override
            public void onClickListener(Cartes c) {
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
    public void UpdateMana(int mana) {
        CartesService carte = new CartesService();
        
        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(carte.afficherCartesParMana(mana));
        
        myListener = new MyListenerCarte() {
            @Override
            public void onClickListener(Cartes c) {
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
    
    public void Update() {
        
        CartesService carte = new CartesService();
        
        carteList.clear();
        grid.getChildren().clear();
        carteList.addAll(carte.afficherCartes());
        
        myListener = new MyListenerCarte() {
            @Override
            public void onClickListener(Cartes c) {
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
    
    @FXML
    private void afficheM0(ActionEvent event) {
        UpdateMana(0);
    }
    
    @FXML
    private void afficheM1(ActionEvent event) {
        UpdateMana(1);
    }
    
    @FXML
    private void afficheM2(ActionEvent event) {
        UpdateMana(2);
    }
    
    @FXML
    private void afficheM3(ActionEvent event) {
        UpdateMana(3);
    }
    
    @FXML
    private void afficheM4(ActionEvent event) {
         UpdateMana(4);
    }
    
    @FXML
    private void afficheM5(ActionEvent event) {
         UpdateMana(5);
    }
    
    @FXML
    private void afficheM6(ActionEvent event) {
         UpdateMana(6);
    }
    
    @FXML
    private void afficheM7(ActionEvent event) {
         UpdateMana7plus();
         
    }
    
    @FXML
    private void afficheAll(ActionEvent event) {
        Update();
    }

    @FXML
    private void search(ActionEvent event) {
        UpdateParNom(tfNom.getText());
    }
    
}
