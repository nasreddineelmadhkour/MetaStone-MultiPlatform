/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class UnutilisateurController implements Initializable {

    @FXML
    private AnchorPane anchor_utilisateur;
    private int id_utilisateur;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label age;
    @FXML
    private Label email;
    @FXML
    private Label tel;
    @FXML
    private Label adresse;
    @FXML
    private Label nom_utilisateur;
    @FXML
    private PasswordField mdp;
    @FXML
    private Label sexe;
    @FXML
    private Label rank;
    @FXML
    private Label mtc;
    @FXML
    private ImageView pdp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public AnchorPane getAnchor_utilisateur() {
        return anchor_utilisateur;
    }

    public void setAnchor_utilisateur(AnchorPane anchor_utilisateur) {
        this.anchor_utilisateur = anchor_utilisateur;
    }

    void setIdUtilisateur(int id_utilisateur) {
        this.id_utilisateur=id_utilisateur;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    
    
    
    
    
    
    public void setNom(String nom) {
        this.nom.setText(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom.setText(prenom);
    }

    public void setAge(String age) {
        this.age.setText(age);
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    public void setTel(String tel) {
        this.tel.setText(tel);
    }

    public void setAdresse(String adresse) {
        this.adresse.setText(adresse);
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur.setText(nom_utilisateur);
    }

    public void setMdp(String mdp) {
        this.mdp.setText(mdp);
    }

    public void setSexe(String sexe) {
        this.sexe.setText(sexe);
    }

    public void setRank(String rank) {
        this.rank.setText(rank);
    }

    public void setMtc(String mtc) {
        this.mtc.setText(mtc);
    }
    public void setPdp(String pdp){
        Image image = new Image(getClass().getResourceAsStream("/tn/edu/esprit/gui/src/"+pdp));
        this.pdp.setImage(image);
    }

}
