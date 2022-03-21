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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Demande;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.ServiceDemande;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class DemandeBackController implements Initializable {

    private Parent fxml;
    private Scene scene;
    private Stage stage;
    @FXML
    private ListView<AnchorPane> list_collection;
    @FXML
    private Button button_supprimer;
    @FXML
    private Label button_ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(DemandeBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ondeletecomment(ActionEvent event) throws SQLException {
        ServiceDemande Sd=new ServiceDemande();
        Sd.supprimer(Integer.parseInt(((AnchorPane)this.list_collection.getSelectionModel().getSelectedItem()).getId()));
        afficher();
        button_ajouter.setDisable(true);
        button_supprimer.setDisable(true);
    }

    private void afficher() throws SQLException {
        this.list_collection.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
        
        ServiceDemande Iu = new ServiceDemande();
        System.out.println(Iu.afficher());

        for(int i = 0; i < Iu.afficher().size(); ++i) {
            Demande get = (Demande)Iu.afficher().get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/edu/esprit/gui/Unedemande.fxml"));

            try {
                Parent var7 = (Parent)load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            UnedemandeController unedemandeController2 = (UnedemandeController)load.getController();
            AnchorPane p = new AnchorPane(new Node[]{unedemandeController2.getAnchor_demande()});
            
            unedemandeController2.setId_demande(get.getId_demande());
            unedemandeController2.setType(get.getType());
            unedemandeController2.setDescription(get.getDescription());
            unedemandeController2.setId_utilisateur(get.getID_UTILISATEUR());
           
            
            p.setId(Integer.toString(get.getId_demande()));

                        p.setStyle("-fx-backgound-color:blue;");
            
            pubss.add(p);
        }

        this.list_collection.getItems().addAll(pubss);
    }
    
    
    @FXML
    private void to_esports(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void to_carte(ActionEvent event) {
    }

    @FXML
    private void to_merch(ActionEvent event) {
    }

    @FXML
    private void to_choaching(ActionEvent event) {
    }

    @FXML
    private void to_demande(ActionEvent event) {
    }

    @FXML
    private void to_paiement(ActionEvent event) {
    }

    @FXML
    private void to_compte(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboard.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void to_forum(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboardforumbackend.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();

             stage.show();
    }

    @FXML
    private void select(MouseEvent event) {
        
        button_ajouter.setDisable(false);
        button_supprimer.setDisable(false);
        
        
        
    }

    @FXML
    private void changer_role(MouseEvent event) throws SQLException {
        ServiceDemande SD=new ServiceDemande();
        Demande D=new Demande();
        D=SD.getDemande(Integer.parseInt(((AnchorPane)this.list_collection.getSelectionModel().getSelectedItem()).getId()));
        ServiceUtilisateur SU= new ServiceUtilisateur();
        
        SU.changerRole(D.getID_UTILISATEUR(),D.getType());
        button_ajouter.setDisable(true);
        button_supprimer.setDisable(true);
    }
    
    
    
}
