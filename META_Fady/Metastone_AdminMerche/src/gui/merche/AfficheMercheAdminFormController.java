/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.merche;

//import java.awt.Insets;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import tn.edu.esprit.interfaces.MyListener;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.MercheService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AfficheMercheAdminFormController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    private List<Merche> mercheList = new ArrayList<>();
    private String parNom = "";
    @FXML
    private TextField tfSearch;
    @FXML
    private Label idProd_ch;
    @FXML
    private ImageView imgProd_ch;
    @FXML
    private TextField nomProd_ch;
    @FXML
    private TextField tailleProd_ch;
    @FXML
    private TextField typeProd_ch;
    @FXML
    private TextField prixProd_ch;
    @FXML
    private TextField quantiteProd_ch;
    @FXML
    private TextArea descriptionProd_ch;
    private MyListener myListener;
    @FXML
    private Button bAjouter;
    private String nom = "";
    @FXML
    private ChoiceBox<String> filtre;
    private boolean chosen;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private Button bProd;

    private void setChosenProd(Merche m) {
        if (nom.compareTo("") == 0) {
            nomProd_ch.setText(m.getNom_produit());
            tailleProd_ch.setText(Integer.toString(m.getTaille_produit()));
            prixProd_ch.setText(Integer.toString(m.getPrix_produit()));
            quantiteProd_ch.setText(Integer.toString(m.getQuantite_produit()));
            descriptionProd_ch.setText(m.getDescription_produit());
            idProd_ch.setText(Integer.toString(m.getId_produit()));
            // image = new Image(getClass().getResourceAsStream(m.getImage_produit()));
            // imgProd_ch.setImage(image);
            typeProd_ch.setText(m.getType_produit());
            idProd_ch.setText(Integer.toString(m.getId_produit()));
            nom = m.getNom_produit();
            chosen = true;
            bAjouter.setDisable(true);
            bModifier.setDisable(false);
            bSupprimer.setDisable(false);

        } else {
            nomProd_ch.setText("");
            tailleProd_ch.setText("");
            prixProd_ch.setText("");
            quantiteProd_ch.setText("");
            descriptionProd_ch.setText("");
            idProd_ch.setText("");
            // image = new Image(getClass().getResourceAsStream(m.getImage_produit()));
            // imgProd_ch.setImage(image);
            typeProd_ch.setText("");
            idProd_ch.setText("id");
            nom = "";
            chosen = false;
            bAjouter.setDisable(false);
            bModifier.setDisable(true);
            bSupprimer.setDisable(true);
        }

    }

    public void Update(String nomProd) {
        Merche m;
        MercheService merche = new MercheService();
        mercheList.clear();
        grid.getChildren().clear();
        mercheList.addAll(merche.afficherMercheParNom(parNom));
        myListener = new MyListener() {
            @Override
            public void onClickListener(Merche m) {
                setChosenProd(m);

            }
        };

        int c = 0;
        int l = 0;
        try {
            for (int i = 0; i < mercheList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("products.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ProductsController productController = fxmlLoader.getController();
                productController.setData(mercheList.get(i), myListener);
                if (c > 2) {
                    c = 0;
                    l++;
                }
                grid.add(anchorPane, c++, l);
                //grid weight
                grid.setMinWidth(200);
                grid.setPrefWidth(200);
                grid.setMaxWidth(200);//
                //height
                grid.setMinHeight(303);
                grid.setPrefHeight(303);
                grid.setMaxHeight(303);//
                grid.setLayoutY(20);

                
                GridPane.setMargin(anchorPane, new Insets(150, 0, 20, 40));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bProd.setDisable(true);
        bAjouter.setDisable(false);
        bModifier.setDisable(true);
        bSupprimer.setDisable(true);
        filtre.getItems().add("Nom");
        filtre.getItems().add("Type");
        filtre.getItems().add("Taille");
        
       
        nom = nomProd_ch.toString();
        parNom = "";
        Update(parNom);
    }

    @FXML
    private void AJOUTER(ActionEvent event) {
        MercheService merche = new MercheService();
        Alert alert = new Alert(AlertType.INFORMATION);
        String nomProd = nomProd_ch.getText();
        int tailleProd = Integer.parseInt(tailleProd_ch.getText());
        String typeProd = typeProd_ch.getText();
        int prix = Integer.parseInt(prixProd_ch.getText());
        int quantiteProd = Integer.parseInt(quantiteProd_ch.getText());
        String descriptionProd = descriptionProd_ch.getText();
        Merche m = new Merche(nomProd, prix, descriptionProd, typeProd, tailleProd, quantiteProd);

        try {
            merche.ajouterMerche(m);
            alert.setAlertType(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Ajouter!");
            alert.setContentText("Merche Ajouter avec success!");
            parNom = "";
            Update(parNom);
        } catch (SQLException ex) {
            alert.setAlertType(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Add error!");
            alert.setContentText(ex.getMessage());

        } finally {
            alert.showAndWait();

        }

    }

    @FXML
    private void MODIFIER(ActionEvent event) throws SQLException {
        Merche m = new Merche(nomProd_ch.getText(), Integer.parseInt(prixProd_ch.getText()), descriptionProd_ch.getText(), typeProd_ch.getText(), Integer.parseInt(tailleProd_ch.getText()), Integer.parseInt(quantiteProd_ch.getText()));
        MercheService merche = new MercheService();
        int id = Integer.parseInt(idProd_ch.getText());
        merche.modifierMerche(m, id);
        mercheList.clear();
        grid.getChildren().clear();
        parNom = "";
        Update(parNom);
    }

    @FXML
    private void SUPPRIMER(ActionEvent event) {
        MercheService merche = new MercheService();
        int id_prod = Integer.parseInt(idProd_ch.getText());
        merche.SupprimerMerche(id_prod);
        mercheList.clear();
        grid.getChildren().clear();
        parNom = "";
        Update(parNom);
    }

    @FXML
    private void search(ActionEvent event) {

        parNom = tfSearch.getText();
        Update(parNom);
    }

    @FXML
    private void GoToCommande(ActionEvent event) throws IOException {
        URL fxURL = getClass().getResource("AfficheCommandeAdminForm.fxml");
        FXMLLoader loader = new FXMLLoader(fxURL);
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Metastone - Merche");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
