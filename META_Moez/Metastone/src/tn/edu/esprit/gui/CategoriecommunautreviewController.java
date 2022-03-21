/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.PosteService;
/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class CategoriecommunautreviewController implements Initializable {
 Utilisateur u = new Utilisateur();
 String cat= new String();
   private Parent fxml;
        private Scene scene;
        private Stage stage;
        private String categories;
    private GridPane grid;
     private List<Poste> posts = new ArrayList<>();
    private MylLstener myListener;
    Poste currentpost;
    @FXML
    private ListView<AnchorPane> lsitview;
    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private Button ajouterposte;
    @FXML
    private Button modifierpost;
    @FXML
         private Button annulerpost;
        
    @FXML
    private Button ajouterposte12;
    /**
     * initialises the controller class.
     */
    
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
             afficher(categories);

     
        
    }    
 
  
    
       
    private void setChosenPost(Poste post) {
    
      currentpost = new Poste(post.getId_poste(),post.getId_utilisateur(), post.getTitre(), post.getDate_poste(), post.getContenu(), post.getCategorie());
      titre.setText(currentpost.getTitre());
      description.setText(currentpost.getContenu());
        System.out.println(u.getID_UTILISATEUR());
        System.out.println(currentpost.getId_utilisateur());
      if (u.getID_UTILISATEUR()==currentpost.getId_utilisateur())
      {
          titre.setDisable(false);
          description.setDisable(false);
           modifierpost.setVisible(TRUE);
          annulerpost.setVisible(TRUE);
        
        
      }
      else
      {
           modifierpost.setVisible(FALSE);
          annulerpost.setVisible(FALSE);
          titre.setDisable(true);
          description.setDisable(true);
      }
       ajouterposte.setVisible(false);
    }
    public void afficher(String categorie)
    {
       this.categories=categorie;
               this.lsitview.getItems().clear();
                 modifierpost.setVisible(FALSE);
                 annulerpost.setVisible(FALSE);
                 ajouterposte.setVisible(false);
        
        
  
          posts.addAll(getData());
          if (posts.size() > 0) {
            setChosenPost(posts.get(0));
            myListener = new MylLstener() {
                @Override
                public void onClickListener(Poste post) {
                    System.out.println(post.getId_poste());
                    setChosenPost(post);
                

                }

                @Override
                public void onClickListener(Commentaire comment) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }   
          
          
          
          
      
        try {
            System.out.println( posts.size());
            for (int i = 0; i < posts.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("onepostview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OnepostviewController onepostviewController = fxmlLoader.getController();
                onepostviewController.setData(posts.get(i),myListener);

 
                lsitview.getItems().add(anchorPane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
          
          
    }
    
    
       void setUtilisateur(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void ajouterposte1(ActionEvent event) throws IOException {
        PosteService p = new PosteService();
        Date d = new Date(1999, 30, 10);
        p.ajouterPoste(new Poste(0, u.getID_UTILISATEUR(),titre.getText(), d, description.getText(), categories));
        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre poste est ajouter");
            a.show();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
                 categoriecommunautreviewController.setCategories(categories);
                categoriecommunautreviewController.afficher(categories);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void modifierpost1(ActionEvent event) throws IOException {
        PosteService p = new PosteService();
        
        p.modifierPoste(currentpost.getId_poste(), new Poste(titre.getText(), currentpost.getDate_poste(), description.getText(),categories, currentpost.getId_utilisateur()));
        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre poste est modifier");
        a.show();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
                 categoriecommunautreviewController.setCategories(categories);
                categoriecommunautreviewController.afficher(categories);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        
    }

    @FXML
    private void annulerpost1(ActionEvent event) throws IOException {
            PosteService p = new PosteService();
            p.supprimerPoste(currentpost.getId_poste());
            Alert a = new Alert(Alert.AlertType.INFORMATION, "votre poste est supprime");
            a.show();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriecommunautreview.fxml"));
             fxml=loader.load(); 
             CategoriecommunautreviewController categoriecommunautreviewController=loader.getController();
              categoriecommunautreviewController.setUtilisateur(u);
                 categoriecommunautreviewController.setCategories(categories);
                categoriecommunautreviewController.afficher(categories);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
            
         
    }

    @FXML
    private void viewcomments(ActionEvent event) throws IOException {
   
           FXMLLoader loader = new FXMLLoader(getClass().getResource("commentsofpost.fxml"));
             fxml=loader.load(); 
             CommentsofpostController commentsofpostController=loader.getController();
             commentsofpostController.emptylistview();
              commentsofpostController.setUtilisateur(u);
                 commentsofpostController.setCategories(categories);
                 commentsofpostController.setPoste(currentpost);
               
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
            
    
    }

    @FXML
    private void ajouterposte12(ActionEvent event) {
        System.out.println(this.categories);
     ajouterposte.setVisible(true);
              titre.setDisable(false);
          description.setDisable(false);
     titre.setText("");
     description.setText("");
    
    }

    public void setCategories(String categories) {
        this.categories = categories;
        System.out.println(this.categories);
    }

    public String getCategories() {
        
        return categories;
    }
        private List<Poste> getData() {
            
                   
             
        List<Poste> posts = new ArrayList<>();
        PosteService s = new PosteService();
        
        Poste post1;
        System.out.println("aaa"+getCategories());
        for (int i = 0; i < s.afficherPostecategorie1(this.categories).size(); i++) {
            Poste get = s.afficherPostecategorie1(this.categories).get(i);
                System.out.println("aaa");
            
            post1 = new Poste();
            post1.setId_poste(get.getId_poste());
        post1.setTitre(get.getTitre());
        post1.setDate_poste(get.getDate_poste());
        post1.setContenu(get.getContenu());
        post1.setCategorie(get.getCategorie());
         post1.setId_utilisateur(get.getId_utilisateur());
        posts.add(post1);
            
        }
    

        return posts;
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        
        FXMLLoader load = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/Home.fxml"));
        Parent root =load.load();
        HomeController c2=  load.getController();
        c2.setUtilisateur(u);
        Scene ss= new Scene(root);
        Stage se= new Stage();
        se=(Stage)((Node)event.getSource()).getScene().getWindow();
        se.setScene(ss);
        se.show();
        
    }

    
}
