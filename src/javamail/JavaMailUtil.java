package javamail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

	public static void sendMail1(String recepient) throws Exception {
		System.out.println(recepient);
	}
	
	public static void sendMail(String recepient) throws Exception {
		System.out.println("Preparing Email to be sent!!!");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		String myAccountEmail="ittasaiabishek@gmail.com";
		String password="06July00@c";
		System.out.println("before session");
		
		Session session = Session.getDefaultInstance(properties,
			    new Authenticator() {
			        protected PasswordAuthentication  getPasswordAuthentication() {
			        return new PasswordAuthentication(
			                    "ittasaiabishek@gmail.com", "06July00@c");
			                }
			    });
		
		System.out.println("before message");
		System.out.println(session);
		Message message=prepareMessage(session,myAccountEmail,recepient);
		Transport.send(message);
		System.out.println("Mail sent succesfully!@!!");
	}
	
	private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
		try {
		Message message = new MimeMessage(session );
		message.setFrom(new InternetAddress(myAccountEmail));
		message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
		message.setSubject("OORJA BILL ALERT SYSTEM");
		message.setText("Testing the alert system !!! 1223893");
		return message;
		}catch(Exception er) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,er);
		}
		return null;
	}
	
	
}
