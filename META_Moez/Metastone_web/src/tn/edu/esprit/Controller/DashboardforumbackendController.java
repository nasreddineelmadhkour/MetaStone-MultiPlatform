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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.CommentaireService;
import tn.edu.esprit.service.PosteService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class DashboardforumbackendController implements Initializable {
    Commentaire cuurentcomment;
     Poste currentposte;
     private Parent fxml;
    private List<Poste> Postes = new ArrayList<>();
    private List<Commentaire> commentaires = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    
    
    @FXML
    private AnchorPane anchorme;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll2;
    private Scene scene;
    private Stage stage;
    @FXML
    private GridPane grid2;
Utilisateur u = new Utilisateur();
    

    /**
     * initialises the controller class.
     */
     private List<Poste> getData() throws SQLException {
      
            List<Poste> postes = new ArrayList<>();
         PosteService s = new PosteService();
        Poste poste1;

        for (int i = 0; i < s.afficherPoste().size(); i++) {
            Poste get = s.afficherPoste().get(i);
            
            
            poste1 = new Poste();
            poste1.setId_poste(get.getId_poste());
            poste1.setTitre(get.getTitre());
            poste1.setDate_poste(get.getDate_poste());
            poste1.setContenu(get.getContenu());
            poste1.setCategorie(get.getCategorie());
            poste1.setId_utilisateur(get.getId_utilisateur());
   
            postes.add(poste1);
        }
           return postes;
    }
    
     
     
       private List<Commentaire> getDatacomment() throws SQLException {
      
            List<Commentaire> commentaires = new ArrayList<>();
           CommentaireService s = new CommentaireService();
        Commentaire comment1;

        for (int i = 0; i < s.afficherCommentaire1(currentposte.getId_poste()).size(); i++) {
            Commentaire get = s.afficherCommentaire1(currentposte.getId_poste()).get(i);
            
            
            comment1 = new Commentaire();
            comment1.setId_cmnt(get.getId_cmnt());
            comment1.setId_poste(get.getId_poste());
            comment1.setId_utilisateur(get.getId_utilisateur());
            comment1.setCommentaire(get.getCommentaire());

            commentaires.add(comment1);
        }

        return commentaires;
    }
    
       
       private void setChosencomment(Commentaire comment) {
      cuurentcomment=comment;
 
    }
       
     
     
     
      private void setChosenposte(Poste poste) throws SQLException {
      currentposte=poste;
     
      grid2.getChildren().clear();
      commentaires.clear();
      affichercomment();
      
      
    }
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            // TODO
            afficher();
        } catch (SQLException ex) {
        }
  
    }    
    
    
    
        public void afficher() throws SQLException
    {
               Postes.addAll(getData());
        if (Postes.size() > 0) {
            setChosenposte(Postes.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Poste poste) {
                    try {
                       
                        setChosenposte(poste);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                @Override
                public void onClickListener(Commentaire comment) {
                   
                }
           

               
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Postes.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/onepostviewback.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnepostviewbackController  onepostviewbackController= fxmlLoader.getController();
                onepostviewbackController.setData(Postes.get(i),myListener);

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

        
        
        
        
        
        
         public void affichercomment() throws SQLException
    {
               commentaires.addAll(getDatacomment());
        if (commentaires.size() > 0) {
            setChosencomment(commentaires.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Poste poste) {
                   
                }
           
                    

                @Override
                public void onClickListener(Commentaire comment) {
                    setChosencomment(comment);
                }
               
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < commentaires.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/tn/edu/esprit/gui/onecommentviewback.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnecommentviewbackController  onecommentviewbackController= fxmlLoader.getController();
                onecommentviewbackController.setData(commentaires.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid2.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid2.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid2.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid2.setMaxWidth(Region.USE_COMPUTED_SIZE);

                //set grid height
                grid2.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid2.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid2.setMaxHeight(Region.USE_COMPUTED_SIZE);

                grid2.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    @FXML
    private void ondeletepost(ActionEvent event) throws IOException {
        PosteService s = new PosteService();
        s.supprimerPoste(currentposte.getId_poste());
         Alert a = new Alert(Alert.AlertType.INFORMATION, "cette poste "+currentposte.getTitre()+"est supprimer");
        a.show();
          FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboardforumbackend.fxml"));
                           Parent root =load.load();
                           DashboardforumbackendController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void ondeletecomment(ActionEvent event) throws IOException {
        CommentaireService s = new CommentaireService();
        s.supprimerCommentaire(cuurentcomment.getId_cmnt());
        Alert a = new Alert(Alert.AlertType.INFORMATION, "cette commentaire"+cuurentcomment.getCommentaire()+"est supprimer");
        a.show();
          FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboardforumbackend.fxml"));
                           Parent root =load.load();
                           DashboardforumbackendController c2=  load.getController();
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
    private void to_forum(ActionEvent event) {
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
