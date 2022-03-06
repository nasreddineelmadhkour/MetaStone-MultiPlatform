/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import static java.lang.Double.max;
import static java.lang.Integer.min;
import tn.edu.esprit.service.IcollectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.model.Cartes;

import tn.edu.esprit.model.Collection;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author Moez
 */
public class CollectionService implements IcollectionService {

    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouterCollection(Collection n) {
        //request 
        String req = "INSERT INTO `collection`(`id_utilisateur`, `id_carte` ) "
                + "VALUES (?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, n.getID_UTILISATEUR());
            pst.setInt(2, n.getID_CARTE());
            pst.executeUpdate();
            System.out.println("Collection ajouter avec Succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Collection> afficherCollection(int ID_UTILISATEUR) {

        //LIST
        List<Collection> Collection = new ArrayList<>();
        //request 
        String req = "SELECT * FROM COLLECTION where Id_utilisateur="+ID_UTILISATEUR;
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Collection.add(new Collection(rs.getInt(1), rs.getInt(2), rs.getInt(3)));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collection;
    }

    @Override
    public void supprimerCollection(int ID_COLLECTION) {
        //request 
        String req = "DELETE FROM `collection` WHERE ID_COLLECTION=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, ID_COLLECTION);
            pst.executeUpdate();

            System.out.println("collection Supprime avec Succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifierCollection(int ID_UTILISATEUR, int ID_CARTE, Collection n) {

        //request 
        String req = "UPDATE `collection` SET `Id_utilisateur`=?, `ID_CARTE`=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, ID_UTILISATEUR);
            pst.setInt(2, ID_CARTE);
            pst.executeUpdate();

            System.out.println("modification de collection terminer avec Succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public int fusionnerCollection(int ID_COLLECTION1, int ID_COLLECTION2, int Id_utilisateur) {
        int nombreCartes = 0;boolean test=false;
        String req;
        int idCarte1;
        int idCarte2;
        String carte1 = "";
        String carte2 = "";
       
        String req1 = "SELECT * FROM collection INNER JOIN carte WHERE carte.Id_carte= collection.Id_carte AND (id_collection="+ID_COLLECTION1+" OR id_collection="+ID_COLLECTION2+") AND Id_utilisateur ="+Id_utilisateur;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req1);
            String TypeCarte1,TypeCarte2;
            List<String> cartess = new ArrayList<>();
            
            while (rs.next()) {
                cartess.add(rs.getString("type"));
                
                
            }
            
            
            if(cartess.get(0).equals(cartess.get(1))){
                    test=true;
                    System.out.println(cartess.get(0));
                    System.out.println(cartess.get(1));
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if (test){
        //if (nombreCartes > 1 && carte1.compareTo(carte2) == 0) {
            req = "DELETE FROM `collection` WHERE ID_COLLECTION IN (?,?)";

            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setInt(1, ID_COLLECTION1);
                pst.setInt(2, ID_COLLECTION2);
                pst.executeUpdate();
                System.out.println("C1 C2 supprime avec Succes");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            CartesService cs = new CartesService();
            List<Cartes> cartes = new ArrayList<>();
            cartes = cs.afficherCartes();

            int range = (cartes.size() - 1) + 1;
            int rand = (int) (Math.random() * range);
            System.out.println(cartes);
            System.out.println(rand);
            cartes.indexOf(rand);
            System.out.println(cartes.get(rand));

            req = "INSERT INTO `collection`(`id_utilisateur`,`id_carte`) "
                    + "VALUES (?,?)";

            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setInt(1, Id_utilisateur);
                pst.setInt(2, cartes.get(rand).getID_CARTE());
                pst.executeUpdate();
                System.out.println("CARTE Gagne ajoute avec succee");
                return cartes.get(rand).getID_CARTE();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("Les cartes que vous avez mis n'existe pas dans ta collection");
        }
        
        
        
        
       return -1; //}
    }

    @Override
    public Collection afficheCollection(int id_collection) {

      
        Collection C= new Collection();
        //request 
        String req = "SELECT image FROM `collection` inner join carte where collection.Id_carte=carte.Id_carte and Id_collection="+id_collection;
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                C.setImage(rs.getString(1));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return C;
    }

}
