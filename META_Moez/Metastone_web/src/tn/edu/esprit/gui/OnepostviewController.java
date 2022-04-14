/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Poste;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnepostviewController implements Initializable {

    @FXML
    private Label titre_poste;
    @FXML
    private Label nombre_post;
    private MylLstener myListener;
    private  Poste post;
    @FXML
    private ImageView userpic;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("aaaa");
    }    
    
     public void setData(Poste poste, MylLstener myListener) {
        this.post = poste;
        this.myListener = myListener;
        titre_poste.setText(poste.getTitre());
        System.out.println("aaaa");
       
    }

    @FXML
    private void onmeclick(MouseEvent event) {
         myListener.onClickListener(post);
    }
       private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(post);
    }

}
