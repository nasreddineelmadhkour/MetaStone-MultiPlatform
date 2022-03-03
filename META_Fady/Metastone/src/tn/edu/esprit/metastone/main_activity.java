/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author FadyBelY
 */
public class main_activity extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            URL fxURL = getClass().getResource("../../../../gui/ChoiceForm.fxml");
            Parent root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Metastone");
            primaryStage.show();
        } catch (IOException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
        }finally{
            alert.showAndWait();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
