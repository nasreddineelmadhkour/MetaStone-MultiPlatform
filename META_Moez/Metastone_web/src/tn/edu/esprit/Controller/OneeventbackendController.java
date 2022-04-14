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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OneeventbackendController implements Initializable {

    @FXML
    private Label lieu;
    @FXML
    private Label date;
    private Evenement events;
         private evenementlistner myListener;
         Utilisateur u = new Utilisateur();
    /**
     * initialises the controller class.
     */
    
      public void setData(Evenement event, evenementlistner myListener) {
        this.events = event;
        this.myListener = myListener;
       lieu.setText(event.getLieu());
       date.setText(event.getDate1());
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
        
         myListener.onClickListener(events);
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }
    
}
