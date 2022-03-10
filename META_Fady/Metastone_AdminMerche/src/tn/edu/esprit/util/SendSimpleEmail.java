/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.util;

/**
 *
 * @author FadyBelY
 */
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
/**
 * This class is used to send simple email.
 * @author w3spoint
 */
public class SendSimpleEmail { 
 final String senderEmailId = "no.eply.metastone@gmail.com";
 final String senderPassword = "FDMDDDLD4";
 final String emailSMTPserver = "smtp.gmail.com";
 
public SendSimpleEmail(String receiverEmail, 
		String subject, String messageText) {	
 
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
        //<new>
        props.put("mail.smtp.starttls.enable", "true");  
	props.put("mail.smtp.host", emailSMTPserver);
        //<new>
        props.put("mail.smtp.port", "587");
        
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
 
}