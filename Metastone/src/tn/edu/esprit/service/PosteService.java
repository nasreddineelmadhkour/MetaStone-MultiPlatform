/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.service;

import tn.edu.esprit.interfaces.IposteService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.model.Poste;
import tn.edu.esprit.util.MaConnexion;

/**
 *
 * @author ASUS
 */
public class PosteService implements IposteService{
    
    
    
    Connection cnx= MaConnexion.getInstance().getCnx();
    
           
    
  
    
    @Override
    public void ajouterPoste(Poste p) {
       
        String req;
        req = "INSERT INTO `poste`(`Titre`,`Date_poste`,`Contenu`,`Categorie`,`Id_utilisateur`,`Auteur`,`NbreCommentaire`,`nb_react`,`nbreVote`) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst;
            pst = cnx.prepareStatement(req);
            pst.setString(1,p.getTitre());
            pst.setDate(2,p.getDate_poste());
            pst.setString(3,p.getContenu());
            pst.setString(4,p.getCategorie());
            pst.setInt(5,p.getId_utilisateur());
            pst.setString(6,p.getAuteur());
            pst.setInt(7,p.getNbreCommentaire());
            pst.setInt(8,p.getNb_react());
            pst.setInt(9,p.getNbreVote());
            pst.executeUpdate();
            System.out.println("poste ajouté");
        } catch (SQLException ex) {
        }    }

    @Override
    public List<Poste> afficherPoste() {
        //LIST
        List<Poste> postes;
        postes = new ArrayList<>();
        //request 
        String req;
        req = "SELECT * FROM poste";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
              postes.add(new Poste(rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));   
            }
            System.out.println("poste affiché");
            
        }catch(SQLException ex){
        }
        return postes;
        
        
    }

    /**
     *
     * @param Id_poste
     */
    @Override
    public void supprimerPoste(int Id_poste) {
    //request 
        String req="DELETE FROM poste WHERE Id_poste=?";

        try {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,Id_poste);
            pst.executeUpdate();

            System.out.println("poste supprimée");
            
        } catch (SQLException ex) {
        }    }

    
    @Override
    public void modifierPoste(int Id_poste, Poste p) {
        
        //request 
        String req;
        
        req="UPDATE poste SET Contenu= ?,Titre= ? , Categorie=? Date_poste =? WHERE Id_poste=?";

        try 
        {
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,p.getContenu());
            
            pst.setString(2,p.getTitre());
            pst.setString(3,p.getCategorie());
            pst.setDate(4,p.getDate_poste());
            pst.setInt(5,Id_poste);
            
            
            pst.executeUpdate();
            
            System.out.println("modification terminée");
        } 
        catch (SQLException ex) 
        {
        }
         
}
    
      public List<Poste> afficherPosteParCategorie(String Categorie)
    {
        //LIST
        List<Poste> postes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM CARTE WHERE Type like '"+Categorie+"'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                postes.add(new Poste(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10)));
                
            }
            
            
        }catch(SQLException ex){
        }
        return postes;
    }
      public List<Poste> afficherPosteParDate(Date Date_poste)
    {
        //LIST
        List<Poste> postes = new ArrayList<>();
        //request 
        String req ="SELECT * FROM  WHERE Type Date_poste '"+Date_poste+"'";
        try {
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                postes.add(new Poste(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10)));
                
            }
            
            
        }catch(SQLException ex){
        }
        return postes;
    }
      /* public Poste rechercher(int a) throws SQLException {
        Statement ste = cnx.createStatement();
        Poste P=new Poste();
        ResultSet rs = ste.executeQuery("select * from post where id='"+a+"';");
             while (rs.next()) {    
               int id=rs.getInt(1);               
               Date date=rs.getDate(2);
               String type=rs.getString("type");
               String contenu=rs.getString(4);
               String titre=rs.getString(5);
               int id_auteur=rs.getInt(6);
               int nbreacts=rs.getInt(7);
               int nbcomments=rs.getInt(9);
               int nbvotes=rs.getInt(8);
               P.setId_utilisateur(Id_utilisateur);
               P.(id_auteur);
               P.setdate(date);
               P.settype(type);
               P.setcontenu(contenu);
               P.settitre(titre);
               P.setNb_comm(nbcomments);
               P.setNb_react(nbreacts);
               P.setNb_vote(nbvotes);
             }
           
        return P;
    }

    */
   
   /* public List<Poste> showpublicationbyuser(int a) throws SQLException {
        
        List<Poste> arr=new ArrayList<>();
        String req=("select * from poste where id='"+Id_utilisateur+"';");
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                arr.add(new Poste(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10)));
                
            }
        
        }catch(SQLException ex){
        }
    return arr;
    }*/
/*
    public int calculatereacts(int a) throws SQLException {
        int nbreacts = 0;
        ste = con.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT id_post,count(*) AS postcount FROM reaction GROUP BY id_post) as v on p.id = id_post where p.id");
        while (rs.next()) {    
                nbreacts=rs.getInt(1);
        
        }
        return nbreacts;
    }

    
    public int calculateups(int a) throws SQLException {
        int nbups = 0;
        Statement ste = cnx.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT idpub,count(*) AS postcount FROM vote where type=1 GROUP BY idpub) as v on p.id = idpub where p.id='"+a+"';");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }

    public int calculatedowns(int a) throws SQLException {
             int nbups = 0;
        Statement ste = cnx.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT idpub,count(*) AS postcount FROM vote where valeur=2 GROUP BY idpub) as v on p.id = id_post where p.id='"+a+"';");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }

    /**
     *
     * @param UpVote
     * @return
     */


    /*@Override
    public List<Poste> afficherPosteParDate(int UpVote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
}
*/
}
    