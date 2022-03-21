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
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Commentaire;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OnecommentsviewController implements Initializable {

    @FXML
    private Label commentaireofone;
   private MylLstener myListener;
    private  Commentaire comment;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      public void setData(Commentaire comment, MylLstener myListener) {
        this.comment = comment;
        this.myListener = myListener;
        commentaireofone.setText(comment.getCommentaire());
        System.out.println("aaaa");
       
    }

    @FXML
    private void onclick(MouseEvent event) {
      myListener.onClickListener(comment);
    
    }
    
}
