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
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.Utilisateur;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnetournoiviewController implements Initializable {
Utilisateur u = new Utilisateur();
    /**
     * Initializes the controller class.
     */
     private   Tournoi tournoi;
     private tournoilistener myListener;
     
     
    @FXML
    private Label date;
    @FXML
    private Label description;
    
    
    public void setData(Tournoi tournoi, tournoilistener myListener) {
        this.tournoi = tournoi;
        this.myListener = myListener;
        date.setText(tournoi.getDate().toString());
        description.setText(tournoi.getDescription());
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
    
    
    @FXML
    private void onclickme(MouseEvent event) {
        
          myListener.onClickListener(tournoi);
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }
    
    
    
}
