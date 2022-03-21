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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class CommentsofpostController implements Initializable {
 Utilisateur u = new Utilisateur();
 Poste p = new Poste();
 String cat= new String();
   private Parent fxml;
        private Scene scene;
        private Stage stage;
        private String categories;
    private GridPane grid;
     private List<Commentaire> comments = new ArrayList<>();
    private MylLstener myListener;

    Commentaire currentcomment;
    @FXML
    private ListView<AnchorPane> lisviewofcomments;
    @FXML
    private ImageView userimage;
    @FXML
    private Label titre;
    @FXML
    private Label description;
    @FXML
    private TextField commentofpost;
    @FXML
    private Button ajoutercommet;
    @FXML
    private Button appliquercomment;
    @FXML
    private Button modifercomment;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lisviewofcomments.getItems().clear();     
      
    }    
    
    
void setUtilisateur(Utilisateur u) 
{
     this.u=u;
    userimage.setImage(new Image(getClass().getResourceAsStream("src/"+u.getPhoto_de_profil())));
}
                    

void setPoste(Poste p) 
{
                     
    this.p=p;
                     
    titre.setText(p.getTitre());
    description.setText(p.getContenu());
    afficherlistofcomments(categories, p);
                         
    System.out.println("this is comments size"+comments.size());
                   
}
                    
void setCategories(String cat)
{
    this.categories=cat;
}
                    
public void afficherlistofcomments(String cat,Poste p)
{      
    this.p=p;
    lisviewofcomments.getItems().clear();     
    
    appliquercomment.setVisible(false);
    modifercomment.setVisible(false);
    commentofpost.setDisable(false);
    
    this.categories=cat;
    
    comments.addAll(getData());
    if (comments.size() > 0) 
    {
        setChosenComment(comments.get(0));
            myListener = new MylLstener() 
            {
            @Override
            public void onClickListener(Poste post) 
            {}

            @Override
            public void onClickListener(Commentaire comment) 
            {
                setChosenComment(comment);
                appliquercomment.setVisible(false);
            }
                
            };
    }   

    try 
        {
         lisviewofcomments.getItems().clear();                 

         for (int i = 0; i < comments.size(); i++) 
         {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("onecommentsview.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            OnecommentsviewController cnecommentsviewController = fxmlLoader.getController();
            cnecommentsviewController.setData(comments.get(i),myListener);
            lisviewofcomments.getItems().add(anchorPane);
         }
    } 
    catch (IOException e) 
    {e.printStackTrace();}
          
          
          
          
}           
     
public void  emptylistview()
{
    this.lisviewofcomments.getItems().clear();
}
@FXML
private void ajoutercommet(ActionEvent event) 
{
    appliquercomment.setVisible(true);
    commentofpost.setText("");
    commentofpost.setDisable(false);
    modifercomment.setVisible(false);
}

@FXML
private void appliquercomment(ActionEvent event) throws IOException 
{
    CommentaireService s = new CommentaireService();
    s.ajouterCommentaire(new Commentaire(commentofpost.getText(),u.getID_UTILISATEUR(), p.getId_poste()));
    Alert a = new Alert(Alert.AlertType.INFORMATION, "votre commentaire est ajouteR");
    a.show();
    lisviewofcomments.getItems().clear();
    afficherlistofcomments(cat, p);            
}

@FXML
private void modifercomment(ActionEvent event) 
{
     CommentaireService s = new CommentaireService();
     s.modifierCommentaire(currentcomment.getId_cmnt(),new Commentaire(commentofpost.getText(),u.getID_UTILISATEUR(), p.getId_poste()));
     Alert a = new Alert(Alert.AlertType.INFORMATION, "votre commentaire est modifier");
    a.show();
    lisviewofcomments.getItems().clear();
    afficherlistofcomments(cat, p);     
}

    
private List<Commentaire> getData()
{
    List<Commentaire> commentaires = new ArrayList<>();
    CommentaireService s = new CommentaireService();
    Commentaire comment1;
    
    for (int i = 0; i < s.afficherCommentaire1(this.p.getId_poste()).size(); i++) 
    {
        Commentaire get = s.afficherCommentaire1(this.p.getId_poste()).get(i);
        comment1 = new Commentaire();
        comment1.setId_poste(get.getId_poste());
        comment1.setCommentaire(get.getCommentaire());
        comment1.setId_cmnt(get.getId_cmnt());
        comment1.setId_utilisateur(get.getId_utilisateur());
   
        comments.add(comment1);  
    }
    return comments;
}
     
     
     
private void setChosenComment(Commentaire comment) 
{
    currentcomment = new Commentaire(comment.getId_cmnt(), comment.getCommentaire(), comment.getId_utilisateur(), comment.getId_poste());
    commentofpost.setText(currentcomment.getCommentaire());
    System.out.println(u.getID_UTILISATEUR());
        
    if (u.getID_UTILISATEUR()==comment.getId_utilisateur())
    {
        commentofpost.setDisable(false);
        modifercomment.setVisible(true);

    }
    else
    {
        commentofpost.setDisable(true);
        modifercomment.setVisible(false);
    }
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
