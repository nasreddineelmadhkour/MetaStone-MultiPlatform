/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Cartes;
import tn.edu.esprit.model.Collection;


import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.CartesService;
import tn.edu.esprit.service.CollectionService;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class MacollectionController implements Initializable {

    @FXML
    private Button button_annuler;
    @FXML
    private Button button_continue;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    Utilisateur u=new Utilisateur();
    @FXML
    private Label label_effect1;
    @FXML
    private Label label_effect2;
    @FXML
    private ListView<AnchorPane> list_collection;
    private AnchorPane anchorselected;
    @FXML
    private ImageView select_image1;
    @FXML
    private ImageView select_image2;
    @FXML
    private Label label_carte1;
    @FXML
    private Label label_carte2;
    @FXML
    private Label label_effect_fussioner;
    @FXML
    private ImageView select_image3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     
    }    

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
             fxml=loader.load(); 
             HomeController homecontroller=loader.getController();
             homecontroller.setUtilisateur(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        
    }

    void setUtilisateur(Utilisateur u) {
        this.u=u;

         ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
                CollectionService CS= new CollectionService();
                System.out.println(u.getID_UTILISATEUR());
                System.out.println(CS.afficherCollection(u.getID_UTILISATEUR()).size());  
          for (int i = 0; i < CS.afficherCollection(u.getID_UTILISATEUR()).size(); i++) 
          { 
              
             
              
              
                  Collection get = CS.afficherCollection(u.getID_UTILISATEUR()).get(i);
                  FXMLLoader load = new FXMLLoader(getClass().getResource("Unecarte.fxml"));
                    UnecarteController unecarteController= new UnecarteController();
                try {
                    Parent fxml =load.load();

                } catch (IOException ex) {
                        System.out.println("errour");
                }
            UnecarteController unecarteController2=  load.getController();
            unecarteController2.setId_collection(get.getID_COLLECTION());
              AnchorPane p = new AnchorPane(unecarteController2.getAnchor_carte());
              p.setStyle("-fx-background-color:black;");
                  
              p.setId(Integer.toString(get.getID_COLLECTION()));
              
              CartesService cs=new CartesService();
              String geturl ="/tn/edu/esprit/gui/src/"+cs.afficherCartesParId(get.getID_CARTE()).get(0).getimage();
              System.out.println(geturl);
              Label label=new Label(Integer.toString(get.getID_COLLECTION()));
           
              Image im1= new Image(geturl);
              ImageView i2 =new ImageView();
              i2.setImage(im1);
              i2.setLayoutX(15);
              i2.setLayoutY(10);

              p.getChildren().add(label);
              p.getChildren().add(i2);
              

              pubss.add(p);
    
        }
                
            
            list_collection.getItems().addAll(pubss);
        
        
    }

    @FXML
    private void select(MouseEvent event) {
    
       System.out.println(list_collection.getSelectionModel().getSelectedItem().getId());
       CollectionService cs= new CollectionService();
       CartesService CS =new CartesService();
       //CS.afficherCartesParId(0);
       
       Collection C=new Collection();
       C=cs.afficheCollection(Integer.parseInt(list_collection.getSelectionModel().getSelectedItem().getId()));
       if(label_carte1.getText()=="")
           label_carte1.setText("0");
       if(label_carte2.getText()=="")
           label_carte2.setText("0");
       if( Integer.parseInt(list_collection.getSelectionModel().getSelectedItem().getId())!=Integer.parseInt(label_carte1.getText()) && Integer.parseInt(list_collection.getSelectionModel().getSelectedItem().getId())!=Integer.parseInt(label_carte2.getText()) )
       {
       if(label_carte1.getText()=="0")
       {
       Image image= new Image("/tn/edu/esprit/gui/src/"+C.getImage());
       select_image1.setImage(image);
       label_carte1.setText(list_collection.getSelectionModel().getSelectedItem().getId());
       select_image1.setVisible(true);
       
       }
       else{
       Image image2= new Image("/tn/edu/esprit/gui/src/"+C.getImage());
       select_image2.setImage(image2);
       label_carte2.setText(list_collection.getSelectionModel().getSelectedItem().getId());
       label_effect_fussioner.setVisible(true);
       select_image2.setVisible(true);
       button_continue.setDisable(false);
       }
       label_effect1.setVisible(true);

       }
    }

    @FXML
    private void deselectionnercarte1(MouseEvent event) {
        select_image1.setVisible(false);label_carte1.setText("0");
        label_effect_fussioner.setVisible(false);button_continue.setDisable(true);
        if(label_carte2.getText()=="0")
        {label_effect1.setVisible(false);}

    }

    @FXML
    private void deselectionnercarte2(MouseEvent event) {
        select_image2.setVisible(false);label_carte2.setText("0");
        label_effect_fussioner.setVisible(false);button_continue.setDisable(true);
        if(label_carte1.getText()=="0")
        {label_effect1.setVisible(false);}


    }

    @FXML
    private void fusionner(ActionEvent event) {
    CollectionService cs= new CollectionService();
        System.out.println(u.getID_UTILISATEUR());
    int Num_carte=cs.fusionnerCollection(Integer.parseInt(label_carte1.getText()), Integer.parseInt(label_carte2.getText()), u.getID_UTILISATEUR());
    System.out.println(Num_carte);
    if(Num_carte>0)
    {
        label_effect2.setVisible(true);
        button_continue.setDisable(false);
        CartesService CS =new CartesService();
        Cartes C=new Cartes();
        C=CS.getCarte(Num_carte);
      
        Image image= new Image("/tn/edu/esprit/gui/src/"+C.getimage());
        select_image3.setImage(image);
        
    }
        
    }
    
}
