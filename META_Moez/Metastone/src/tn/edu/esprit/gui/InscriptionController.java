/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.stripe.exception.StripeException;
import static java.awt.PageAttributes.MediaType.A;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.Z;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;
import tn.edu.esprit.service.StripeClass;

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
    @FXML
    private TextField inscription_age;
    @FXML
    private Label label_vTurempd1;
    @FXML
    private Label label_vFalsempd1;
    @FXML
    private PasswordField inscription_mdp1;
    
    FileChooser fileChooser = new FileChooser();
    @FXML
    private TextField inscription_photo;
    @FXML
    private ImageView imageview_pdp;
    @FXML
    private Label label_vTurepdp;
    @FXML
    private Label label_vFalsepdp;
    @FXML
    private TextField mdp_show;
    @FXML
    private TextField mdp_show1;

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
             stage.centerOnScreen();scene.setFill(Color.TRANSPARENT);
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
    private void inscription(ActionEvent event) throws SQLException, IOException, StripeException {
        

        if(verif())
        {
            
             StripeClass sc = new StripeClass();
        String customerId = sc.makeCustomerIdForUser();
            System.out.println(customerId);
        //String intentId = sc.createPaymentIntent(50/*MTC */,customerId);
        //Boolean status = sc.payOrder(intentId);
        /*
        if(status == true)
        chargeMTC => Mtc + demanded
         */
            ServiceUtilisateur USER=new ServiceUtilisateur();
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
            U.setAge(inscription_age.getText().toString());
            U.setAdresse(inscription_adresse.getText());
            U.setTel(inscription_tel.getText());
            U.setPhoto_de_profil(inscription_photo.getText());
            U.setRole("utilisateur");
            U.setMtc("0");
            U.setId_consommateur(customerId.toString());
            U.setRank("Bronze");
            USER.ajouter(U);
                
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
             fxml=loader.load(); 
             HomeController homecontroller=loader.getController();
             U=USER.getUtilisateur(inscription_nom_utilisateur.getText());
             homecontroller.setUtilisateur(U);
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene(fxml);
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show();
        }
        
        
    }
    private boolean verif(){
      
        boolean Test=true;
     if(!inscription_photo.getText().equals(""))
     {     label_vTurepdp.setVisible(true);label_vFalsepdp.setVisible(false);}
     else{ label_vTurepdp.setVisible(false);label_vFalsepdp.setVisible(true);}
     
     if(isNumber(inscription_age.getText().toString()) && inscription_age.getText().length()<3)
     {  if(Integer.parseInt(inscription_age.getText().toString())>12)
        {label_vTuredatenais.setVisible(true);label_vFalsedatenais.setVisible(false);}
        else{label_vTuredatenais.setVisible(false);label_vFalsedatenais.setVisible(true);Test=false;}
     }
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
       if(isMdp(inscription_mdp1.getText()) && inscription_mdp.getText().toString().equals(inscription_mdp1.getText().toString()))
       {     label_vTurempd1.setVisible(true);label_vFalsempd1.setVisible(false);}
       else{ label_vTurempd1.setVisible(false);label_vFalsempd1.setVisible(true);Test=false;}
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

    @FXML
    private void Choser_image(ActionEvent event) {
        FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("image", new String[]{"*.png"});
        this.fileChooser.getExtensionFilters().add(fileExtensions);
        File file = this.fileChooser.showOpenDialog(new Stage());
        
        this.inscription_photo.setText(file.getName());
        System.out.println(file.getName().toString());

            Image image = new Image(file.toURI().toString());
            imageview_pdp.setImage(image);
            imageview_pdp.setFitWidth(100);
            imageview_pdp.setFitHeight(122);
        
    }

    @FXML
    private void show_password(ActionEvent event) {
        System.out.println("hello");
        mdp_show.setVisible(true);
        mdp_show1.setVisible(true);
        mdp_show.setText(inscription_mdp.getText());
        mdp_show1.setText(inscription_mdp1.getText());
        inscription_mdp1.setVisible(false);
        inscription_mdp.setVisible(false);
    }

    @FXML
    private void disable_show_mdp(MouseEvent event) {
        mdp_show.setVisible(false);
        mdp_show1.setVisible(false);
        inscription_mdp.setText(mdp_show.getText());
        inscription_mdp1.setText(mdp_show1.getText());
        inscription_mdp1.setVisible(true);
        inscription_mdp.setVisible(true);
        
    }
    
}
