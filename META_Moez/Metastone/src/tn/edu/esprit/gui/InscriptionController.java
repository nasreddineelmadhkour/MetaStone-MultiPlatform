/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import static java.awt.PageAttributes.MediaType.A;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.Z;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button button_inscrire;
    private Parent fxml;
    private Scene scene;
    private Stage stage;
    private Button button_homme;
    private Button button_femme;
    @FXML
    private Label label_homme;
    @FXML
    private Label label_femme;
    @FXML
    private TextField inscription_nom;
    @FXML
    private TextField inscription_prenom;
    @FXML
    private TextField inscription_adresse;
    @FXML
    private TextField inscription_tel;
    @FXML
    private TextField inscription_email;
    @FXML
    private TextField inscription_nom_utilisateur;
    @FXML
    private PasswordField inscription_mdp;
    @FXML
    private DatePicker inscription_date_nais;
    @FXML
    private Label label_vTurenom;
    @FXML
    private Label label_vTureprenom;
    @FXML
    private Label label_vTuredatenais;
    @FXML
    private Label label_vTureadresse;
    @FXML
    private Label label_vTuretel;
    @FXML
    private Label label_vTureemail;
    @FXML
    private Label label_vTurenomutilisateur;
    @FXML
    private Label label_vTurempd;
    @FXML
    private Label label_vFalsenom;
    @FXML
    private Label label_vFalseprenom;
    @FXML
    private Label label_vFalsedatenais;
    @FXML
    private Label label_vFalseadresse;
    @FXML
    private Label label_vFalsetel;
    @FXML
    private Label label_vFalseemail;
    @FXML
    private Label label_vFalsenomutilisateur;
    @FXML
    private Label label_vFalsempd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show(); 
    }

    @FXML
    private void enable_homme(ActionEvent event) {
         label_homme.setDisable(false);
         label_femme.setDisable(true);
        
    }

    @FXML
    private void enable_femme(ActionEvent event) {
         label_homme.setDisable(true);
         label_femme.setDisable(false);
    }

    @FXML
    private void inscription(ActionEvent event) throws SQLException {
        

        if(verif())
        {
            Iservices USER=new ServiceUtilisateur();
            Utilisateur U=new Utilisateur();
            U.setMot_de_passe(inscription_mdp.getText());
            U.setEmail(inscription_email.getText());
            U.setNom(inscription_nom.getText());
            U.setPrenom(inscription_prenom.getText());
                if(label_homme.isDisable())
            U.setSexe("Femme");
                else
            U.setSexe("Homme");
            U.setNom_utilisateur(inscription_nom_utilisateur.getText());
            U.setDate_naiss(inscription_date_nais.getValue().toString());
            U.setAdresse(inscription_adresse.getText());
            U.setTel(inscription_tel.getText());
            U.setPhoto_de_profil("URL");
            U.setRole("utilisateur");
            U.setMtc("0");
            U.setId_consommateur("0");
            U.setRank("Bronze");
            //USER.ajouter(U);
                
            
        }
        
        
    }
    private boolean verif(){
      
        boolean Test=true;
        
       if(inscription_date_nais.isManaged())
       {    label_vTuredatenais.setVisible(true);label_vFalsedatenais.setVisible(false);}
       else{label_vTuredatenais.setVisible(false);label_vFalsedatenais.setVisible(true);Test=false;}
       
       if(isAlpha(inscription_nom.getText()))
       {label_vTurenom.setVisible(true);label_vFalsenom.setVisible(false);}
       else 
       {label_vTurenom.setVisible(false);label_vFalsenom.setVisible(true);Test=false;}
       
       if(isAlpha(inscription_prenom.getText()))
       {     label_vTureprenom.setVisible(true);label_vFalseprenom.setVisible(false);}
       else {label_vFalseprenom.setVisible(true);label_vTureprenom.setVisible(false);Test=false;}
       
       
       if(isAdresse(inscription_adresse.getText()))
       {label_vTureadresse.setVisible(true);label_vFalseadresse.setVisible(false);}
       else{label_vTureadresse.setVisible(false);label_vFalseadresse.setVisible(true);Test=false;}
       
       if(isNumber(inscription_tel.getText()))
       {     label_vTuretel.setVisible(true);label_vFalsetel.setVisible(false);}
       else {label_vTuretel.setVisible(false);label_vFalsetel.setVisible(true);Test=false;}
       
       if(isEmail(inscription_email.getText()))
       {     label_vTureemail.setVisible(true);label_vFalseemail.setVisible(false);}
       else{ label_vTureemail.setVisible(false);label_vFalseemail.setVisible(true);Test=false;}
       
       if(isNom_Utilisateur(inscription_nom_utilisateur.getText()))
       {     label_vTurenomutilisateur.setVisible(true);label_vFalsenomutilisateur.setVisible(false);}
       else {label_vTurenomutilisateur.setVisible(false);label_vFalsenomutilisateur.setVisible(true);Test=false;}
        
       if(isMdp(inscription_mdp.getText()))
       {     label_vTurempd.setVisible(true);label_vFalsempd.setVisible(false);}
       else{ label_vTurempd.setVisible(false);label_vFalsempd.setVisible(true);Test=false;}
       
       
       return Test;
    }
    
    private boolean isAlpha(String chaine){
    
        return chaine.matches("[a-zA-Z- -]+");

    }
    
    private boolean isAdresse(String chaine){
    
        return chaine.matches("[a-zA-Z- 0-9]+");

    }
    
    private boolean isNumber(String chaine){
    
        if(chaine.length()==0)
            return false;
        for (int i = 0; i < chaine.length(); i++) {
            if (!Character.isDigit(chaine.charAt(i))) {
                return false;
            }
        }
    return true;
    }
    
    public  boolean isEmail(String chaine){
    return chaine.matches(".+@.+\\.[a-z]+");
 
}
    
    private boolean isNom_Utilisateur(String chaine){
    
        return chaine.matches("[a-zA-Z-0-9]+");
    }
    private boolean isMdp(String chaine){
        if(chaine.length()<6)
            return false;
        return chaine.matches("[a-zA-Z-0-9]+");
    }
    
}
