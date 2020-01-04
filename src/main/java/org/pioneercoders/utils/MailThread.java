package org.pioneercoders.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailThread implements Runnable{

	String recipient_mail_id=null;
	String subject=null;
	String htmlText = null;
	
	public MailThread(String recipient_mail_id, String subject, String htmlText) {
		this.recipient_mail_id = recipient_mail_id;
		this.subject = subject;
		this.htmlText = htmlText;
	}
	
	@Override
	public void run() {
		try {
			String Email_Id = new FileReadUtil().getProperty("MAIL_FROMADDRESS");
			String password = new FileReadUtil().getProperty("MAIL_PASSWORD");
			String host_name = new FileReadUtil().getProperty("MAIL_HOSTNAME");
			String port = new FileReadUtil().getProperty("MAIL_PORT");
			Properties props = System.getProperties();
			
			props.put("mail.smtp.host", host_name);
			props.put("mail.smtp.user", Email_Id);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");

			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.startssl.enable", "false");

			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			try {
				// Set email data
				message.setFrom(new InternetAddress(Email_Id));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient_mail_id));
				message.setSubject(subject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();

				// HTML mail content
				messageBodyPart.setContent(htmlText, "text/html");
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);

				// Connect to smtp server and send Email
				Transport transport = session.getTransport("smtp");
				transport.connect(host_name, Email_Id, password);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} catch (MessagingException ex) {
				ex.printStackTrace();
				//return 0;
			} catch (Exception ae) {
				ae.printStackTrace();
				//return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			//return 0;
		}
		
		//return 1;
	}
}