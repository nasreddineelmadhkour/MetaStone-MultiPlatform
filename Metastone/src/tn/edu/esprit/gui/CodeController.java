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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class CodeController implements Initializable {

    @FXML
    private TextField lineEdit_code;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    @FXML
    private Label label_user_id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void continuer(ActionEvent event) throws SQLException, IOException {
        
        ServiceUtilisateur USER=new ServiceUtilisateur();
        Utilisateur U=new Utilisateur();
        //System.out.println(Integer.parseInt(label_user_id.getText()));
        
        U=USER.getUtilisateur(Integer.parseInt(label_user_id.getText()));
       
        if(U.getCode()==Integer.parseInt(lineEdit_code.getText()))
        {
            System.out.println("code correct");
             FXMLLoader loader = new FXMLLoader(getClass().getResource("newpassword.fxml"));
             fxml=loader.load(); 
             NewpasswordController newpasswordcontroller=loader.getController();
             newpasswordcontroller.setUtilisateur(U);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.show();
            
        
        }
        else
        {
            System.out.println("Code ghalet");
        }
        
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.show(); 
        
    }

    void setUtilisateur(Utilisateur u) {
        label_user_id.setText(Integer.toString(u.getID_UTILISATEUR()));
    }
    
}
