/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class LoginController implements Initializable {

    @FXML
    private Button button_connexion;
    @FXML
    private Button button_mpd_oublier_login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    
    private Parent fxml;
    private Scene scene;
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connexion(ActionEvent event) throws SQLException, IOException {
        ServiceUtilisateur Us=new ServiceUtilisateur(),USER=new ServiceUtilisateur();
        if(Us.verifierLogin(username.getText(),password.getText()))
        {
            Utilisateur U=new Utilisateur();
            U=Us.getUtilisateur(username.getText());
            System.out.println("Connected");
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
             fxml=loader.load(); 
             HomeController homecontroller=loader.getController();
             U=USER.getUtilisateur(U.getID_UTILISATEUR());
             homecontroller.setUtilisateur(U);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();

             stage.show();
             
        }
        else{
            System.out.println("Mch Connected");
        
        }
    }

    @FXML
    private void mdp_oublier(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Mdpoublier.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.show();
        
    }

    @FXML
    private void exit(ActionEvent event) {
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void inscription(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.show();
    }
    
}
