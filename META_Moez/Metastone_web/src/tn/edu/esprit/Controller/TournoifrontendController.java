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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.gui.ForumviewController;
import tn.edu.esprit.gui.HomeController;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.TournoiService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class TournoifrontendController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
 

      Tournoi cuurenttournoi;
    private List<Tournoi> tournois = new ArrayList<>();
      private tournoilistener myListener;
    
    Utilisateur u = new Utilisateur();
    
    private List<Tournoi> getData() throws SQLException {
      
            List<Tournoi> tournois = new ArrayList<>();
            TournoiService s = new TournoiService();
        Tournoi tournoi1;

        for (int i = 0; i < s.affichertournoi().size(); i++) {
            Tournoi get = s.affichertournoi().get(i);
            
            
            tournoi1 = new Tournoi();
           tournoi1.setCreateur(get.getCreateur());
         tournoi1.setDate(get.getDate());
         tournoi1.setDescription(get.getDescription());
         tournoi1.setNbr_joueur(get.getNbr_joueur());
         tournoi1.setRecompence(get.getRecompence());
         tournoi1.setId_tournoi(get.getId_tournoi());
   
            tournois.add(tournoi1);
        }
           return tournois;
    }
    
    
    
    
     
      private void setChosentournoi(Tournoi tournoi) throws SQLException {
      cuurenttournoi=tournoi;
    
    }
    
    /**
     * initialises the controller class.
     */
      
      
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          try {
            // TODO
            afficher();
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
    }    
    
    
            public void afficher() throws SQLException
    {
               tournois.addAll(getData());
        if (tournois.size() > 0) {
            setChosentournoi(tournois.get(0));
            myListener = new tournoilistener() {
                @Override
                public void onClickListener(Tournoi tournoi) {
                    try {
                        setChosentournoi(tournoi);
                    } catch (SQLException ex) {
                    }
                
                }
            };
          int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < tournois.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/onetournoiviewfront.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnetournoiviewfrontController  onetournoiviewfrontController= fxmlLoader.getController();
                onetournoiviewfrontController.setData(tournois.get(i),myListener);

                if (column == 10) {
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
    private void retourner(ActionEvent event) throws IOException {
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

    public void setUtilisateur(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void to_event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/evenementfrontview.fxml"));
             fxml=loader.load(); 
             EvenementfrontviewController profilcontroller=loader.getController();
             profilcontroller.setU(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);stage.centerOnScreen();
             stage.setScene(scene);
             stage.show(); 
    }

         
}
