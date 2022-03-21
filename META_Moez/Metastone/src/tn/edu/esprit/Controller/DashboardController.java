/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.edu.esprit.model.Utilisateur;
import tn.edu.esprit.service.Iservices;
import tn.edu.esprit.service.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class DashboardController implements Initializable {

    @FXML
    private ImageView back_image;
    @FXML
    private TextField back_nom;
    @FXML
    private TextField back_prenom;
    @FXML
    private TextField back_email;
    @FXML
    private TextField back_age;
    @FXML
    private TextField back_tel;
    @FXML
    private TextField back_rank;
    @FXML
    private ListView<AnchorPane> list_collection;
    @FXML
    private Button button_activer;
    @FXML
    private Button button_desactiver;
    @FXML
    private TextField rechercher;
    private Parent fxml;
    private Scene scene;
    private Stage stage;

    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void select(MouseEvent event) throws SQLException {

        System.out.println(((AnchorPane) this.list_collection.getSelectionModel().getSelectedItem()).getId());

        ServiceUtilisateur Su = new ServiceUtilisateur();

        Utilisateur U = Su.getUtilisateur(Integer.parseInt(((AnchorPane) this.list_collection.getSelectionModel().getSelectedItem()).getId()));
        if (U.getEtat().equals("desactiver")) {
            button_activer.setVisible(true);
            button_desactiver.setVisible(false);
        } else {
            button_activer.setVisible(false);
            button_desactiver.setVisible(true);
        }

        back_nom.setText(U.getNom_utilisateur());
        back_email.setText(U.getEmail());
        back_prenom.setText(U.getPrenom());
        back_rank.setText(U.getRank());
        back_tel.setText(U.getTel());
        back_age.setText(U.getAge());
        Image image = new Image(getClass().getResourceAsStream("/tn/edu/esprit/gui/src/" + U.getPhoto_de_profil()));
        back_image.setImage(image);
    }

    private void afficher() throws SQLException {
        this.list_collection.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();

        ServiceUtilisateur Iu = new ServiceUtilisateur();
        System.out.println(Iu.afficher());

        for (int i = 0; i < Iu.afficherUtilisateur().size(); ++i) {
            Utilisateur get = (Utilisateur) Iu.afficherUtilisateur().get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/edu/esprit/gui/Unutilisateur.fxml"));

            try {
                Parent var7 = (Parent) load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            UnutilisateurController uneutilisateurController2 = (UnutilisateurController) load.getController();
            uneutilisateurController2.setIdUtilisateur(get.getID_UTILISATEUR());
            AnchorPane p = new AnchorPane(new Node[]{uneutilisateurController2.getAnchor_utilisateur()});

            uneutilisateurController2.setAge(get.getAge());
            uneutilisateurController2.setAdresse(get.getAdresse());
            uneutilisateurController2.setEmail(get.getEmail());
            uneutilisateurController2.setTel(get.getTel());
            uneutilisateurController2.setSexe(get.getSexe());
            uneutilisateurController2.setRank(get.getRank());
            uneutilisateurController2.setMtc(get.getMtc());
            uneutilisateurController2.setPrenom(get.getPrenom());
            uneutilisateurController2.setNom(get.getNom());
            uneutilisateurController2.setMdp(get.getMot_de_passe());
            uneutilisateurController2.setNom_utilisateur(get.getNom_utilisateur());
            uneutilisateurController2.setPdp(get.getPhoto_de_profil());
            p.setId(Integer.toString(get.getID_UTILISATEUR()));

            p.setStyle("-fx-backgound-color:blue;");

            pubss.add(p);
        }

        this.list_collection.getItems().addAll(pubss);
    }

    @FXML
    private void to_esports(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/backviewoftournoi.fxml"));
        fxml = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void to_carte(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../gui/carte/AfficheCartesAdminForm.fxml"));
        fxml = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void to_merch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../gui/merche/AfficheMercheAdminForm.fxml"));
        fxml = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void to_choaching(ActionEvent event) {
    }

    @FXML
    private void to_forum(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/dashboardforumbackend.fxml"));
        fxml = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void to_demande(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/edu/esprit/gui/DemandeBack.fxml"));
        fxml = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void to_paiement(ActionEvent event) {
    }

    @FXML
    private void activer_compte(ActionEvent event) throws SQLException {
        ServiceUtilisateur US = new ServiceUtilisateur();
        US.activerCompte(Integer.parseInt(((AnchorPane) this.list_collection.getSelectionModel().getSelectedItem()).getId()));
        button_activer.setVisible(false);
        button_desactiver.setVisible(true);
    }

    @FXML
    private void desactiver_compte(ActionEvent event) throws SQLException {
        ServiceUtilisateur US = new ServiceUtilisateur();
        US.desactiverCompte(Integer.parseInt(((AnchorPane) this.list_collection.getSelectionModel().getSelectedItem()).getId()));
        button_activer.setVisible(true);
        button_desactiver.setVisible(false);
    }

    @FXML
    private void chercher(KeyEvent event) throws SQLException {

        this.list_collection.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();

        ServiceUtilisateur Iu = new ServiceUtilisateur();
        System.out.println(Iu.afficher());

        for (int i = 0; i < Iu.rechercher(rechercher.getText()).size(); ++i) {
            Utilisateur get = (Utilisateur) Iu.rechercher(rechercher.getText()).get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/edu/esprit/gui/Unutilisateur.fxml"));

            try {
                Parent var7 = (Parent) load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            UnutilisateurController uneutilisateurController2 = (UnutilisateurController) load.getController();
            uneutilisateurController2.setIdUtilisateur(get.getID_UTILISATEUR());
            AnchorPane p = new AnchorPane(new Node[]{uneutilisateurController2.getAnchor_utilisateur()});

            uneutilisateurController2.setAge(get.getAge());
            uneutilisateurController2.setAdresse(get.getAdresse());
            uneutilisateurController2.setEmail(get.getEmail());
            uneutilisateurController2.setTel(get.getTel());
            uneutilisateurController2.setSexe(get.getSexe());
            uneutilisateurController2.setRank(get.getRank());
            uneutilisateurController2.setMtc(get.getMtc());
            uneutilisateurController2.setPrenom(get.getPrenom());
            uneutilisateurController2.setNom(get.getNom());
            uneutilisateurController2.setMdp(get.getMot_de_passe());
            uneutilisateurController2.setNom_utilisateur(get.getNom_utilisateur());
            uneutilisateurController2.setPdp(get.getPhoto_de_profil());
            p.setId(Integer.toString(get.getID_UTILISATEUR()));

            p.setStyle("-fx-backgound-color:blue;");

            pubss.add(p);
        }
        this.list_collection.getItems().addAll(pubss);

    }

}
