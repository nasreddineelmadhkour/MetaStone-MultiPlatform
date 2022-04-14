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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.TournoiService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnetournoiviewfrontController implements Initializable {

    @FXML
    private Label date;
  
    private   Tournoi tournoi;
     private tournoilistener myListener;
    @FXML
    private Label description;
    @FXML
    private Label nbjouer;
    @FXML
    private Label recompence;
     
    /**
     * initialises the controller class.
     */
     Utilisateur u = new Utilisateur();
     
      public void setData(Tournoi tournoi, tournoilistener myListener) {
        this.tournoi = tournoi;
       
      this.myListener = myListener;
        date.setText(tournoi.getDate().toString());
      description.setText(tournoi.getDescription());
      nbjouer.setText(String.valueOf(tournoi.getNbr_joueur()));
        recompence.setText(tournoi.getRecompence());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void participer(ActionEvent event) throws IOException {
        TournoiService s = new TournoiService();
        tournoi.setNbr_joueur(tournoi.getNbr_joueur()-1);
        s.modifiertournoi(tournoi.getId_tournoi(), tournoi);
         FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/tournoifrontend.fxml"));
                           Parent root =load.load();
                           TournoifrontendController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void onclick(MouseEvent event) {
                  myListener.onClickListener(tournoi);

    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }
    
}
