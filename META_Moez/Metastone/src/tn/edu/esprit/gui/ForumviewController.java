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
 * @author THEOLDISBACK
 */
public class ForumviewController implements Initializable {
        Utilisateur u = new Utilisateur();
        private Parent fxml;
        private Scene scene;
        private Stage stage;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
      

    @FXML
    private void categoriecommunautaire(ActionEvent event) throws IOException {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
            
              categoriecommunautreviewController.setCategories("1");
                categoriecommunautreviewController.afficher("1");
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    
    }

    @FXML
    private void categorietechnique(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
            
              categoriecommunautreviewController.setCategories("2");
                categoriecommunautreviewController.afficher("2");
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void categorieplateforme(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
            
              categoriecommunautreviewController.setCategories("3");
                categoriecommunautreviewController.afficher("3");
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }
    
      void setUtilisateur(Utilisateur u) {
        this.u=u;
          System.out.println(this.u);
    }
}
