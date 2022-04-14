/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.model.rating;
import tn.edu.esprit.service.Ratingservice;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnepostviewbackController implements Initializable {
Utilisateur u = new Utilisateur();
    @FXML
    private Label titreposte;
    @FXML
    private Label descriptionposte;
    
    
    
    
  private Poste poste;
     private MyListener myListener;
    @FXML
    private Rating rating;
   
    /**
     * initialises the controller class.
     */
   
  public void setData(Poste poste, MyListener myListener) {
        this.poste = poste;
        this.myListener = myListener;
        titreposte.setText(poste.getTitre());
        descriptionposte.setText(poste.getContenu());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
                 myListener.onClickListener(poste);

    }

    @FXML
    private void ratethis(MouseEvent event) {
        Ratingservice r = new Ratingservice();
        r.ajouterrating(new rating(0, rating.getRating(), poste.getId_poste()));
        Alert a = new Alert(Alert.AlertType.INFORMATION, "rating succed");
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }
    
    
}
