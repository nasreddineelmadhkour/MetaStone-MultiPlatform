/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tn.edu.esprit.gui.HomeController;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class NewsofghadaController implements Initializable {

    @FXML
    private WebView webview;
    private Utilisateur u=new Utilisateur();
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final WebEngine web = webview.getEngine();
        String urlweb = "https://www.lanewsevenements.fr"; 
        web.load(urlweb);
    }    

    void setUtilisateurr(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void to_home(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/Home.fxml"));
             fxml=loader.load(); 
             HomeController forumviewController=loader.getController();
             
             forumviewController.setUtilisateurr(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }
    
}
