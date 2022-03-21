/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui.merche;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.interfaces.MyListenerCommande;
import tn.edu.esprit.model.Commande;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class CommandesItemController implements Initializable {

    @FXML
    private Label id_cmd;
    @FXML
    private Label id_user;
    @FXML
    private Label id_prod;
    @FXML
    private Label adresse;
    @FXML
    private Label prix;
    @FXML
    private Label qte;
    @FXML
    private Label dateC;
    @FXML
    private Label dateL;
    private Commande cmd;

    private MyListenerCommande myListener;
    /**
     * Initializes the controller class.
     */
    public void setData(Commande cmd,MyListenerCommande myListener) {
        this.cmd = cmd;
        this.myListener = myListener;
        id_cmd.setText(Integer.toString(cmd.getId_commande()));
        id_prod.setText(Integer.toString(cmd.getId_produit()));
        id_user.setText(Integer.toString(cmd.getId_utilisateur()));
        adresse.setText(cmd.getAdresse());
        prix.setText(Integer.toString(cmd.getPrix_total()));
        qte.setText(Integer.toString(cmd.getQuantite_acheter()));
        dateC.setText(cmd.getDate_commande());
        dateL.setText(cmd.getDate_livraison());
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(cmd);
    }
    
    
}
