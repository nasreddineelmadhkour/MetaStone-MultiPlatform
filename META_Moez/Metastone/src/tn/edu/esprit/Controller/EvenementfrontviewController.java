/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import tn.edu.esprit.gui.HomeController;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class EvenementfrontviewController implements Initializable {

     Evenement currentevent;
     private Parent fxml;
    private List<Evenement> evenements = new ArrayList<>();
      private evenementlistner myListener;
    
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
Utilisateur u = new Utilisateur();
    private Scene scene;
    private Stage stage;
    /**
     * Initializes the controller class.
     */
       private List<Evenement> getData() throws SQLException {
      
            List<Evenement> evenements = new ArrayList<>();
            EvenementService s = new EvenementService();
        Evenement evenement1;

        for (int i = 0; i < s.afficherEvenement().size(); i++) {
            Evenement get = s.afficherEvenement().get(i);
            
            
            evenement1 = new Evenement();
            evenement1.setDate1(get.getDate1());
            evenement1.setDuree(get.getDuree());
            evenement1.setId_evenement(get.getId_evenement());
            evenement1.setLieu(get.getLieu());
            evenement1.setSponsore(get.getSponsore());
   
            evenements.add(evenement1);
        }
           return evenements;
    }
     
     
     
      private void setChosentevent(Evenement evenement) throws SQLException {
      currentevent=evenement;

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    
      
    public void afficher() throws SQLException, IOException
    {
               evenements.addAll(getData());
        if (evenements.size() > 0) {
            setChosentevent(evenements.get(0));
            myListener = new evenementlistner() {
                @Override
                public void onClickListener(Evenement events) {
                    try {
                        setChosentevent(events);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
               
                
              
            };
          int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < evenements.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/oneeventbackend.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneeventbackendController  oneeventbackendController= fxmlLoader.getController();
                oneeventbackendController.setData(evenements.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
           
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }

    @FXML
    private void to_home(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/Home.fxml"));
             fxml=loader.load(); 
             HomeController forumviewController=loader.getController();
             
             forumviewController.setUtilisateurr(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void to_news(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/newsofghada.fxml"));
             fxml=loader.load(); 
             NewsofghadaController forumviewController=loader.getController();
             
             forumviewController.setUtilisateurr(u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }
    
    
}
