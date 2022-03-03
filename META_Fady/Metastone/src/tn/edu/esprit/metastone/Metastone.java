/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.metastone;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.edu.esprit.interfaces.ImercheService;
import tn.edu.esprit.model.Commande;
import tn.edu.esprit.service.MercheService;
import tn.edu.esprit.util.MaConnexion;
import tn.edu.esprit.model.Merche;
import tn.edu.esprit.service.CommandeService;

/**
 *
 * @author FadyBelY
 */
public class Metastone {
/*
    final String senderEmailId = "no.eply.metastone@gmail.com";
    final String senderPassword = "FDMDDDLD4";
    final String emailSMTPserver = "smtpout.secureserver.net";

    /**
     * @param receiverEmail
     * @param args the command line arguments
     */
    /*
    public Metastone(String receiverEmail,
            String subject, String messageText) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtpout.secureserver.net");
        //
        

        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmailId));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            System.out.println("Email send successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in sending email.");
        }
    }

    private class SMTPAuthenticator extends
            javax.mail.Authenticator {

        public PasswordAuthentication
                getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailId,
                    senderPassword);
        }
    }
*/
    public static void main(String[] args) throws SQLException {
        Connection cnx = MaConnexion.getInstance().getCnx();
        
        MercheService merche = new MercheService();
        CommandeService commande = new CommandeService();
        
        
        
        
        
        
//               ************* TEST DU CODE - VALIDATION 1 *************
       
        //Merche m = new Merche("Nom_produit", prix , "Description_produit", "Type_produit", taille, qt);
    //ajout
        //merche.ajouterMerche(m);
    //modifier
        //merche.modifierMerche(m, id_produit);
    //supprimer
        //merche.SupprimerMerche(id prod);
    //acheter
       // merche.acheterMerche(id_produit, id_user, qt);
    //affichage normal
        //merche.afficherMerche();
    //affichage par nom (recherche)
        //System.out.println(merche.afficherMercheParNom(Nom_produit));
    //affichage par type (filtre)
        //System.out.println(merche.afficherMercheParType(Type_produit));
    //affichage par prix (filtre)
        //System.out.println(merche.afficherMercheParPrix(bool_croissante));
    
    //Commande c = new Commande(Type_paiement, Date_commande, prix_tot, Adresse, Date_livraison, id_user, id_prod);
    //ajout
        //commande.ajouterCommande(c, id_user);
    //supprimer
        //commande.supprimerCommande(id_user, false);
    //supprimer tout
        //commande.supprimerTout(id_user);
    //afficher tout
        //commande.afficherToutLesCommande();
    //afficher par user
        //commande.afficherCommande(id_user);
       
        
//              ************* FIN DU TEST DU CODE - VALD 1 *************
        
















        //commande.supprimerCommande(35,false);
        //commande.supprimerTout(1);
       
        //Merche m = new Merche("Jacket1",16,"jacket noir metastone","NULL",2,1);
        //merche.ajouterMerche(m);
        //commande.supprimerCommande(40);
        //merche.abonnementMerche(1);
        //System.out.println(merche.afficherMercheParPrix(false));
        //merche.acheterMerche(6, 1, 1);
        
        /*
        // TODO code application logic here
        Merche m = new Merche("Produit 0",5,"Testing","NULL",2);
        MercheService merche = new MercheService();
        //merche.ajouterMerche(m);
        System.out.println(merche.afficherMerche());
        Commande c = new Commande();
        CommandeService commande = new CommandeService();
        System.out.println(commande.afficherCommande(3));
         */
    }

}
