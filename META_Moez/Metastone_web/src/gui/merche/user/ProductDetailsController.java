/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.merche.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.MercheService;

/**
 * FXML Controller class
 *
 * @author FadyBelY
 */
/*


*/
public class ProductDetailsController implements Initializable {

    @FXML
    private Label qteP;
    @FXML
    private Label prixP;
    @FXML
    private Label nomP;
    @FXML
    private Label descP;
    @FXML
    private ImageView img;
    
    private int qt;
    private int prix;
    private Merche m;
    @FXML
    private Label typeP;
    
        public void setData(Merche m) {
        this.m = m;
        nomP.setText("Nom: "+m.getNom_produit());
        typeP.setText(" -"+m.getType_produit());
        descP.setText(" -"+m.getDescription_produit());
        if(m.getQuantite_produit() > 1)
        {
            qteP.setText(Integer.toString(qt));
        }
        else{
            qteP.setLayoutX(610);
            qteP.setText("Hors stock");
        }
        prix = m.getPrix_produit();
        prix = prix * qt;
        prixP.setText(Integer.toString(prix));
                

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qt = 1;
        prix = 1;
       
    }

    @FXML
    private void addQt(ActionEvent event) {
        if(m.getQuantite_produit() > qt)
        {
            qt++;
            setData(m);
        }
        
    }

    @FXML
    private void removeQt(ActionEvent event) {
        if(qt > 1)
        {
            qt--;
            setData(m);
        }
        
    }

    @FXML
    private void buyProduct(ActionEvent event) {
        MercheService merche = new MercheService();
        int id_prod = m.getId_produit();
        int id_user = 1;
        merche.acheterMerche(id_prod, id_user, qt);
        m.setQuantite_produit(m.getQuantite_produit()-qt);
        setData(m);
    }
    
}
