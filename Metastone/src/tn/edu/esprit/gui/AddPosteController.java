/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.edu.esprit.interfaces.IposteService;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.service.PosteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddPosteController implements Initializable {

    @FXML
    private TextArea contenu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("Categories.fxml");

        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      //  stage.initModality(Modality.APPLICATION_MODAL);
      //  stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("esm men fou9");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void publier(ActionEvent event) {
        IposteService poste1 =new PosteService();
        Poste p=new Poste();
        p.setContenu(contenu.getText());
        poste1.ajouterPoste(p);
        
        
    }

    @FXML
    private void contenu(MouseEvent event) {
    }
    
}
