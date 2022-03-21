/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui.merche;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.interfaces.MyListener;
import tn.edu.esprit.model.Merche;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
public class ProductsController implements Initializable {

    @FXML
    private Label nomProd;
    @FXML
    private Label prixProd;
    @FXML
    private Label descriptionProd;
    @FXML
    private Label typeProd;
    @FXML
    private Label quantiteProd;
    private Merche m;
    private MyListener myListener;
    @FXML
    private ImageView imgProd;
    @FXML
    private Label id_prod;

    /**
     * Initializes the controller class.
     */
        public void setData(Merche m,MyListener myListener) {
        this.m = m;
        
        this.myListener = myListener;
        nomProd.setText(m.getNom_produit());
        typeProd.setText(m.getType_produit());
       // Image image = new Image(getClass().getResourceAsStream(m.getImage_produit()));
        
        //imgProd.setImage(image);
        prixProd.setText(Integer.toString(m.getPrix_produit()));
        //tailleProd.setText(Integer.toString(m.getTaille_produit()));
        descriptionProd.setText(m.getDescription_produit());
        quantiteProd.setText(Integer.toString(m.getQuantite_produit()));
        //idProd.setText(Integer.toString(m.getId_produit()));
        id_prod.setText(Integer.toString(m.getId_produit()));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(m);
    }
    
}
