/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui.merche.user;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.MercheService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class AfficheMercheUserFormController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

private List<Merche> mercheList = new ArrayList<>();

    public void Update() {
        Merche m;
        MercheService merche = new MercheService();
        mercheList.clear();
        grid.getChildren().clear();
        mercheList.addAll(merche.afficherMerche());
        int c = 1;
        int l = 1;
        try {
            for (int i = 0; i < mercheList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ProductDetails.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ProductDetailsController productController = fxmlLoader.getController();
                productController.setData(mercheList.get(i));
                if (c > 1) {
                    c = 1;
                    l++;
                }
                grid.add(anchorPane, c++, l);
                //grid weight
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);//
                //height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);//
                //grid.setLayoutY(20);

                GridPane.setMargin(anchorPane, new Insets(0, 0, 0, 0));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Update();
    }


}

/*
 
*/