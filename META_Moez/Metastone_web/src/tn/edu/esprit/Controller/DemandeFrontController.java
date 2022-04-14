/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.gui.HomeController;
import tn.edu.esprit.model.Demande;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceDemande;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class DemandeFrontController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private Label label_coach;
    @FXML
    private Label label_freelancer;
    @FXML
    private Label label_developper;
    @FXML
    private Label label_designer;
    @FXML
    private Button button_coach;
    @FXML
    private Button button_freelancer;
    @FXML
    private Button button_developper;
    @FXML
    private Button button_designer;
    private Utilisateur u=new Utilisateur();
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
    private void retourner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/Home.fxml"));
             fxml=loader.load(); 
             HomeController homeController=loader.getController();
             homeController.setUtilisateurr(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        
    }

    @FXML
    private void envoyer_demande(ActionEvent event) throws SQLException, IOException {
        
        if(label_coach.isVisible() || label_designer.isVisible() || label_developper.isVisible() || label_freelancer.isVisible() && !description.getText().equals(""))
        {
        String type="";
        
        if(label_coach.isVisible())
        {   type="coach";
            System.out.println("coach");
        }
        if(label_designer.isVisible())
        {   type="designer";
            System.out.println("Designer");
        }
        if(label_developper.isVisible())
        {   type="developer";
            System.out.println("Developer");
        }
        if(label_freelancer.isVisible())
        {   type="freelancer";
            System.out.println("Freelancer");
        }
            System.out.println(u.getID_UTILISATEUR());
            ServiceDemande Ds= new ServiceDemande();
            Demande D=new Demande(u.getID_UTILISATEUR(),type,description.getText());
            Ds.ajouter(D);
            
             label_coach.setVisible(false);description.clear();
             label_designer.setVisible(false);
             label_developper.setVisible(false);
             label_freelancer.setVisible(false);
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/Home.fxml"));
             fxml=loader.load(); 
             HomeController homeController=loader.getController();
             homeController.setUtilisateurr(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        }
    
    
    }

    @FXML
    private void select_coach(ActionEvent event) {
        label_coach.setVisible(true);
        label_designer.setVisible(false);
        label_developper.setVisible(false);
        label_freelancer.setVisible(false);
        
        
        
    }

    @FXML
    private void select_freelancer(ActionEvent event) {
        label_coach.setVisible(false);
        label_designer.setVisible(false);
        label_developper.setVisible(false);
        label_freelancer.setVisible(true);
    }

    @FXML
    private void select_developper(ActionEvent event) {
        label_coach.setVisible(false);
        label_designer.setVisible(false);
        label_developper.setVisible(true);
        label_freelancer.setVisible(false);
    }

    @FXML
    private void select_designer(ActionEvent event) {
        label_coach.setVisible(false);
        label_designer.setVisible(true);
        label_developper.setVisible(false);
        label_freelancer.setVisible(false);
    }

    public void setUtilisateur(Utilisateur u) {
        this.u=u;
    }
    
}
