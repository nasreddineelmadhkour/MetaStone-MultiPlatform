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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class NewpasswordController implements Initializable {

    @FXML
    private PasswordField lineEdit_new_password;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    @FXML
    private Label label_id_user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void continuer(ActionEvent event) throws SQLException {
        
        if(lineEdit_new_password.getText()!="")
        {
            Iservices USER=new ServiceUtilisateur();
            ServiceUtilisateur USER_ex=new ServiceUtilisateur();
            Utilisateur U=new Utilisateur();
            U=USER_ex.getUtilisateur(Integer.parseInt(label_id_user.getText()));
            U.setMot_de_passe(lineEdit_new_password.getText());
            USER.modifier(U,Integer.parseInt(label_id_user.getText()));
            
            
        }
        else
        {
            System.out.println("Ekteb mot de passe");
        }
        
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show(); 
    }

    void setUtilisateur(Utilisateur U) {
        
        label_id_user.setText(Integer.toString(U.getID_UTILISATEUR()));

    }
    
}
