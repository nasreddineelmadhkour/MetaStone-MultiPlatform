/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class TESTController implements Initializable {

    FileChooser fileChooser= new FileChooser();
    @FXML
    private ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Choser_image(ActionEvent event) throws FileNotFoundException {

        FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("image", "*.png");  
        fileChooser.getExtensionFilters().add(fileExtensions);
        File file= fileChooser.showOpenDialog(new Stage());
         System.out.println(file.toURI().toString());
         Image image=new Image(file.toURI().toString());
         this.image.setImage(image);
    }
    
}
