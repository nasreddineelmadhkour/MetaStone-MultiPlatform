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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.ServiceUtilisateur;
import tn.edu.esprit.util.Mail;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class MdpoublierController implements Initializable {

    @FXML
    private TextField lineEdit_emailOrutilisateur;
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
    private void continuer(ActionEvent event) throws SQLException, Exception {
        
        if(lineEdit_emailOrutilisateur.getText()!="")
        {
        ServiceUtilisateur USER=new ServiceUtilisateur();        
        Utilisateur U=new Utilisateur(),u=new Utilisateur();
        U=USER.getUtilisateur(lineEdit_emailOrutilisateur.getText().toString());
            System.out.println(U);
        if(U.getEmail()!="")
        {
           int code=0;
           System.out.println(U.getEmail());
           code=USER.generer(U.getID_UTILISATEUR());
           System.out.println(code);

           //Mail.sendMail(U.getEmail(), code);
           
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Code.fxml"));
             fxml=loader.load(); 
             CodeController codecontroller=loader.getController();
             u=USER.getUtilisateur(U.getID_UTILISATEUR());
             codecontroller.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.show();
           
       }
       else 
       {
           System.out.println("\n ----- Username n'existe pas ------\n");
       }
        
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
    
}
