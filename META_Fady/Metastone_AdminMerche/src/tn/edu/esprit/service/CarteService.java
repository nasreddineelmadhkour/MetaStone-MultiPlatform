/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.model.Carte;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author FadyBelY
 */
public class CarteService {

    Connection cnx = MaConnexion.getInstance().getCnx();

    public List<Carte> afficherCarte() {

        //LIST
        List<Carte> carte = new ArrayList<>();
        //request 
        String req = "SELECT * FROM CARTE";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                carte.add(new Carte(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carte;
    }

}
