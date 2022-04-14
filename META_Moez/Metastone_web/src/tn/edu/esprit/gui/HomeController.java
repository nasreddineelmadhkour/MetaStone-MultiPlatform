/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import gui.merche.user.AfficheMercheUserFormController;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.Controller.BackviewoftournoiController;
import tn.edu.esprit.Controller.DemandeFrontController;
import tn.edu.esprit.Controller.EvenementfrontviewController;
import tn.edu.esprit.Controller.TournoifrontendController;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class HomeController implements Initializable {

    private Label label_Prenom;
    Utilisateur u = new Utilisateur();
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button button_deconnexion;
    @FXML
    private Label label_MTC;
    @FXML
    private Button goesport;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    void setUtilisateur(Utilisateur U) {
        this.u=U;
        System.out.println("Hello "+U.getPrenom());
                label_MTC.setText(u.getMtc());

        //label_Prenom.setText(U.getPrenom());
        
    }

    @FXML
    private void mycollection(ActionEvent event) throws IOException {
    
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Macollection.fxml"));
             fxml=loader.load(); 
             MacollectionController macollectioncontroller=loader.getController();
             macollectioncontroller.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             
             stage.show();
    }

    @FXML
    private void profil(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
             fxml=loader.load(); 
             ProfilController profilcontroller=loader.getController();
             profilcontroller.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);stage.centerOnScreen();
             stage.setScene(scene);
             stage.show();
    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             scene.setFill(Color.TRANSPARENT);
             stage.show();
        
    }
    @FXML
    private void myforum(ActionEvent event) throws IOException {
   
             FXMLLoader loader = new FXMLLoader(getClass().getResource("forumview.fxml"));
             fxml=loader.load(); 
             ForumviewController forumviewController=loader.getController();
             
             forumviewController.setUtilisateur(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    
    }

    @FXML
    private void gotoesport(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/tournoifrontend.fxml"));
             fxml=loader.load(); 
             TournoifrontendController profilcontroller=loader.getController();
             profilcontroller.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);stage.centerOnScreen();
             stage.setScene(scene);
             stage.show(); 
    }

    public void setUtilisateurr(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void to_demande(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/DemandeFront.fxml"));
             fxml=loader.load(); 
             DemandeFrontController demandeFrontController=loader.getController();
             
             demandeFrontController.setUtilisateur(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void to_store(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../gui/merche/user/AfficheMercheUserForm.fxml"));
             fxml=loader.load(); 
             AfficheMercheUserFormController demandeFrontController=loader.getController();
             
             demandeFrontController.setUtilisateur(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }
}
