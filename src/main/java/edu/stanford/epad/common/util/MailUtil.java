package edu.stanford.epad.common.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	private static final EPADLogger log = EPADLogger.getInstance();

	String host = "localhost";
	String port = "25";
	String username = null;
	String password = null;
	
    public MailUtil(String host, String port, String username, String password) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
    public MailUtil() {
		super();
	}
    
    public void send(String to, String from, String subject, String text)
    {
    	// Get system properties
    	Properties properties = System.getProperties();

	    // Setup mail server
	    properties.setProperty("mail.smtp.host", host);
	    properties.put("mail.smtp.port", port);

	    // Get the default Session object.
	    Session session = null;
	    if (username == null || username.trim().length() == 0)
	    {
	    	session = Session.getDefaultInstance(properties);
	    }
	    else
	    {
	    	properties.put("mail.smtp.auth", "true");
			//properties.put("mail.smtp.starttls.enable", "true");
	 
			session = Session.getInstance(properties,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });	    	
	    }

	    try {
	    	// Create a default MimeMessage object.
	    	MimeMessage message = new MimeMessage(session);
		
	    	// Set From: header field of the header.
	    	message.setFrom(new InternetAddress(from));
		
	    	// Set To: header field of the header.
	    	message.addRecipient(Message.RecipientType.TO,
		                            new InternetAddress(to));
		
	    	// Set Subject: header field
	    	message.setSubject(subject);
		
	    	// Now set the actual message
	    	message.setText(text);
		
	    	// Send message
	    	Transport.send(message);
	    	log.info("Sent message successfully to: " + to + " Subject:" + subject);
	    } catch (MessagingException mex) {
	       mex.printStackTrace();
	    }
    }
}
