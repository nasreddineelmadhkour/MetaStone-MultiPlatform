/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ProfilController implements Initializable {

        Utilisateur u = new Utilisateur();
        private Parent fxml;
        private Scene scene;
        private Stage stage;
    @FXML
    private Button button_quitter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setUtilisateur(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void to_settings(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Infoprofil.fxml"));
             fxml=loader.load(); 
             InfoprofilController infoprofilController=loader.getController();
             infoprofilController.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        
        
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
             fxml=loader.load(); 
             HomeController homecontroller=loader.getController();
             homecontroller.setUtilisateur(this.u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }
    
}
