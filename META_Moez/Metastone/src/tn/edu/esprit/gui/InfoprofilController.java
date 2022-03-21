/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class InfoprofilController implements Initializable {
        Utilisateur u = new Utilisateur();
        private Parent fxml;
        private Scene scene;
        private Stage stage;
    @FXML
    private TextField profil_nom;
    @FXML
    private TextField profil_prenom;
    @FXML
    private TextField profil_email;
    @FXML
    private TextField profil_adresse;
    @FXML
    private TextField profil_tel;
    @FXML
    private TextField profil_nom_utilisateur;
    @FXML
    private TextField profil_age;
    @FXML
    private PasswordField profil_mdp;
    @FXML
    private Label profil_mtc;
    @FXML
    private Button button_modifier;
    @FXML
    private Button button_save;
    @FXML
    private Button button_quitter;
    @FXML
    private Button annuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setUtilisateur(Utilisateur u) {
        this.u=u;
        profil_nom.setText(u.getNom());
        profil_prenom.setText(u.getPrenom());
        profil_age.setText(u.getAge());
        profil_mtc.setText(u.getMtc());
        profil_nom_utilisateur.setText(u.getNom_utilisateur());
        profil_email.setText(u.getEmail());
        profil_mdp.setText(u.getMot_de_passe());
        profil_tel.setText(u.getTel());
        profil_adresse.setText(u.getAdresse());
        
        profil_adresse.setDisable(true);
        profil_age.setDisable(true);
        profil_email.setDisable(true);
        profil_mdp.setDisable(true);
        profil_nom.setDisable(true);
        profil_nom_utilisateur.setDisable(true);
        profil_prenom.setDisable(true);
        profil_tel.setDisable(true);
        
    }

    @FXML
    private void modifier(ActionEvent event) {
           profil_adresse.setDisable(false);
           profil_age.setDisable(false);
           profil_email.setDisable(false);
           profil_mdp.setDisable(false);
           profil_nom.setDisable(false);
           profil_prenom.setDisable(false);
           profil_tel.setDisable(false); 
           button_save.setVisible(true);
           button_save.setDisable(false);
           annuler.setVisible(true);

    }

    @FXML
    private void modifier_terminer(ActionEvent event) throws SQLException {
        Iservices USER=new ServiceUtilisateur();
        this.u.setNom(profil_nom.getText());
        this.u.setAdresse(profil_adresse.getText());
        this.u.setEmail(profil_email.getText());
        this.u.setPrenom(profil_prenom.getText());
        this.u.setMot_de_passe(profil_mdp.getText());
        this.u.setTel(profil_tel.getText());
        this.u.setAge(profil_age.getText());
           
           profil_adresse.setDisable(true);
           profil_age.setDisable(true);
           profil_email.setDisable(true);
           profil_mdp.setDisable(true);
           profil_nom.setDisable(true);
           profil_prenom.setDisable(true);
           profil_tel.setDisable(true); 
           button_save.setDisable(true);
           button_save.setVisible(false);
           annuler.setVisible(false);

        USER.modifier(u, this.u.getID_UTILISATEUR());
        
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
             fxml=loader.load(); 
             HomeController homecontroller=loader.getController();
             homecontroller.setUtilisateur(this.u);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
    }

    @FXML
    private void go_game(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
             fxml=loader.load(); 
             ProfilController profilController=loader.getController();
             profilController.setUtilisateur(u);

             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        
    }

    @FXML
    private void button_annuler(ActionEvent event) {
        profil_adresse.setDisable(true);
           profil_age.setDisable(true);
           profil_email.setDisable(true);
           profil_mdp.setDisable(true);
           profil_nom.setDisable(true);
           profil_prenom.setDisable(true);
           profil_tel.setDisable(true); 
           button_save.setVisible(false);
           button_save.setDisable(true);
           annuler.setVisible(false);
           
    }
    
}
