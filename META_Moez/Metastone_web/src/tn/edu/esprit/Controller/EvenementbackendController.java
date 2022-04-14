/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.Tournoi;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.EvenementService;
import tn.edu.esprit.service.TournoiService;
import tn.edu.esprit.model.TrayIconDemo;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class EvenementbackendController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    
    
    Evenement currentevent;
    private List<Evenement> evenements = new ArrayList<>();
      private evenementlistner myListener;
    private Image image;
  
    @FXML
    private TextField date;
    @FXML
    private TextField duree;
    @FXML
    private TextField lieu;
    @FXML
    private TextField sponsore;
    
    Utilisateur u = new Utilisateur();
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
    date.setText(evenement.getDate1());
        duree.setText(String.valueOf(evenement.getDuree()));
        lieu.setText(evenement.getLieu());
 sponsore.setText(evenement.getSponsore());
 
    }
     
    
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

                if (column == 3) {
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
    private void ajouterevent(ActionEvent event) throws IOException {
    EvenementService s = new EvenementService();
    int i = Integer.parseInt(duree.getText());
    s.ajouterEvenemenet(new Evenement(date.getText(),lieu.getText(),i , sponsore.getText()));
        Alert a = new Alert(Alert.AlertType.INFORMATION, "new event has been added");
        a.show();
        TrayIconDemo td= new TrayIconDemo();
        try {
            td.displayTray();
        } catch (AWTException ex) {
            Logger.getLogger(EvenementbackendController.class.getName()).log(Level.SEVERE, null, ex);
        }
            FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/evenementbackend.fxml"));
                           Parent root =load.load();
                           EvenementbackendController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
    }

    @FXML
    private void modifierevent(ActionEvent event) throws IOException {
     EvenementService s = new EvenementService();
    int i = Integer.parseInt(duree.getText());
    s.modifierEvenement(currentevent.getId_evenement(), new Evenement(date.getText(),lieu.getText(), i, sponsore.getText()));
            Alert a = new Alert(Alert.AlertType.INFORMATION, "new event has been modified");
                    a.show();

                FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/evenementbackend.fxml"));
                           Parent root =load.load();
                           EvenementbackendController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
            
            
    }

    @FXML
    private void supprimerevent(ActionEvent event) throws IOException {
    EvenementService s = new EvenementService();
    s.supprimerEvenement(currentevent.getId_evenement());
        Alert a = new Alert(Alert.AlertType.INFORMATION, "new event has been deleted");
                    a.show();

        FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/evenementbackend.fxml"));
                           Parent root =load.load();
                           EvenementbackendController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    
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

    @FXML
    private void gotoevent(ActionEvent event) {
    }

 

}
