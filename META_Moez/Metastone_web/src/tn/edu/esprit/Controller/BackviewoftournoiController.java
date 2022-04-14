/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.TournoiService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class BackviewoftournoiController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private TextField createur;
    @FXML
    private TextField description;
    @FXML
    private TextField jouer;
    @FXML
    private TextField recompence;
    @FXML
    private DatePicker date;

         Tournoi cuurenttournoi;
         private Parent fxml;
    private Scene scene;
    private Stage stage;
    private List<Tournoi> tournois = new ArrayList<>();
    
    private Image image;
    private tournoilistener myListener;
    @FXML
    private TextField rechercher;
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
    
    private List<Tournoi> getDatasearched() throws SQLException {
      
            List<Tournoi> tournois = new ArrayList<>();
            TournoiService s = new TournoiService();
        Tournoi tournoi1;

        for (int i = 0; i < s.affichertournoirecher(rechercher.getText()).size(); i++) {
            Tournoi get = s.affichertournoirecher(rechercher.getText()).get(i);
            
            
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
     createur.setText(tournoi.getCreateur());
     description.setText(tournoi.getDescription());
     date.setValue(tournoi.getDate().toLocalDate());
     jouer.setText(String.valueOf(tournoi.getNbr_joueur()));
     recompence.setText(tournoi.getRecompence());
        
 
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
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/onetournoiview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnetournoiviewController  onetournoiviewController= fxmlLoader.getController();
                onetournoiviewController.setData(tournois.get(i),myListener);

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

         
         
         
         
         
         
         
         
         
         
              public void affichersearch() throws SQLException
    {
               tournois.addAll(getDatasearched());
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
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/onetournoiview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnetournoiviewController  onetournoiviewController= fxmlLoader.getController();
                onetournoiviewController.setData(tournois.get(i),myListener);

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

    @FXML
    private void ajoutertournoi(ActionEvent event) throws IOException {
        TournoiService s = new TournoiService();
        int i = Integer.parseInt(jouer.getText());
        Date d = new Date(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth());
        s.ajoutertournoi(new Tournoi(d, description.getText(), createur.getText(), i, recompence.getText()));
        Alert a = new Alert(Alert.AlertType.INFORMATION,"new tournoi has been added");
        a.show();
        FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
                           Parent root =load.load();
                           BackviewoftournoiController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
         }

    @FXML
    private void modifiertournoi(ActionEvent event) throws IOException {
    TournoiService s = new TournoiService();
   int i = Integer.parseInt(jouer.getText());

            Date d = new Date(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth());
            System.out.println(cuurenttournoi.getId_tournoi());
    s.modifiertournoi(cuurenttournoi.getId_tournoi(), new Tournoi(d, description.getText(), createur.getText(), i, recompence.getText()));
    
     Alert a = new Alert(Alert.AlertType.INFORMATION,"new tournoi has been modified");
        a.show();
        FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
                           Parent root =load.load();
                           BackviewoftournoiController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void supprimertournoi(ActionEvent event) throws IOException {
    
         TournoiService s = new TournoiService();
         s.supprimertournoi(cuurenttournoi.getId_tournoi());
        
       Alert a = new Alert(Alert.AlertType.INFORMATION,"new tournoi has been deleted");
        a.show();
        FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
                           Parent root =load.load();
                           BackviewoftournoiController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void chercher(KeyEvent event) throws SQLException {
   
    
        if (rechercher.getText().equals(""))
        {
            grid.getChildren().clear();
            tournois.clear();
            afficher();
            
        }
        else
        {
            grid.getChildren().clear();
            tournois.clear();
            affichersearch();
        }
        
    
    }

    @FXML
    private void gotoevent(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/evenementbackend.fxml"));
         fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();

             stage.show();
        
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }

    @FXML
    private void to_esports(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void to_carte(ActionEvent event) {
    }

    @FXML
    private void to_merch(ActionEvent event) {
    }

    @FXML
    private void to_choaching(ActionEvent event) {
    }

    @FXML
    private void to_forum(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboardforumbackend.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();

             stage.show();
    }

    @FXML
    private void to_demande(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/DemandeBack.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();

             stage.show();
    }

    @FXML
    private void to_paiement(ActionEvent event) {
    }

    @FXML
    private void to_compte(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboard.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             
             stage.centerOnScreen();

             stage.show();
    }
    
    
    
}     
           

    
    
      

    
    
    
    
    
